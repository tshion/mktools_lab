using System.Collections.Immutable;

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
        /// <param name="actionFormatLinks">ドキュメント内リンクの書式整形アクション</param>
        /// <param name="actionFormatName">メンバー名の書式整形アクション</param>
        /// <param name="actionFormatWarning">警告文の書式整形アクション</param>
        /// <param name="actionGenerated">生成後の書式整形アクション</param>
        /// <param name="indentSize">インデントサイズ</param>
        /// <param name="templateItemPath">各項目のテンプレートファイルパス</param>
        /// <param name="templateRootPath">基礎部分のテンプレートファイルパス</param>
        /// <returns>
        /// <list type="bullet">
        ///     <item>ファイルが存在しない場合はnull</item>
        ///     <item>検証エラーの場合はnull</item>
        ///     <item>それ以外はインスタンス</item>
        /// </list>
        /// </returns>
        public static EnumCodeGenerator? LoadOrNull(
            in Func<ContentEntity, string, string>? actionFormatLinks,
            in Func<ContentEntity, string, string>? actionFormatName,
            in Func<ContentEntity, string, string>? actionFormatWarning,
            in Func<string, ImmutableList<ContentEntity>, string, string>? actionGenerated,
            int indentSize,
            string templateItemPath,
            string templateRootPath
        )
        {
            if (indentSize < 0) { return null; }
            if (!File.Exists(templateItemPath)) { return null; }
            if (!File.Exists(templateRootPath)) { return null; }

            return new EnumCodeGenerator(
                actionFormatLinks: actionFormatLinks,
                actionFormatName: actionFormatName,
                actionFormatWarning: actionFormatWarning,
                actionGenerated: actionGenerated,
                formatItem: File.ReadAllText(templateItemPath),
                formatRoot: File.ReadAllText(templateRootPath),
                indentSize: indentSize
            );
        }


        /// <summary>
        /// ドキュメント内リンクの書式整形アクション
        /// </summary>
        private readonly Func<ContentEntity, string, string>? actionFormatLinks;

        /// <summary>
        /// メンバー名の書式整形アクション
        /// </summary>
        private readonly Func<ContentEntity, string, string>? actionFormatName;

        /// <summary>
        /// 警告文の書式整形アクション
        /// </summary>
        private readonly Func<ContentEntity, string, string>? actionFormatWarning;

        /// <summary>
        /// 生成後の書式整形アクション
        /// </summary>
        private readonly Func<string, ImmutableList<ContentEntity>, string, string>? actionGenerated;

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
            in Func<ContentEntity, string, string>? actionFormatLinks,
            in Func<ContentEntity, string, string>? actionFormatName,
            in Func<ContentEntity, string, string>? actionFormatWarning,
            in Func<string, ImmutableList<ContentEntity>, string, string>? actionGenerated,
            string formatItem,
            string formatRoot,
            int indentSize
        )
        {
            this.actionFormatLinks = actionFormatLinks;
            this.actionFormatName = actionFormatName;
            this.actionFormatWarning = actionFormatWarning;
            this.actionGenerated = actionGenerated;
            this.formatItem = formatItem;
            this.formatRoot = formatRoot;
            indent = new(' ', indentSize);
        }


        /// <summary>
        /// 列挙型のコード生成
        /// </summary>
        /// <param name="target">展開するデータ</param>
        public string Generate(in ImmutableList<ContentEntity> target)
        {
            IEnumerable<string> items = target.Select(item => GetTextItem(
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
