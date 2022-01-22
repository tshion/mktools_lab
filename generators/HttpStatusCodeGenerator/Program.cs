// See https://aka.ms/new-console-template for more information
using HttpStatusCodeGenerator;


Console.WriteLine("Start");


// 起動条件の確認
const string pathData = "./HttpStatusCode.csv";
if (!File.Exists(pathData))
{
    Console.WriteLine("Finish: Non Data");
    return;
}


// CSV の読み込み
var csvLines = File.ReadAllLines(pathData);
if (csvLines.Length < 2)
{
    Console.WriteLine("Finish: Enough Data");
    return;
}


// データの解析
var data = csvLines[1..^0]
    .Select(line =>
    {
        var part = line.Split(",");
        return new CsvEntity(
            code: part[0],
            hasMdn: part[3],
            name: part[1],
            note: part[2],
            url1: part[4],
            url2: part[5]
        );
    })
    .Select(item => CodeEntity.Parse(item))
    .Where(item => item != null)
    .ToList();


// TODO: コード生成


Console.WriteLine("Finish");
