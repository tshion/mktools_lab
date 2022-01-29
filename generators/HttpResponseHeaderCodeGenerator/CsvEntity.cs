namespace HttpResponseHeaderCodeGenerator
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
            var csvIndexHasMdn = Array.FindIndex(csvHeaders, x => x.Equals(nameof(HasMdn), StringComparison.OrdinalIgnoreCase));
            if (csvIndexHasMdn < 0) { return null; }
            var csvIndexName = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Name), StringComparison.OrdinalIgnoreCase));
            if (csvIndexName < 0) { return null; }
            var csvIndexUrl1 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url1), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl1 < 0) { return null; }
            var csvIndexUrl2 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url2), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl2 < 0) { return null; }
            var csvIndexUrl3 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url3), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl3 < 0) { return null; }

            return csvLines[1..^0]
                .Select(line => line.Split(","))
                .Where(tokens => csvHeaders.Length <= tokens.Length && tokens.Any(x => !string.IsNullOrWhiteSpace(x)))
                .Select(tokens =>
                {
                    if (!bool.TryParse(tokens.ElementAtOrDefault(csvIndexHasMdn), out var hasMdn)) { return null; }

                    return new CsvEntity(
                        caution: tokens.ElementAtOrDefault(csvIndexCaution) ?? "",
                        hasMdn: hasMdn,
                        name: tokens.ElementAtOrDefault(csvIndexName) ?? "",
                        url1: tokens.ElementAtOrDefault(csvIndexUrl1) ?? "",
                        url2: tokens.ElementAtOrDefault(csvIndexUrl2) ?? "",
                        url3: tokens.ElementAtOrDefault(csvIndexUrl3) ?? ""
                    );
                })
                .Where(item => item != null)
                .Select(item => item!);
        }


        /// <summary>
        /// 注意書き
        /// </summary>
        public string Caution { get; private set; }

        /// <summary>
        /// MDN に記載があるかどうか
        /// </summary>
        public bool HasMdn { get; private set; }

        /// <summary>
        /// ステータス名
        /// </summary>
        public string Name { get; private set; }

        /// <summary>
        /// URL その１
        /// </summary>
        public string Url1 { get; private set; }

        /// <summary>
        /// URL その２
        /// </summary>
        public string Url2 { get; private set; }

        /// <summary>
        /// URL その３
        /// </summary>
        public string Url3 { get; private set; }


        private CsvEntity(
            string caution,
            bool hasMdn,
            string name,
            string url1,
            string url2,
            string url3
        )
        {
            Caution = caution;
            HasMdn = hasMdn;
            Name = name;
            Url1 = url1;
            Url2 = url2;
            Url3 = url3;
        }
    }
}
