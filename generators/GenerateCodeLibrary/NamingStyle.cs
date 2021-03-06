using System.Text;

namespace GenerateCodeLibrary
{
    /// <summary>
    /// コードの命名形式
    /// </summary>
    public enum NamingStyle
    {
        /// <summary>
        /// 未割当
        /// </summary>
        Undefined = 0,


        /// <summary>
        /// キャメルケース
        /// </summary>
        Camel,

        /// <summary>
        /// パスカルケース
        /// </summary>
        Pascal,

        /// <summary>
        /// スネークケース
        /// </summary>
        Snake,
    }


    /// <summary>
    /// コードの命名形式に関連する拡張機能
    /// </summary>
    public static class NamingStyleExtensions
    {
        /// <summary>
        /// 書式に沿った文字列の取得
        /// </summary>
        /// <param name="receiver">コードの命名形式</param>
        /// <param name="words">加工対象の単語一覧</param>
        /// <returns>該当しない場合は空文字</returns>
        public static string Format(
            this NamingStyle receiver,
            IEnumerable<string> words
        )
        {
            string[] target = words
                .Where(word => !string.IsNullOrWhiteSpace(word))
                .ToArray();
            switch (receiver)
            {
                case NamingStyle.Camel:
                    {
                        StringBuilder builder = new();
                        for (int i = 0; i < target.Length; i++)
                        {
                            string word = target[i];
                            if (i == 0)
                            {
                                builder.Append(word.ToLower());
                                continue;
                            }

                            builder.Append($"{char.ToUpper(word[0])}");
                            if (1 < word.Length)
                            {
                                builder.Append($"{word[1..].ToLower()}");
                            }
                        }
                        return builder.ToString();
                    }
                case NamingStyle.Pascal:
                    {
                        StringBuilder builder = new();
                        for (int i = 0; i < target.Length; i++)
                        {
                            string word = target[i];
                            builder.Append($"{char.ToUpper(word[0])}");
                            if (1 < word.Length)
                            {
                                builder.Append($"{word[1..].ToLower()}");
                            }
                        }
                        return builder.ToString();
                    }
                case NamingStyle.Snake:
                    return string.Join("_", target.Select(w => w.ToUpper()));
                default:
                    return "";
            }
        }
    }
}
