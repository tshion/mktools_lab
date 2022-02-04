using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// Swift コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateSwiftBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        /// <param name="style">命名スタイル</param>
        public TemplateSwiftBaseModel(
            IEnumerable<string> classNameWords,
            NamingStyle style
        ) : base(classNameWords, style)
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
