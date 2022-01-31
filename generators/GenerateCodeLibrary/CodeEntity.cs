namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成時に利用するデータ
    /// </summary>
    /// <param name="Documents">ドキュメントコメント</param>
    /// <param name="Items">繰り返し生成するデータ</param>
    /// <param name="Name">クラス名</param>
    public sealed record class CodeEntity(
        IEnumerable<string> Documents,
        IEnumerable<CodeItemEntity> Items,
        string Name
    );
}
