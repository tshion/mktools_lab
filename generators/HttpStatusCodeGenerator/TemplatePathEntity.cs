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
            return File.Exists(candidate.RootPath)
                ? candidate
                : null;
        }


        /// <summary>
        /// 土台になるファイルのパス
        /// </summary>
        public string RootPath { get; private set; }


        private TemplatePathEntity(
            string basePath,
            string fileExtension
        )
        {
            var dirName = "Templates";
            RootPath = Path.Combine(basePath, dirName, $"HttpStatusCode.base.template.{fileExtension}");
        }
    }
}
