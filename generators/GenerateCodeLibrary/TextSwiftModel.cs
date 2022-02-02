namespace GenerateCodeLibrary
{
    /// <summary>
    /// Swift の文字列関連の生成ロジック
    /// </summary>
    public sealed class TextSwiftModel : TextModel
    {
        public TextSwiftModel(NamingStyle style) : base(style)
        {
        }


        /// <summary>
        /// ドキュメントコメントの文字列生成
        /// </summary>
        /// <param name="links">リンク一覧</param>
        /// <param name="titles">タイトル一覧</param>
        /// <param name="warning">警告文</param>
        /// 
        public IEnumerable<string> FormatDocuments(
            IEnumerable<KeyValuePair<string, string>> links,
            IEnumerable<string> titles,
            string warning
        )
        {
            List<string> candidate = new();
            string prefix = "///";

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

            if (!string.IsNullOrWhiteSpace(warning))
            {
                if (candidate.Any())
                {
                    candidate.Add($"{prefix}");
                }
                candidate.Add($"{prefix} - Warning: {warning}");
            }

            return candidate;
        }
    }
}
