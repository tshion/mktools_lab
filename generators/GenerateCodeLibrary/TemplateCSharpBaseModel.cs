namespace GenerateCodeLibrary
{
    /// <summary>
    /// C# コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateCSharpBaseModel<TEntity> : TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// 言語の予約語
        /// </summary>
        protected override string[] LaungageKeywords { get; } = new[]
        {
            "abstract", "add", "and", "alias", "as", "ascending", "async", "await",
            "base", "bool", "break", "by", "byte",
            "case", "catch", "char", "checked", "class", "const", "continue",
            "decimal", "default", "delegate", "descending", "do", "double", "dynamic",
            "else", "enum", "equals", "event", "explicit", "extern",
            "false", "finally", "fixed", "float", "for", "foreach", "from",
            "get", "global", "goto", "group",
            "if", "implicit", "in", "init", "int", "interface", "internal", "into", "is",
            "join",
            "let", "lock", "long",
            "managed",
            "nameof", "namespace", "new", "nint", "not", "notnull", "nuint", "null",
            "object", "on", "operator", "or", "orderby", "out", "override",
            "params", "partial", "private", "protected", "public",
            "readonly", "record", "ref", "remove", "return",
            "sbyte", "sealed", "select", "set", "short", "sizeof", "stackalloc", "static", "string", "struct", "switch",
            "this", "throw", "true", "try", "typeof",
            "uint", "ulong", "unchecked", "unmanaged", "unsafe", "ushort", "using",
            "value", "var", "virtual", "void", "volatile",
            "when", "where", "while",
            "yield",
        };


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        /// <param name="style">命名スタイル</param>
        protected TemplateCSharpBaseModel(
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
        /// メンバー名の文字列生成
        /// </summary>
        /// <param name="words">メンバー名を構成する単語一覧</param>
        protected override string FormatMemberName(IEnumerable<string> words)
        {
            string candidate = base.FormatMemberName(words);
            return LaungageKeywords.Contains(candidate) ? $"@{candidate}" : candidate;
        }

        /// <summary>
        /// 警告文の文字列生成
        /// </summary>
        /// <param name="value">警告文</param>
        protected string FormatWarning(string value)
            => !string.IsNullOrWhiteSpace(value) ? $"[Obsolete(\"{value}\")]" : "";
    }
}
