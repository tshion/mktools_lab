using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// Kotlin 列挙型コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateKotlinEnumBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateKotlinEnumBaseModel(
            IEnumerable<KeyValuePair<string, string>>? classDocsLinks,
            IEnumerable<string> classNameWords
        ) : base(classDocsLinks, classNameWords, NamingStyle.Snake)
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
        protected string FormatWarning(string value)
            => !string.IsNullOrWhiteSpace(value) ? $"@Deprecated(\"{value}\")" : "";
    }
}
