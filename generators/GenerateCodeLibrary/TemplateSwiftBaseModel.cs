namespace GenerateCodeLibrary
{
    /// <summary>
    /// Swift コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateSwiftBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// 言語の予約語
        /// </summary>
        protected override string[] LaungageKeywords { get; } = new[]
        {
            "_",

            "#available",
            "#colorLiteral", "#column",
            "#dsohandle",
            "#else", "#elseif", "#endif", "#error",
            "#fileID", "#fileLiteral", "#file", "#filePath", "#function",
            "#if", "#imageLiteral",
            "#keyPath",
            "#line",
            "#selector", "#sourceLocation",
            "#warning",

            "Any", "as", "associatedtype", "associativity",
            "break",
            "case", "catch", "class", "continue", "convenience",
            "default", "defer", "deinit", "didSet", "do", "dynamic",
            "else", "enum", "extension",
            "fallthrough", "false", "fileprivate", "final", "for", "func",
            "get", "guard",
            "if", "import", "in", "indirect", "infix", "init", "inout", "internal", "is",
            "lazy", "left", "let",
            "mutating",
            "nil", "none", "nonmutating",
            "open", "operator", "optional", "override",
            "postfix", "precedence", "prefix", "private", "precedencegroup", "protocol", "Protocol", "public",
            "repeat", "required", "rethrows", "return", "right",
            "self", "Self", "set", "some", "static", "struct", "subscript", "super", "switch",
            "throw", "throws", "true", "try", "Type", "typealias",
            "unowned",
            "var",
            "weak", "where", "while", "willSet",
        };


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

        /// <summary>
        /// メンバー名の文字列生成
        /// </summary>
        /// <param name="words">メンバー名を構成する単語一覧</param>
        protected override string FormatMemberName(IEnumerable<string> words)
        {
            string candidate = base.FormatMemberName(words);
            return LaungageKeywords.Contains(candidate) ? $"`{candidate}`" : candidate;
        }
    }
}
