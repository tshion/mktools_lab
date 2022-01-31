namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成時に繰り返し利用されるデータ
    /// </summary>
    /// <param name="Documents">ドキュメントコメント</param>
    /// <param name="Name">プロパティ名</param>
    /// <param name="Prefix">プロパティ宣言の前につける追記事項</param>
    /// <param name="Type">型名</param>
    /// <param name="Value">値</param>
    public sealed record class CodeItemEntity(
        IEnumerable<string> Documents,
        string Name,
        IEnumerable<string> Prefix,
        string Type,
        string Value
    );
}
