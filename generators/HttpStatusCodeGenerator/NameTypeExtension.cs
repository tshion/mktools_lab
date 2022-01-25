using System.Text;

namespace HttpStatusCodeGenerator
{
    internal static class NameTypeExtension
    {
        /// <summary>
        /// 命名形式に対応する書式整形アクションの取得
        /// </summary>
        /// <param name="nameType">命名形式</param>
        /// <returns>
        /// <list type="bullet">
        ///     <item>該当しない場合はnull</item>
        ///     <item>それ以外はインスタンス</item>
        /// </list>
        /// </returns>
        public static Func<ContentEntity, string, string>? GetFormatterOrNull(
            this NameType nameType
        ) => nameType switch
        {
            NameType.Camel => (item, indent) =>
            {
                StringBuilder builder = new();
                for (int i = 0; i < item.MemberWords.Length; i++)
                {
                    string word = item.MemberWords[i];
                    builder.Append(i == 0 ? word.ToLower() : $"{char.ToUpper(word[0])}{word[1..]}");
                }
                return builder.ToString();
            }
            ,
            NameType.Pascal => (item, indent) =>
            {
                StringBuilder builder = new();
                for (int i = 0; i < item.MemberWords.Length; i++)
                {
                    string word = item.MemberWords[i];
                    builder.Append(i == 0 && word.Length < 2 ? word.ToUpper() : $"{char.ToUpper(word[0])}{word[1..]}");
                }
                return builder.ToString();
            }
            ,
            NameType.Snake => (item, indent) => string.Join("_", item.MemberWords.Select(w => w.ToUpper())),
            _ => null,
        };
    }
}
