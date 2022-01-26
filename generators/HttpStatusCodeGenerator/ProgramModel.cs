using System.Text.RegularExpressions;

namespace HttpStatusCodeGenerator
{
    internal class ProgramModel
    {
        /// <summary>
        /// データ変換
        /// </summary>
        /// <param name="from">CSV データ</param>
        /// <param name="replaceWords">単語変換データ</param>
        /// <returns>列挙型コードデータ</returns>
        public static EnumCodeEntity Compile(
            in CsvEntity from,
            in IReadOnlyDictionary<string, string> replaceWords
        )
        {
            // リンクの解析
            Dictionary<string, string> tmpLinks = new();
            if (from.HasMdn)
            {
                tmpLinks.TryAdd(
                    $"https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/{from.Code}",
                    "MDN Web Docs"
                );
            }
            foreach (var url in new[] { from.Url1, from.Url2 })
            {
                var result = Regex.Match(url, @"(rfc\d{4,})");
                if (result.Success)
                {
                    tmpLinks.TryAdd(url, result.Groups[1].Value.ToUpper());
                }
            }
            IOrderedEnumerable<KeyValuePair<string, string>> queryLinks = tmpLinks
                .Select(item => KeyValuePair.Create(item.Value, item.Key))
                .OrderBy(item => item.Key);

            // キー名の解析
            string replaced = from.Name;
            foreach (var (before, after) in replaceWords)
            {
                replaced = replaced.Replace(before, after);
            }
            string[] nameWords = replaced.Split(' ', '-');

            // ドキュメント内容の解析
            string suffix = !string.IsNullOrEmpty(from.Note) ? $"({from.Note})" : "";

            // インスタンス生成
            return new EnumCodeEntity(
                links: queryLinks,
                memberValue: $"{from.Code}",
                memberWords: nameWords,
                title: $"{from.Code} {from.Name}{suffix}",
                warning: from.Caution
            );
        }
    }
}
