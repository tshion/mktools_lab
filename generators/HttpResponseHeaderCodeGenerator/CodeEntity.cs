using System.Text.RegularExpressions;

namespace HttpResponseHeaderCodeGenerator
{
    /// <summary>
    /// コード生成に使うデータ
    /// </summary>
    /// <param name="DocsDescription">ドキュメントコメント</param>
    /// <param name="DocsLinks">ドキュメント内のリンク一覧</param>
    /// <param name="MemberValue">メンバーの値</param>
    /// <param name="MemberWords">メンバー名向けの単語一覧</param>
    /// <param name="Warning">警告事項</param>
    internal sealed record class CodeEntity(
        IEnumerable<string> DocsDescription,
        IEnumerable<KeyValuePair<string, string>> DocsLinks,
        string MemberValue,
        IEnumerable<string> MemberWords,
        string Warning
    )
    {
        /// <summary>
        /// データ変換
        /// </summary>
        /// <param name="from">CSV データ</param>
        /// <param name="replaceWords">単語変換データ</param>
        /// <returns>コードデータ</returns>
        public static CodeEntity Parse(
            in CsvEntity from,
            in IReadOnlyDictionary<string, string> replaceWords
        )
        {
            // リンクの解析
            Dictionary<string, string> tmpLinks = new();
            if (from.HasMdn)
            {
                tmpLinks.TryAdd(
                    $"https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/{from.Name}",
                    "MDN Web Docs"
                );
            }
            foreach (var url in new[] { from.Url1, from.Url2, from.Url3 })
            {
                var result = Regex.Match(url, @"(rfc\d{4,})");
                if (result.Success)
                {
                    tmpLinks.TryAdd(url, result.Groups[1].Value.ToUpper());
                }
                else if (!string.IsNullOrWhiteSpace(url) && url != "?")
                {
                    tmpLinks.TryAdd(url, url);
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


            // インスタンス生成
            return new CodeEntity(
                DocsDescription: new[] { $"{from.Name}" },
                DocsLinks: queryLinks,
                MemberValue: $"{from.Name}",
                MemberWords: nameWords,
                Warning: from.Caution
            );
        }
    }
}
