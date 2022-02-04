namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成時に展開する基礎データ
    /// </summary>
    /// <param name="Documents">ドキュメントコメント</param>
    /// <param name="Properties">属するプロパティ一覧</param>
    /// <param name="Name">クラス名</param>
    /// <param name="TypeBase">継承する型名</param>
    public sealed record class SourceBodyEntity(
        IEnumerable<string> Documents,
        IEnumerable<SourcePropertyEntity> Properties,
        string Name,
        string TypeBase
    );
}
