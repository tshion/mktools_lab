namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// 単語データ
    /// </summary>
    /// <param name="Rename">置換後の文字列</param>
    /// <param name="Target">置換対象文字列</param>
    internal sealed record class WordEntity(
        string Rename,
        string Target
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
        public static IEnumerable<WordEntity>? GetDataQueryOrNull(string csvFilePath)
        {
            if (!File.Exists(csvFilePath)) { return null; }

            string[] csvLines = File.ReadAllLines(csvFilePath);
            if (csvLines.Length < 1) { return null; }

            return csvLines
                .Select(line => line.Split(","))
                .Where(tokens => 2 <= tokens.Length && tokens.All(x => !string.IsNullOrWhiteSpace(x)))
                .Select(tokens => new WordEntity(
                    Rename: tokens[1],
                    Target: tokens[0]
                ));
        }
    }
}
