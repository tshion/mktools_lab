namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// 列挙型コード生成に使うデータ
    /// </summary>
    /// <param name="DocsDescription">ドキュメントコメント</param>
    /// <param name="DocsLinks">ドキュメント内のリンク一覧</param>
    /// <param name="MemberValue">メンバーの値</param>
    /// <param name="MemberWords">メンバー名向けの単語一覧</param>
    /// <param name="Warning">警告事項</param>
    internal sealed record class EnumCodeEntity(
        IEnumerable<string> DocsDescription,
        IEnumerable<KeyValuePair<string, string>> DocsLinks,
        string MemberValue,
        IEnumerable<string> MemberWords,
        string Warning
    );
}
