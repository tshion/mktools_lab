// See https://aka.ms/new-console-template for more information


using HttpStatusCodeGenerator;

Console.WriteLine("Start");


// 起動条件の確認
const string pathData = "./HttpStatusCode.csv";
if (!File.Exists(pathData))
{
    Console.WriteLine($"Finish: Non Data");
    return;
}


// CSV の読み込み
var csvLines = File.ReadAllLines(pathData);
IEnumerable<CsvEntity> data = csvLines.Length < 2
    ? Enumerable.Empty<CsvEntity>()
    : csvLines[1..^0].Select(line =>
    {
        var part = line.Split(",");
        return new CsvEntity(
            code: part[0],
            name: part[1],
            note: part[2],
            url1: part[3],
            url2: part[4]
        );
    });



var result = data.ToList();




Console.WriteLine("Finish");
