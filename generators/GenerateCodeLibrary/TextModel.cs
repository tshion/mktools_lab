namespace GenerateCodeLibrary
{
    /// <summary>
    /// 文字列関連の生成ロジック
    /// </summary>
    public abstract class TextModel
    {
        protected readonly NamingStyle _style;


        protected TextModel(NamingStyle style)
        {
            _style = style;
        }


        /// <summary>
        /// メンバー名の文字列生成
        /// </summary>
        /// <param name="words">メンバー名を構成する単語一覧</param>
        public string FormatMemberName(IEnumerable<string> words)
            => _style.Format(words);

        /// <summary>
        /// メンバーの値の文字列生成
        /// </summary>
        /// <param name="type">メンバーの型</param>
        /// <param name="value">メンバーの値</param>
        public string FormatMemberValue(string type, string value)
            => type.Equals("string", StringComparison.OrdinalIgnoreCase)
                ? $"\"{value}\""
                : value;
    }
}
