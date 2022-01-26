namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// 列挙型のコード生成器
    /// </summary>
    internal class EnumCodeGenerator
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="indentSize">インデントサイズ</param>
        /// <param name="memberNameType">メンバー名の命名形式</param>
        /// <param name="templateItemPath">各項目のテンプレートファイルパス</param>
        /// <param name="templateRootPath">基礎部分のテンプレートファイルパス</param>
        /// <param name="actionFormatLinks">ドキュメント内リンクの書式整形アクション</param>
        /// <param name="actionFormatWarning">警告文の書式整形アクション</param>
        /// <param name="actionGenerated">生成後の書式整形アクション</param>
        /// <param name="defaultValue">既定値</param>
        /// <returns>
        /// <list type="bullet">
        ///     <item>ファイルが存在しない場合はnull</item>
        ///     <item>検証エラーの場合はnull</item>
        ///     <item>それ以外はインスタンス</item>
        /// </list>
        /// </returns>
        public static EnumCodeGenerator? LoadOrNull(
            int indentSize,
            NameType memberNameType,
            string templateItemPath,
            string templateRootPath,
            in Func<EnumCodeEntity, string, string>? actionFormatLinks = null,
            in Func<EnumCodeEntity, string, string>? actionFormatWarning = null,
            in Func<string, IEnumerable<EnumCodeEntity>, string, string>? actionGenerated = null,
            EnumCodeEntity? defaultValue = null
        )
        {
            if (indentSize < 0) { return null; }
            if (!File.Exists(templateItemPath)) { return null; }
            if (!File.Exists(templateRootPath)) { return null; }

            return new EnumCodeGenerator(
                actionFormatLinks: actionFormatLinks,
                actionFormatName: memberNameType.GetFormatterOrNull(),
                actionFormatWarning: actionFormatWarning,
                actionGenerated: actionGenerated,
                defaultValue: defaultValue,
                formatItem: File.ReadAllText(templateItemPath),
                formatRoot: File.ReadAllText(templateRootPath),
                indentSize: indentSize
            );
        }


        /// <summary>
        /// ドキュメント内リンクの書式整形アクション
        /// </summary>
        private readonly Func<EnumCodeEntity, string, string>? actionFormatLinks;

        /// <summary>
        /// メンバー名の書式整形アクション
        /// </summary>
        private readonly Func<EnumCodeEntity, string, string>? actionFormatName;

        /// <summary>
        /// 警告文の書式整形アクション
        /// </summary>
        private readonly Func<EnumCodeEntity, string, string>? actionFormatWarning;

        /// <summary>
        /// 生成後の書式整形アクション
        /// </summary>
        private readonly Func<string, IEnumerable<EnumCodeEntity>, string, string>? actionGenerated;

        /// <summary>
        /// 既定値
        /// </summary>
        private readonly EnumCodeEntity? defaultValue;

        /// <summary>
        /// 各項目の書式
        /// </summary>
        private readonly string formatItem;

        /// <summary>
        /// 基礎部分の書式
        /// </summary>
        private readonly string formatRoot;

        /// <summary>
        /// インデント
        /// </summary>
        private readonly string indent;


        private EnumCodeGenerator(
            in Func<EnumCodeEntity, string, string>? actionFormatLinks,
            in Func<EnumCodeEntity, string, string>? actionFormatName,
            in Func<EnumCodeEntity, string, string>? actionFormatWarning,
            in Func<string, IEnumerable<EnumCodeEntity>, string, string>? actionGenerated,
            EnumCodeEntity? defaultValue,
            string formatItem,
            string formatRoot,
            int indentSize
        )
        {
            this.actionFormatLinks = actionFormatLinks;
            this.actionFormatName = actionFormatName;
            this.actionFormatWarning = actionFormatWarning;
            this.actionGenerated = actionGenerated;
            this.defaultValue = defaultValue;
            this.formatItem = formatItem;
            this.formatRoot = formatRoot;
            indent = new(' ', indentSize);
        }


        /// <summary>
        /// 列挙型のコード生成
        /// </summary>
        /// <param name="target">展開するデータ</param>
        public string Generate(in IEnumerable<EnumCodeEntity> target)
        {
            List<EnumCodeEntity> source = new();
            if (defaultValue != null)
            {
                source.Add(defaultValue);
            }
            source.AddRange(target);
            var items = source.Select(item => GetTextItem(
                linkText: actionFormatLinks?.Invoke(item, indent) ?? "",
                memberName: actionFormatName?.Invoke(item, indent) ?? "",
                memberValue: item.MemberValue,
                title: item.Title,
                warning: actionFormatWarning?.Invoke(item, indent) ?? item.Warning
            ));

            string candidate = GetTextRoot(string.Join($"{Environment.NewLine}{Environment.NewLine}", items));
            return actionGenerated != null
                ? actionGenerated.Invoke(candidate, target, indent)
                : candidate;
        }

        private string GetTextItem(
            string linkText,
            string memberName,
            string memberValue,
            string title,
            string warning
        ) => $"{formatItem}"
            .Replace("%%DOCS_LINKS%%", linkText)
            .Replace("%%DOCS_TITLE%%", title)
            .Replace("%%MEMBER_NAME%%", memberName)
            .Replace("%%MEMBER_VALUE%%", memberValue)
            .Replace("%%WARNING%%", warning);

        private string GetTextRoot(
            string items
        ) => $"{formatRoot}"
            .Replace("%%ITEMS%%", items);
    }
}
