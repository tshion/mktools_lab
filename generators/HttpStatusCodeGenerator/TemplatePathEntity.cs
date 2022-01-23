namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// コードテンプレートファイルのパス情報
    /// </summary>
    internal class TemplatePathEntity
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="basePath">実行パス</param>
        /// <param name="fileExtension">ファイル拡張子名</param>
        public static TemplatePathEntity? ParseOrNull(
            string basePath,
            string fileExtension
        )
        {
            var candidate = new TemplatePathEntity(basePath, fileExtension);
            return File.Exists(candidate.ItemPath) && File.Exists(candidate.RootPath)
                ? candidate
                : null;
        }


        /// <summary>
        /// 各項目のファイルパス
        /// </summary>
        public string ItemPath { get; private set; }

        /// <summary>
        /// 土台になるファイルのパス
        /// </summary>
        public string RootPath { get; private set; }

        /// <summary>
        /// 出力先のファイルパス
        /// </summary>
        public string OutputPath { get; private set; }


        private TemplatePathEntity(
            string basePath,
            string fileExtension
        )
        {
            var dirName = "Templates";
            ItemPath = Path.Combine(basePath, dirName, $"HttpStatusCode.item.template.{fileExtension}");
            RootPath = Path.Combine(basePath, dirName, $"HttpStatusCode.base.template.{fileExtension}");
            OutputPath = Path.Combine(basePath, $"HttpStatusCode.{fileExtension}");
        }
    }
}
