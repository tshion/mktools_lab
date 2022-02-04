using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// Swift 列挙型コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateSwiftEnumBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateSwiftEnumBaseModel(
            IEnumerable<string> classNameWords
        ) : base(classNameWords, NamingStyle.Camel)
        {
        }


        /// <summary>
        /// ドキュメントコメントの文字列生成
        /// </summary>
        /// <param name="links">リンク一覧</param>
        /// <param name="titles">タイトル一覧</param>
        /// <param name="warning">警告文</param>
        /// 
        protected IEnumerable<string> FormatDocuments(
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
