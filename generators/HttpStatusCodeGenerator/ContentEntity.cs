using System.Collections.Immutable;
using System.Text.RegularExpressions;

namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// 各言語に展開する内容
    /// </summary>
    internal class ContentEntity
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="from">変換元データ</param>
        /// <param name="replaceWords">単語変換データ</param>
        public static ContentEntity Parse(
            in CsvEntity from,
            in ImmutableDictionary<string, string> replaceWords
        )
        {
            // リンクの解析
            Dictionary<string, string> links = new();
            if (from.HasMdn)
            {
                links.TryAdd(
                    "MDN Web Docs",
                    $"https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/{from.Code}"
                );
            }
            foreach (var url in new[] { from.Url1, from.Url2 })
            {
                var result = Regex.Match(url, @"(rfc\d{4,})");
                if (result.Success)
                {
                    links.TryAdd(result.Groups[1].Value.ToUpper(), url);
                }
            }

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
            return new ContentEntity(
                links: links.OrderBy(item => item.Key).ToImmutableDictionary(),
                memberValue: $"{from.Code}",
                memberWords: nameWords.ToImmutableArray(),
                title: $"{from.Code} {from.Name}{suffix}",
                warning: from.Caution
            );
        }


        /// <summary>
        /// ドキュメント内のリンク一覧
        /// </summary>
        public ImmutableDictionary<string, string> Links { get; private set; }

        /// <summary>
        /// メンバーの値
        /// </summary>
        public string MemberValue { get; private set; }

        /// <summary>
        /// メンバー名向けの単語一覧
        /// </summary>
        public ImmutableArray<string> MemberWords { get; private set; }

        /// <summary>
        /// ドキュメントタイトル
        /// </summary>
        public string Title { get; private set; }

        /// <summary>
        /// 警告事項
        /// </summary>
        public string Warning { get; private set; }


        private ContentEntity(
            in ImmutableDictionary<string, string> links,
            string memberValue,
            in ImmutableArray<string> memberWords,
            string title,
            string warning
        )
        {
            Links = links;
            MemberValue = memberValue;
            MemberWords = memberWords;
            Title = title;
            Warning = warning;
        }
    }
}
