// See https://aka.ms/new-console-template for more information
using GenerateCodeLibrary;
using HttpResponseHeaderCodeGenerator;
using System.Collections.Immutable;


Console.WriteLine("Start");
string basePath = Directory.GetCurrentDirectory();


// コード生成器の作成
IEnumerable<string> classNameWords = new[] { "HTTP", "Response", "Header" };
string templateBasePath = Path.Combine(basePath, "Templates");
ImmutableArray<TemplateBaseModel<CodeEntity>> templates = new Dictionary<string, TemplateBaseModel<CodeEntity>>()
{
    ["enum.template.kt"] = new TemplateKotlinModel(classNameWords),
    ["enum.template.swift"] = new TemplateSwiftModel(classNameWords),
}
.Select(pair =>
{
    pair.Value.SetTemplate(Path.Combine(templateBasePath, pair.Key));
    return pair.Value;
})
.Where(model => model.CanFormat)
.ToImmutableArray();
if (!templates.Any())
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
ImmutableList<CodeEntity> data = queryCsvBody
    .Select(item => CodeEntity.Parse(item, renameWords))
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
foreach (var template in templates)
{
    File.WriteAllText(
        Path.Combine(outputBasePath, template.OutputFilename),
        template.Format(data)
    );
}


Console.WriteLine("Finish: Success");
