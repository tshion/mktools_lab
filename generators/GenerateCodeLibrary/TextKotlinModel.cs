namespace GenerateCodeLibrary
{
    /// <summary>
    /// Kotlin の文字列関連の生成ロジック
    /// </summary>
    public sealed class TextKotlinModel : TextModel
    {
        public TextKotlinModel(NamingStyle style) : base(style)
        {
        }


        /// <summary>
        /// ドキュメントコメントの文字列生成
        /// </summary>
        /// <param name="links">リンク一覧</param>
        /// <param name="titles">タイトル一覧</param>
        public IEnumerable<string> FormatDocuments(
            IEnumerable<KeyValuePair<string, string>> links,
            IEnumerable<string> titles
        )
        {
            List<string> candidate = new();
            string prefix = " *";

            foreach (string title in titles.Where(x => !string.IsNullOrWhiteSpace(x)))
            {
                candidate.Add($"{prefix} {title}");
            }
            if (links.Any() && candidate.Any())
            {
                candidate.Add($"{prefix}");
            }
            foreach (var (title, url) in links)
            {
                candidate.Add($"{prefix} * [{title}]({url})");
            }

            if (candidate.Any())
            {
                candidate.Insert(0, "/**");
                candidate.Add(" */");
            }
            return candidate;
        }

        /// <summary>
        /// 警告文の文字列生成
        /// </summary>
        /// <param name="value">警告文</param>
        public string FormatWarning(string value)
            => !string.IsNullOrWhiteSpace(value) ? $"@Deprecated(\"{value}\")" : "";
    }
}
