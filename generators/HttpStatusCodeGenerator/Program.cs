// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;

try
{
    Console.WriteLine("Start");
    var basePath = Directory.GetCurrentDirectory();
    var dataPaths = DataPathEntity.Parse(basePath);


    // CSV の読み込み
    var csvLines = await File.ReadAllLinesAsync(dataPaths.SourcePath);
    if (csvLines.Length < 2)
    {
        Console.WriteLine("Finish: Not enough.");
        return;
    }
    var queryCsvBody = CsvEntity.GetFormatQuery(csvLines);


    // 置換文字列の辞書作成
    var dicLines = await File.ReadAllLinesAsync(dataPaths.DictionaryPath);
    var dicReplace = 1 < dicLines.Length
        ? dicLines[1..^0]
            .Select(line => line.Split(","))
            .Where(tokens => 2 <= tokens.Length && tokens.All(x => !string.IsNullOrWhiteSpace(x)))
            .ToImmutableDictionary(tokens => tokens[0], tokens => tokens[1])
        : ImmutableDictionary<string, string>.Empty;


    // データの解析
    var data = queryCsvBody
        .Select(item => CodeEntity.ParseOrNull(item, dicReplace))
        .Where(item => item != null)
        .ToList();


    // コード生成
    var templatePaths = new[] { "cs" }
        .Select(ext => TemplatePathEntity.ParseOrNull(basePath, ext))
        .Where(item => item != null)
        .ToList();
    foreach (var item in templatePaths)
    {
        var target = data.First();

        var links = target.Links
            .Select(link => $"        ///     <item><see href=\"{link.Url}\">{link.Title}</see></item>");

        var hasWarning = !string.IsNullOrWhiteSpace(target.Warning);
        var warning = hasWarning
            ? $"[ObsoleteAttribute(\"{target.Warning}\")]{Environment.NewLine}"
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

        var result = File.ReadAllText(item.RootPath)
            .Replace("%%DOCS_LINKS%%", string.Join(Environment.NewLine, links))
            .Replace("%%DOCS_TITLE%%", target.Title)
            .Replace("%%MEMBER_NAME%%", string.Join("", words))
            .Replace("%%MEMBER_VALUE%%", target.MemberValue.ToString())
            .Replace("%%WARNING%%", warning);
        if (hasWarning)
        {
            result = $"using System;{Environment.NewLine}{Environment.NewLine}{result}";
        }
        var a = result;
    }


    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
