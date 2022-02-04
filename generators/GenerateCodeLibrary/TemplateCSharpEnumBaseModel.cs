namespace GenerateCodeLibrary
{
    /// <summary>
    /// C# 列挙型コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateCSharpEnumBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        protected TemplateCSharpEnumBaseModel(
            IEnumerable<string> classNameWords
        ) : base(classNameWords, NamingStyle.Pascal)
        {
        }


        /// <summary>
        /// ドキュメントコメントの文字列生成
        /// </summary>
        /// <param name="links">リンク一覧</param>
        /// <param name="titles">タイトル一覧</param>
        protected IEnumerable<string> FormatDocuments(
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
        protected string FormatWarning(string value)
            => !string.IsNullOrWhiteSpace(value) ? $"[Obsolete(\"{value}\")]" : "";
    }
}
