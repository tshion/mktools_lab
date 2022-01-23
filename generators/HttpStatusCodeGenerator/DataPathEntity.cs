namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// データのパス情報
    /// </summary>
    internal class DataPathEntity
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="basePath">実行パス</param>
        /// <exception cref="ArgumentException">対象ファイルが無い</exception>
        public static DataPathEntity Parse(string basePath)
        {
            var candidate = new DataPathEntity(basePath);
            if (File.Exists(candidate.DictionaryPath)
                && File.Exists(candidate.SourcePath))
            {
                return candidate;
            }
            else
            {
                throw new ArgumentException($"Don't have files in {basePath}.");
            }
        }


        /// <summary>
        /// 置換対象文字列データのパス
        /// </summary>
        public string DictionaryPath { get; private set; }

        /// <summary>
        /// 取り込みデータのパス
        /// </summary>
        public string SourcePath { get; private set; }


        private DataPathEntity(string basePath)
        {
            var dirName = "Data";
            DictionaryPath = Path.Combine(basePath, dirName, "ReplaceDictionary.csv");
            SourcePath = Path.Combine(basePath, dirName, "HttpStatusCode.csv");
        }
    }
}
