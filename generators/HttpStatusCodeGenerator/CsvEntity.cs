namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// CSV データ
    /// </summary>
    internal class CsvEntity
    {
        /// <summary>
        /// データ取得クエリの取得
        /// </summary>
        /// <param name="csvFilePath">CSV データのあるファイルパス</param>
        /// <returns>
        /// <list type="bullet">
        ///     <item>ファイルが存在しない場合はnull</item>
        ///     <item>必須項目が存在しない場合はnull</item>
        ///     <item>それ以外はデータ取得クエリ</item>
        /// </list>
        /// </returns>
        public static IEnumerable<CsvEntity>? GetDataQueryOrNull(string csvFilePath)
        {
            if (!File.Exists(csvFilePath)) { return null; }

            string[] csvLines = File.ReadAllLines(csvFilePath);
            if (csvLines.Length < 2) { return null; }

            string[] csvHeaders = csvLines[0].Split(",");
            var csvIndexCaution = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Caution), StringComparison.OrdinalIgnoreCase));
            if (csvIndexCaution < 0) { return null; }
            var csvIndexCode = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Code), StringComparison.OrdinalIgnoreCase));
            if (csvIndexCode < 0) { return null; }
            var csvIndexHasMdn = Array.FindIndex(csvHeaders, x => x.Equals(nameof(HasMdn), StringComparison.OrdinalIgnoreCase));
            if (csvIndexHasMdn < 0) { return null; }
            var csvIndexName = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Name), StringComparison.OrdinalIgnoreCase));
            if (csvIndexName < 0) { return null; }
            var csvIndexNote = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Note), StringComparison.OrdinalIgnoreCase));
            if (csvIndexNote < 0) { return null; }
            var csvIndexUrl1 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url1), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl1 < 0) { return null; }
            var csvIndexUrl2 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url2), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl2 < 0) { return null; }

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
