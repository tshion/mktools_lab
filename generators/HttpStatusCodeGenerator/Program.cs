// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;

try
{
    Console.WriteLine("Start");
    var basePath = Directory.GetCurrentDirectory();
    var dataBasePath = Path.Combine(basePath, "Data");


    // CSV の読み込み
    var queryCsvBody = CsvEntity.GetDataQueryOrNull(Path.Combine(dataBasePath, "HttpStatusCode.csv"));
    if (queryCsvBody == null)
    {
        Console.WriteLine("Finish: Not enough.");
        return;
    }


    // 置換文字列の辞書作成
    var queryRenameWords = WordEntity.GetDataQueryOrNull(Path.Combine(dataBasePath, "ReplaceDictionary.csv"));
    ImmutableDictionary<string, string> renameWords = queryRenameWords != null
        ? queryRenameWords.ToImmutableDictionary(item => item.Target, item => item.Rename)
        : ImmutableDictionary<string, string>.Empty;


    // データの解析
    var data = queryCsvBody
        .Select(item => CodeEntity.ParseOrNull(item, renameWords))
        .Where(item => item != null)
        .ToList();


    // 出力先のディレクトリ再作成
    var outputBasePath = Path.Combine(basePath, "DataOutput");
    if (Directory.Exists(outputBasePath))
    {
        Directory.Delete(outputBasePath, true);
    }
    Directory.CreateDirectory(outputBasePath);


    // コード生成
    var templatePaths = new[] { "cs" }
        .Select(ext => TemplatePathEntity.ParseOrNull(basePath, ext))
        .Where(item => item != null)
        .ToList();
    foreach (var item in templatePaths)
    {
        var itemFile = File.ReadAllText(item.ItemPath);
        var itemList = new List<string>();
        foreach (var target in data)
        {
            var links = target.Links
                .Select(link => $"        ///     <item><see href=\"{link.Url}\">{link.Title}</see></item>");

            var warning = !string.IsNullOrWhiteSpace(target.Warning)
                ? $"[ObsoleteAttribute(\"{target.Warning}\")]{Environment.NewLine}        "
                : "";

            var words = new List<string>();
            for (int i = 0; i < target.MemberWords.Length; i++)
            {
                var word = target.MemberWords[i];
                words.Add(
                    i == 0 && word.Length < 2
                        ? word.ToUpper()
                        : $"{char.ToUpper(word[0])}{word[1..]}"
                );
            }

            itemList.Add($"{itemFile}"
                .Replace("%%DOCS_LINKS%%", string.Join(Environment.NewLine, links))
                .Replace("%%DOCS_TITLE%%", target.Title)
                .Replace("%%MEMBER_NAME%%", string.Join("", words))
                .Replace("%%MEMBER_VALUE%%", target.MemberValue.ToString())
                .Replace("%%WARNING%%", warning)
            );
        }

        var rootFile = File.ReadAllText(item.RootPath);
        rootFile = rootFile.Replace("%%ITEMS%%", string.Join($"{Environment.NewLine}{Environment.NewLine}", itemList));
        if (data.Any(x => !string.IsNullOrWhiteSpace(x.Warning)))
        {
            rootFile = $"using System;{Environment.NewLine}{Environment.NewLine}{rootFile}";
        }
        await File.WriteAllTextAsync(Path.Combine(outputBasePath, item.OutputFilename), rootFile);
    }


    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
