// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;
using System.Text;

try
{
    Console.WriteLine("Start");
    var basePath = Directory.GetCurrentDirectory();
    var dataBasePath = Path.Combine(basePath, "Data");


    // テンプレートファイルの読み込み
    List<TemplateEntity> templates = new[] { "cs" }
        .Select(ext => TemplateEntity.LoadOrNull(
            basePath: Path.Combine(basePath, "Templates"),
            fileExtension: ext,
            indent: 4
        ))
        .Where(item => item != null)
        .Select(item => item!)
        .ToList();
    if (!templates.Any())
    {
        Console.WriteLine("Finish: None targets.");
        return;
    }


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
    foreach (var template in templates)
    {
        List<string> items = new();
        var shouldAddImport = false;
        foreach (var item in data)
        {
            // TODO: null 伝搬の見直し
            if (item == null)
            {
                continue;
            }

            // TODO: 各言語固有設定の分離
            var links = item.Links
                .Select(link => $"{template.Indent}{template.Indent}///{template.Indent}<item><see href=\"{link.Url}\">{link.Title}</see></item>");

            string? warning = null;
            if (!string.IsNullOrWhiteSpace(item.Warning))
            {
                shouldAddImport = true;
                warning = $"[ObsoleteAttribute(\"{item.Warning}\")]{Environment.NewLine}{template.Indent}{template.Indent}";
            }

            StringBuilder builder = new();
            for (int i = 0; i < item.MemberWords.Length; i++)
            {
                string word = item.MemberWords[i];
                builder.Append(i == 0 && word.Length < 2
                    ? word.ToUpper()
                    : $"{char.ToUpper(word[0])}{word[1..]}"
                );
            }

            items.Add(template.GetItemText(
                linkText: string.Join(Environment.NewLine, links),
                memberName: builder.ToString(),
                memberValue: $"{item.MemberValue}",
                title: item.Title,
                warning: warning ?? ""
            ));
        }


        string header = shouldAddImport
            ? $"using System;{Environment.NewLine}{Environment.NewLine}"
            : "";
        File.WriteAllText(
            Path.Combine(outputBasePath, template.OutputFilename),
            $"{header}{template.GetText(string.Join($"{Environment.NewLine}{Environment.NewLine}", items))}"
        );
    }

    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
