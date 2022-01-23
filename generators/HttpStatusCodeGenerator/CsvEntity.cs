namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// CSV データ
    /// </summary>
    internal class CsvEntity
    {
        /// <summary>
        /// 注意書き
        /// </summary>
        public string Caution { get; private set; }

        /// <summary>
        /// ステータスコード
        /// </summary>
        public string Code { get; private set; }

        /// <summary>
        /// MDN に記載があるかどうか
        /// </summary>
        public string HasMdn { get; private set; }

        /// <summary>
        /// ステータス名
        /// </summary>
        public string Name { get; private set; }

        /// <summary>
        /// 注釈
        /// </summary>
        public string Note { get; private set; }

        /// <summary>
        /// URL その１
        /// </summary>
        public string Url1 { get; private set; }

        /// <summary>
        /// URL その２
        /// </summary>
        public string Url2 { get; private set; }



        public CsvEntity(
            string caution,
            string code,
            string hasMdn,
            string name,
            string note,
            string url1,
            string url2
        )
        {
            Caution = caution;
            Code = code;
            HasMdn = hasMdn;
            Name = name;
            Note = note;
            Url1 = url1;
            Url2 = url2;
        }
    }
}
