namespace GenerateCodeLibrary
{
    /// <summary>
    /// 構文データ
    /// </summary>
    /// <param name="Body">構文本体</param>
    /// <param name="Children">子要素</param>
    /// <param name="Indent">インデント</param>
    /// <param name="Placeholders">構文に含まれるプレースホルダー</param>
    internal sealed record class SyntaxEntity(
        string Body,
        IEnumerable<SyntaxEntity> Children,
        string Indent,
        IEnumerable<PlaceholderType> Placeholders
    );
}
