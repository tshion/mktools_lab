// See https://aka.ms/new-console-template for more information
using HttpResponseHeaderCodeGenerator;
using System.Collections.Immutable;
using System.Text;


Console.WriteLine("Start");
string basePath = Directory.GetCurrentDirectory();


// コード生成器の作成
string templateBasePath = Path.Combine(basePath, "Templates");
ImmutableDictionary<string, EnumCodeGenerator> generators = new Dictionary<string, EnumCodeGenerator?>()
{
    ["kt"] = EnumCodeGenerator.LoadOrNull(
        actionFormatDocs: (item, indent) =>
        {
            string prefix = $"{indent} * ";
            string start = $"{indent}/**";
            StringBuilder builder = new();
            if (!string.IsNullOrWhiteSpace(item.Title))
            {
                builder.AppendLine(start);
                builder.AppendLine($"{prefix}{item.Title}");
                if (!string.IsNullOrWhiteSpace(item.TitleSuffix))
                {
                    builder.AppendLine($"{prefix}{item.TitleSuffix}");
                }
            }
            if (item.Links.Any())
            {
                builder.AppendLine(builder.Length < 1 ? start : prefix);
                foreach (var (title, url) in item.Links)
                {
                    builder.AppendLine($"{prefix}* [{title}]({url})");
                }
            }
            if (0 < builder.Length)
            {
                builder.Append($"{indent} */");
            }
            return builder.ToString();
        },
        actionFormatPrefix: (item, indent) =>
        {
            string prefix = $"{indent}";
            StringBuilder builder = new();
            if (!string.IsNullOrWhiteSpace(item.Warning))
            {
                builder.AppendLine($"{prefix}@Deprecated(\"{item.Warning}\")");
            }
            builder.Append(prefix);
            return builder.ToString();
        },
        indentSize: 4,
        memberNameType: NameType.Snake,
        templateItemPath: Path.Combine(templateBasePath, "item.template.kt"),
        templateRootPath: Path.Combine(templateBasePath, "root.template.kt")
    ),
    ["swift"] = EnumCodeGenerator.LoadOrNull(
        actionFormatDocs: (item, indent) =>
        {
            string prefix = $"{indent}/// ";
            List<string> candidate = new();
            if (!string.IsNullOrWhiteSpace(item.Title))
            {
                candidate.Add($"{prefix}{item.Title}");
                if (!string.IsNullOrWhiteSpace(item.TitleSuffix))
                {
                    candidate.Add($"{prefix}{item.TitleSuffix}");
                }
            }
            if (item.Links.Any())
            {
                if (candidate.Any())
                {
                    candidate.Add(prefix.TrimEnd());
                }
                foreach (var (title, url) in item.Links)
                {
                    candidate.Add($"{prefix}* [{title}]({url})");
                }
            }
            if (!string.IsNullOrWhiteSpace(item.Warning))
            {
                if (candidate.Any())
                {
                    candidate.Add(prefix.TrimEnd());
                }
                candidate.Add($"{prefix}- Warning: {item.Warning}");
            }
            return string.Join(Environment.NewLine, candidate);
        },
        indentSize: 4,
        memberNameType: NameType.Camel,
        templateItemPath: Path.Combine(templateBasePath, "item.template.swift"),
        templateRootPath: Path.Combine(templateBasePath, "root.template.swift")
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
var queryCsvBody = CsvEntity.GetDataQueryOrNull(Path.Combine(dataBasePath, "HttpResponseHeader.csv"));
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
ImmutableList<EnumCodeEntity> data = queryCsvBody
    .Select(item => ProgramModel.Compile(item, renameWords))
    .Where(item => item != null)
    .Select(item => item!)
    .ToImmutableList();
if (!data.Any())
{
    Console.WriteLine("Finish: Not enough.");
    return;
}


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
        Path.Combine(outputBasePath, $"HttpResponseHeader.{ext}"),
        generator.Generate(data)
    );
}


Console.WriteLine("Finish: Success");
