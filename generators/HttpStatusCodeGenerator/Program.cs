// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;

try
{
    Console.WriteLine("Start");
    var dataPaths = DataPathEntity.Parse(Directory.GetCurrentDirectory());


    // CSV の読み込み
    var csvLines = await File.ReadAllLinesAsync(dataPaths.SourcePath);
    if (csvLines.Length < 2)
    {
        Console.WriteLine("Finish: Enough Data");
        return;
    }
    var csvHeaders = csvLines[0].Split(",");
    var csvIndexCaution = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Caution), StringComparison.OrdinalIgnoreCase));
    var csvIndexCode = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Code), StringComparison.OrdinalIgnoreCase));
    var csvIndexHasMdn = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.HasMdn), StringComparison.OrdinalIgnoreCase));
    var csvIndexName = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Name), StringComparison.OrdinalIgnoreCase));
    var csvIndexNote = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Note), StringComparison.OrdinalIgnoreCase));
    var csvIndexUrl1 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Url1), StringComparison.OrdinalIgnoreCase));
    var csvIndexUrl2 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(CsvEntity.Url2), StringComparison.OrdinalIgnoreCase));
    var queryCsvBody = csvLines[1..^0]
        .Select(line => line.Split(","))
        .Where(tokens => tokens.Any(x => !string.IsNullOrWhiteSpace(x)));


    // データの解析
    var data = queryCsvBody
        .Select(tokens => new CsvEntity(
            caution: tokens.ElementAtOrDefault(csvIndexCaution) ?? "",
            code: tokens.ElementAtOrDefault(csvIndexCode) ?? "",
            hasMdn: tokens.ElementAtOrDefault(csvIndexHasMdn) ?? "",
            name: tokens.ElementAtOrDefault(csvIndexName) ?? "",
            note: tokens.ElementAtOrDefault(csvIndexNote) ?? "",
            url1: tokens.ElementAtOrDefault(csvIndexUrl1) ?? "",
            url2: tokens.ElementAtOrDefault(csvIndexUrl2) ?? ""
        ))
        .Select(item => CodeEntity.Parse(item))
        .Where(item => item != null)
        .ToList();


    // TODO: コード生成


    Console.WriteLine("Finish: Success");
}
catch (Exception ex)
{
    Console.WriteLine($"Error: {ex.Message}");
}
