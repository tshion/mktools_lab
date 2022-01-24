namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// テンプレートデータ
    /// </summary>
    internal class TemplateEntity
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="basePath">書式取得先ディレクトリーパス</param>
        /// <param name="fileExtension">ファイル拡張子名</param>
        /// <param name="indent">インデントサイズ</param>
        /// <returns>
        /// <list type="bullet">
        ///     <item>ファイルが存在しない場合はnull</item>
        ///     <item>それ以外はインスタンス</item>
        /// </list>
        /// </returns>
        public static TemplateEntity? LoadOrNull(
            string basePath,
            string fileExtension,
            int indent
        )
        {
            string baseFilePath = Path.Combine(basePath, $"HttpStatusCode.base.template.{fileExtension}");
            if (!File.Exists(baseFilePath)) { return null; }
            string itemFilePath = Path.Combine(basePath, $"HttpStatusCode.item.template.{fileExtension}");
            if (!File.Exists(itemFilePath)) { return null; }

            return new TemplateEntity(
                baseFormat: File.ReadAllText(baseFilePath),
                fileExtension: fileExtension,
                indent: indent,
                itemFormat: File.ReadAllText(itemFilePath)
            );
        }


        /// <summary>
        /// 基礎部分の書式
        /// </summary>
        private readonly string baseFormat;

        /// <summary>
        /// インデント
        /// </summary>
        public string Indent { get; private set; }

        /// <summary>
        /// 各項目の書式
        /// </summary>
        private readonly string itemFormat;

        /// <summary>
        /// 出力ファイル名
        /// </summary>
        public string OutputFilename { get; private set; }


        private TemplateEntity(
            string baseFormat,
            string fileExtension,
            int indent,
            string itemFormat
        )
        {
            this.baseFormat = baseFormat;
            Indent = new(' ', indent);
            this.itemFormat = itemFormat;
            OutputFilename = $"HttpStatusCode.{fileExtension}";
        }


        /// <summary>
        /// 各項目用のテキスト取得
        /// </summary>
        /// <param name="linkText">リンクテキスト</param>
        /// <param name="memberName">列挙メンバー名</param>
        /// <param name="memberValue">列挙メンバー値</param>
        /// <param name="title">ドキュメントタイトル</param>
        /// <param name="warning">警告</param>
        public string GetItemText(
            string linkText,
            string memberName,
            string memberValue,
            string title,
            string warning
        ) => $"{itemFormat}"
            .Replace("%%DOCS_LINKS%%", linkText)
            .Replace("%%DOCS_TITLE%%", title)
            .Replace("%%MEMBER_NAME%%", memberName)
            .Replace("%%MEMBER_VALUE%%", memberValue)
            .Replace("%%WARNING%%", warning);

        /// <summary>
        /// 全体のテキスト取得
        /// </summary>
        /// <param name="items">各項目のテキスト</param>
        public string GetText(
            string items
        ) => $"{baseFormat}"
            .Replace("%%ITEMS%%", items);
    }
}
