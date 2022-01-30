namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// 列挙型コード生成に使うデータ
    /// </summary>
    internal class EnumCodeEntity
    {
        /// <summary>
        /// ドキュメント内のリンク一覧
        /// </summary>
        public IEnumerable<KeyValuePair<string, string>> Links { get; private set; }

        /// <summary>
        /// メンバーの値
        /// </summary>
        public string MemberValue { get; private set; }

        /// <summary>
        /// メンバー名向けの単語一覧
        /// </summary>
        public IEnumerable<string> MemberWords { get; private set; }

        /// <summary>
        /// ドキュメントタイトル
        /// </summary>
        public string Title { get; private set; }

        /// <summary>
        /// ドキュメントタイトル後のテキスト
        /// </summary>
        public string TitleSuffix { get; private set; }

        /// <summary>
        /// 警告事項
        /// </summary>
        public string Warning { get; private set; }


        public EnumCodeEntity(
            in IEnumerable<KeyValuePair<string, string>> links,
            string memberValue,
            in IEnumerable<string> memberWords,
            string title,
            string titleSuffix,
            string warning
        )
        {
            Links = links;
            MemberValue = memberValue;
            MemberWords = memberWords;
            Title = title;
            TitleSuffix = titleSuffix;
            Warning = warning;
        }
    }
}
