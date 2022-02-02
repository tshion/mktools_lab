namespace GenerateCodeLibrary
{
    /// <summary>
    /// C# の文字列関連の生成ロジック
    /// </summary>
    public sealed class TextCSharpModel : TextModel
    {
        public TextCSharpModel(NamingStyle style) : base(style)
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
            string prefix = "/// ";

            string[] arrayTitle = titles.Where(x => !string.IsNullOrWhiteSpace(x)).ToArray();
            if (arrayTitle.Any())
            {
                candidate.Add($"{prefix}<summary>");
                foreach (string title in arrayTitle)
                {
                    candidate.Add($"{prefix}{title}");
                }
                candidate.Add($"{prefix}</summary>");
            }

            if (links.Any())
            {
                string indent = "    ";
                candidate.Add($"{prefix}<remarks>");
                candidate.Add($"{prefix}{indent}<list type=\"bullet\">");
                foreach (var (title, url) in links)
                {
                    candidate.Add($"{prefix}{indent}{indent}<item><see href=\"{url}\">{title}</see></item>");
                }
                candidate.Add($"{prefix}{indent}</list>");
                candidate.Add($"{prefix}</remarks>");
            }

            return candidate;
        }

        /// <summary>
        /// 警告文の文字列生成
        /// </summary>
        /// <param name="value">警告文</param>
        public string FormatWarning(string value)
            => !string.IsNullOrWhiteSpace(value) ? $"[System.Obsolete(\"{value}\")]" : "";
    }
}
