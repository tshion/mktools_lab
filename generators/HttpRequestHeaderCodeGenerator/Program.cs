// See https://aka.ms/new-console-template for more information
using GenerateCodeLibrary;
using HttpRequestHeaderCodeGenerator;
using System.Collections.Immutable;


Console.WriteLine("Start");
string basePath = Directory.GetCurrentDirectory();


// コード生成器の作成
string templateBasePath = Path.Combine(basePath, "Templates");
ImmutableDictionary<string, IEnumerable<string>> templates = new[]
{
    Path.Combine(templateBasePath, "enum.template.kt"),
    Path.Combine(templateBasePath, "enum.template.swift"),
}
.Where(path => File.Exists(path))
.Select(path => (Path.GetExtension(path).TrimStart('.'), File.ReadLines(path)))
.ToImmutableDictionary(item => item.Item1, item => item.Item2);
if (!templates.Any())
{
    Console.WriteLine("Finish: None targets.");
    return;
}


// CSV の読み込み
string dataBasePath = Path.Combine(basePath, "Data");
var queryCsvBody = CsvEntity.GetDataQueryOrNull(Path.Combine(dataBasePath, "HttpRequestHeader.csv"));
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
string[] classNameWords = new[] { "Http", "Request", "Header" };
IEnumerable<KeyValuePair<string, string>>? classDocsLinks = Enumerable.Empty<KeyValuePair<string, string>>();
string[] classDocsTitle = new[] { string.Join(" ", classNameWords) };
string className = NamingStyle.Pascal.Format(classNameWords);
foreach (var (ext, template) in templates)
{
    var templateModel = CodeTemplateModel.CreateOrNull(template);
    if (templateModel == null)
    {
        continue;
    }

    SourceBodyEntity? source;
    switch (ext)
    {
        case "kt":
            {
                TextKotlinModel model = new(NamingStyle.Snake);
                string type = "String";

                source = new SourceBodyEntity(
                    Documents: model.FormatDocuments(classDocsLinks, classDocsTitle),
                    Properties: data.Select(item => new SourcePropertyEntity(
                        Documents: model.FormatDocuments(item.Links, new[] { item.Title, item.TitleSuffix }),
                        Name: model.FormatMemberName(item.MemberWords),
                        Prefix: new[] { model.FormatWarning(item.Warning) },
                        Type: "",
                        Value: model.FormatMemberValue(type, item.MemberValue)
                    )),
                    Name: className,
                    TypeBase: type
                );
            }
            break;
        case "swift":
            {
                TextSwiftModel model = new(NamingStyle.Camel);
                string type = "String";

                source = new SourceBodyEntity(
                    Documents: model.FormatDocuments(classDocsLinks, classDocsTitle, ""),
                    Properties: data.Select(item => new SourcePropertyEntity(
                        Documents: model.FormatDocuments(item.Links, new[] { item.Title, item.TitleSuffix }, item.Warning),
                        Name: model.FormatMemberName(item.MemberWords),
                        Prefix: Enumerable.Empty<string>(),
                        Type: "",
                        Value: model.FormatMemberValue(type, item.MemberValue)
                    )),
                    Name: className,
                    TypeBase: type
                );
            }
            break;
        default:
            source = null;
            break;
    }
    if (source == null)
    {
        continue;
    }

    File.WriteAllText(
        Path.Combine(outputBasePath, $"{className}.{ext}"),
        templateModel.Format(source)
    );
}


Console.WriteLine("Finish: Success");
