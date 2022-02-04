namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// CSV データ
    /// </summary>
    /// <param name="Caution">注意書き</param>
    /// <param name="Code">ステータスコード</param>
    /// <param name="HasMdn">MDN に記載があるかどうか</param>
    /// <param name="Name">ステータス名</param>
    /// <param name="NameOld">旧ステータス名</param>
    /// <param name="Note">注釈</param>
    /// <param name="Url1">URL その１</param>
    /// <param name="Url2">URL その２</param>
    internal sealed record class CsvEntity(
        string Caution,
        int Code,
        bool HasMdn,
        string Name,
        string Note,
        string NameOld,
        string Url1,
        string Url2
    )
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
            var csvIndexNameOld = Array.FindIndex(csvHeaders, x => x.Equals("OldName", StringComparison.OrdinalIgnoreCase));
            if (csvIndexNameOld < 0) { return null; }
            var csvIndexNote = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Note), StringComparison.OrdinalIgnoreCase));
            if (csvIndexNote < 0) { return null; }
            var csvIndexUrl1 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url1), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl1 < 0) { return null; }
            var csvIndexUrl2 = Array.FindIndex(csvHeaders, x => x.Equals(nameof(Url2), StringComparison.OrdinalIgnoreCase));
            if (csvIndexUrl2 < 0) { return null; }

            return csvLines[1..^0]
                .Select(line => line.Split(","))
                .Where(tokens => csvHeaders.Length <= tokens.Length && tokens.Any(x => !string.IsNullOrWhiteSpace(x)))
                .Select(tokens =>
                {
                    if (!int.TryParse(tokens.ElementAtOrDefault(csvIndexCode), out var code)) { return null; }
                    if (!bool.TryParse(tokens.ElementAtOrDefault(csvIndexHasMdn), out var hasMdn)) { return null; }

                    return new CsvEntity(
                        Caution: tokens.ElementAtOrDefault(csvIndexCaution) ?? "",
                        Code: code,
                        HasMdn: hasMdn,
                        Name: tokens.ElementAtOrDefault(csvIndexName) ?? "",
                        NameOld: tokens.ElementAtOrDefault(csvIndexNameOld) ?? "",
                        Note: tokens.ElementAtOrDefault(csvIndexNote) ?? "",
                        Url1: tokens.ElementAtOrDefault(csvIndexUrl1) ?? "",
                        Url2: tokens.ElementAtOrDefault(csvIndexUrl2) ?? ""
                    );
                })
                .Where(item => item != null)
                .Select(item => item!);
        }
    }
}
