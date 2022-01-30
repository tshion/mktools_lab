using System.Collections.Immutable;

namespace GenerateCodeLibrary
{
    /// <summary>
    /// プレースホルダーの種類の定義
    /// </summary>
    public enum PlaceholderType
    {
        /// <summary>
        /// 未割当
        /// </summary>
        Undefined = 0,


        /// <summary>
        /// クラスのドキュメントコメント
        /// </summary>
        ClassDocs,

        /// <summary>
        /// クラス名
        /// </summary>
        ClassName,

        /// <summary>
        /// プロパティのドキュメントコメント
        /// </summary>
        PropertyDocs,

        /// <summary>
        /// プロパティ名
        /// </summary>
        PropertyName,

        /// <summary>
        /// プロパティ宣言の前につける追記事項
        /// </summary>
        PropertyPrefix,

        /// <summary>
        /// プロパティの型名
        /// </summary>
        PropertyType,

        /// <summary>
        /// プロパティの値
        /// </summary>
        PropertyValue,

        /// <summary>
        /// 反復範囲の開始
        /// </summary>
        RepeatBegin,

        /// <summary>
        /// 反復範囲の終了
        /// </summary>
        RepeatEnd,
    }


    /// <summary>
    /// プレースホルダーの種類に関連する拡張機能
    /// </summary>
    public static class PlaceholderTypeExtensions
    {
        /// <summary>
        /// プレースホルダー名の一覧
        /// </summary>
        public static IReadOnlyList<string> Names { get; } = new[]
        {
            PlaceholderType.ClassDocs,
            PlaceholderType.ClassName,
            PlaceholderType.PropertyDocs,
            PlaceholderType.PropertyName,
            PlaceholderType.PropertyPrefix,
            PlaceholderType.PropertyType,
            PlaceholderType.PropertyValue,
            PlaceholderType.RepeatBegin,
            PlaceholderType.RepeatEnd,
        }.Select(item => item.ToName()).ToImmutableList();


        /// <summary>
        /// プレースホルダー名に変換
        /// </summary>
        /// <param name="receiver">プレースホルダーの種類</param>
        /// <returns>該当しない場合は空文字</returns>
        public static string ToName(this PlaceholderType receiver) => receiver switch
        {
            PlaceholderType.ClassDocs => "%%CLASS_DOCS%%",
            PlaceholderType.ClassName => "%%CLASS_NAME%%",
            PlaceholderType.PropertyDocs => "%%PROPERTY_DOCS%%",
            PlaceholderType.PropertyName => "%%PROPERTY_NAME%%",
            PlaceholderType.PropertyPrefix => "%%PROPERTY_PREFIX%%",
            PlaceholderType.PropertyType => "%%PROPERTY_TYPE%%",
            PlaceholderType.PropertyValue => "%%PROPERTY_VALUE%%",
            PlaceholderType.RepeatBegin => "%%REPEAT_BEGIN%%",
            PlaceholderType.RepeatEnd => "%%REPEAT_END%%",
            _ => ""
        };
    }
}
