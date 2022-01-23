// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;
using System.Collections.Immutable;

try
{
    Console.WriteLine("Start");
    var dataPaths = DataPathEntity.Parse(Directory.GetCurrentDirectory());


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


    // TODO: コード生成


    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
