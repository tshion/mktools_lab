// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;
using System.Text;

try
{
    Console.WriteLine("Start");
    string basePath = Directory.GetCurrentDirectory();


    // コード生成器の作成
    string templateBasePath = Path.Combine(basePath, "Templates");
    ImmutableDictionary<string, EnumCodeGenerator> generators = new Dictionary<string, EnumCodeGenerator?>()
    {
        ["cs"] = EnumCodeGenerator.LoadOrNull(
            actionFormatLinks: (item, indent) => string.Join(
                Environment.NewLine,
                item.Links.Select(x => $"{indent}{indent}/// {indent}<item><see href=\"{x.Value}\">{x.Key}</see></item>")
            ),
            actionFormatName: (item, indent) =>
            {
                StringBuilder builder = new();
                for (int i = 0; i < item.MemberWords.Length; i++)
                {
                    string word = item.MemberWords[i];
                    builder.Append(i == 0 && word.Length < 2 ? word.ToUpper() : $"{char.ToUpper(word[0])}{word[1..]}");
                }
                return builder.ToString();
            },
            actionFormaWarning: (item, indent) => !string.IsNullOrWhiteSpace(item.Warning)
                ? $"[Obsolete(\"{item.Warning}\")]{Environment.NewLine}{indent}{indent}"
                : "",
            actionGenerated: (candidate, list, indent) => list.Any(item => !string.IsNullOrWhiteSpace(item.Warning))
                ? $"using System;{Environment.NewLine}{Environment.NewLine}{candidate}"
                : candidate,
            indentSize: 4,
            templateItemPath: Path.Combine(templateBasePath, "HttpStatusCode.item.template.cs"),
            templateRootPath: Path.Combine(templateBasePath, "HttpStatusCode.root.template.cs")
        ),
    }
    .Where(pair => pair.Value != null)
    .ToImmutableDictionary(pair => pair.Key, pair => pair.Value!);
    if (!generators.Any())
    {
        Console.WriteLine("Finish: None targets.");
        return;
    }


    // CSV の読み込み
    string dataBasePath = Path.Combine(basePath, "Data");
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
    ImmutableList<ContentEntity> data = queryCsvBody
        .Select(item => ContentEntity.Parse(item, renameWords))
        .Where(item => item != null)
        .Select(item => item!)
        .ToImmutableList();


    // 出力先のディレクトリ再作成
    string outputBasePath = Path.Combine(basePath, "DataOutput");
    if (Directory.Exists(outputBasePath))
    {
        Directory.Delete(outputBasePath, true);
    }
    Directory.CreateDirectory(outputBasePath);


    // コード生成
    foreach (var (ext, generator) in generators)
    {
        File.WriteAllText(
            Path.Combine(outputBasePath, $"HttpStatusCode.{ext}"),
            generator.Generate(data)
        );
    }

    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
