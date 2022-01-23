namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// CSV データ
    /// </summary>
    internal class CsvEntity
    {
        /// <summary>
        /// データ変換クエリの取得
        /// </summary>
        /// <param name="csvLines">1行毎のCSV 形式データ</param>
        /// <returns></returns>
        public static IEnumerable<CsvEntity> GetFormatQuery(string[] csvLines)
        {
            if (csvLines.Length < 2)
            {
                return Enumerable.Empty<CsvEntity>();
            }

            var csvHeaders = csvLines[0].Split(",");
            var csvIndexCaution = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Caution), StringComparison.OrdinalIgnoreCase));
            var csvIndexCode = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Code), StringComparison.OrdinalIgnoreCase));
            var csvIndexHasMdn = Array.FindIndex(csvHeaders, x => x.Equals(nameof(HasMdn), StringComparison.OrdinalIgnoreCase));
            var csvIndexName = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Name), StringComparison.OrdinalIgnoreCase));
            var csvIndexNote = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Note), StringComparison.OrdinalIgnoreCase));
            var csvIndexUrl1 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url1), StringComparison.OrdinalIgnoreCase));
            var csvIndexUrl2 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url2), StringComparison.OrdinalIgnoreCase));

            return csvLines[1..^0]
                .Select(line => line.Split(","))
                .Where(tokens => csvHeaders.Length <= tokens.Length && tokens.Any(x => !string.IsNullOrWhiteSpace(x)))
                .Select(tokens => new CsvEntity(
                    caution: tokens.ElementAtOrDefault(csvIndexCaution) ?? "",
                    code: tokens.ElementAtOrDefault(csvIndexCode) ?? "",
                    hasMdn: tokens.ElementAtOrDefault(csvIndexHasMdn) ?? "",
                    name: tokens.ElementAtOrDefault(csvIndexName) ?? "",
                    note: tokens.ElementAtOrDefault(csvIndexNote) ?? "",
                    url1: tokens.ElementAtOrDefault(csvIndexUrl1) ?? "",
                    url2: tokens.ElementAtOrDefault(csvIndexUrl2) ?? ""
                ));
        }


        /// <summary>
        /// 注意書き
        /// </summary>
        public string Caution { get; private set; }

        /// <summary>
        /// ステータスコード
        /// </summary>
        public string Code { get; private set; }

        /// <summary>
        /// MDN に記載があるかどうか
        /// </summary>
        public string HasMdn { get; private set; }

        /// <summary>
        /// ステータス名
        /// </summary>
        public string Name { get; private set; }

        /// <summary>
        /// 注釈
        /// </summary>
        public string Note { get; private set; }

        /// <summary>
        /// URL その１
        /// </summary>
        public string Url1 { get; private set; }

        /// <summary>
        /// URL その２
        /// </summary>
        public string Url2 { get; private set; }


        private CsvEntity(
            string caution,
            string code,
            string hasMdn,
            string name,
            string note,
            string url1,
            string url2
        )
        {
            Caution = caution;
            Code = code;
            HasMdn = hasMdn;
            Name = name;
            Note = note;
            Url1 = url1;
            Url2 = url2;
        }
    }
}
