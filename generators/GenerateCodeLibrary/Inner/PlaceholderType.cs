using System.Runtime.CompilerServices;

[assembly: InternalsVisibleTo("GenerateCodeLibraryTest")]

namespace GenerateCodeLibrary.Inner
{
    /// <summary>
    /// プレースホルダーの種類
    /// </summary>
    internal enum PlaceholderType
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
        /// クラスが継承している型
        /// </summary>
        ClassTypeBase,

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
    internal static class PlaceholderTypeExtensions
    {
        /// <summary>
        /// (有効な)プレースホルダーの一覧
        /// </summary>
        public static IEnumerable<PlaceholderType> Members { get; } = new[]
        {
            PlaceholderType.ClassDocs,
            PlaceholderType.ClassName,
            PlaceholderType.ClassTypeBase,
            PlaceholderType.PropertyDocs,
            PlaceholderType.PropertyName,
            PlaceholderType.PropertyPrefix,
            PlaceholderType.PropertyType,
            PlaceholderType.PropertyValue,
            PlaceholderType.RepeatBegin,
            PlaceholderType.RepeatEnd,
        };

        /// <summary>
        /// プレースホルダー名に変換
        /// </summary>
        /// <param name="receiver">プレースホルダーの種類</param>
        /// <returns>該当しない場合は空文字</returns>
        public static string ToName(this PlaceholderType receiver) => receiver switch
        {
            PlaceholderType.ClassDocs => "%%CLASS_DOCS%%",
            PlaceholderType.ClassName => "%%CLASS_NAME%%",
            PlaceholderType.ClassTypeBase => "%%CLASS_TYPE_BASE%%",
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
