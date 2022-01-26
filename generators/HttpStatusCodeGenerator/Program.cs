// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;
using System.Text;


Console.WriteLine("Start");
string basePath = Directory.GetCurrentDirectory();


// コード生成器の作成
string templateBasePath = Path.Combine(basePath, "Templates");
ImmutableDictionary<string, EnumCodeGenerator> generators = new Dictionary<string, EnumCodeGenerator?>()
{
    ["cs"] = EnumCodeGenerator.LoadOrNull(
        actionFormatDocs: (item, indent) =>
        {
            string prefix = $"{indent}{indent}/// ";
            StringBuilder builder = new();
            if (!string.IsNullOrWhiteSpace(item.Title))
            {
                builder.AppendLine($"{prefix}<summary>");
                builder.AppendLine($"{prefix}{item.Title}");
                if (!string.IsNullOrWhiteSpace(item.TitleSuffix))
                {
                    builder.AppendLine($"{prefix}{item.TitleSuffix}");
                }
                builder.Append($"{prefix}</summary>");
            }
            if (item.Links.Any())
            {
                builder.AppendLine("");
                builder.AppendLine($"{prefix}<remarks>");
                builder.AppendLine($"{prefix}{indent}<list type=\"bullet\">");
                foreach (var (title, url) in item.Links)
                {
                    builder.AppendLine($"{prefix}{indent}{indent}<item><see href=\"{url}\">{title}</see></item>");
                }
                builder.AppendLine($"{prefix}{indent}</list>");
                builder.Append($"{prefix}</remarks>");
            }
            return builder.ToString();
        },
        actionFormatPrefix: (item, indent) =>
        {
            string prefix = $"{indent}{indent}";
            StringBuilder builder = new();
            if (!string.IsNullOrWhiteSpace(item.Warning))
            {
                builder.AppendLine($"{prefix}[Obsolete(\"{item.Warning}\")]");
            }
            builder.Append(prefix);
            return builder.ToString();
        },
        actionGenerated: (candidate, list, indent) => list.Any(item => !string.IsNullOrWhiteSpace(item.Warning))
            ? $"using System;{Environment.NewLine}{Environment.NewLine}{candidate}"
            : candidate,
        defaultValue: new EnumCodeEntity(
            links: Enumerable.Empty<KeyValuePair<string, string>>(),
            memberValue: "0",
            memberWords: new[] { "undefined" },
            title: "This is default value.",
            titleSuffix: "",
            warning: "Please use another."
        ),
        indentSize: 4,
        memberNameType: NameType.Pascal,
        templateItemPath: Path.Combine(templateBasePath, "item.template.cs"),
        templateRootPath: Path.Combine(templateBasePath, "root.template.cs")
    ),
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
            StringBuilder builder = new();
            if (!string.IsNullOrWhiteSpace(item.Title))
            {
                builder.AppendLine(prefix);
                builder.AppendLine($"{prefix}{item.Title}");
                if (!string.IsNullOrWhiteSpace(item.TitleSuffix))
                {
                    builder.AppendLine($"{prefix}{item.TitleSuffix}");
                }
            }
            if (item.Links.Any())
            {
                if (0 < builder.Length)
                {
                    builder.AppendLine(prefix);
                }
                builder.AppendLine($"{prefix}- SeeAlso:");
                foreach (var (title, url) in item.Links)
                {
                    builder.AppendLine($"{prefix}  - [{title}]({url})");
                }
            }
            if (!string.IsNullOrWhiteSpace(item.Warning))
            {
                if (0 < builder.Length)
                {
                    builder.AppendLine(prefix);
                }
                builder.AppendLine($"{prefix}- Warning:");
                builder.AppendLine($"{prefix}{item.Warning}");
            }
            if (0 < builder.Length)
            {
                builder.Append(prefix);
            }
            return builder.ToString();
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
        Path.Combine(outputBasePath, $"HttpStatusCode.{ext}"),
        generator.Generate(data)
    );
}


Console.WriteLine("Finish: Success");
