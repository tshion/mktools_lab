using System.Collections.Immutable;
using System.Text.RegularExpressions;

namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// 各言語に展開するコードデータ
    /// </summary>
    internal class CodeEntity
    {
        /// <summary>
        /// インスタンス生成
        /// </summary>
        /// <param name="target">変換元データ</param>
        /// <param name="wordReplace">単語変換データ</param>
        public static CodeEntity? ParseOrNull(
            CsvEntity target,
            ImmutableDictionary<string, string> wordReplace
        )
        {
            if (!int.TryParse(target.Code, out var code))
            {
                return null;
            }
            if (!bool.TryParse(target.HasMdn, out var hasMdn))
            {
                return null;
            }


            // キー名の分析
            var replaced = target.Name;
            foreach (var (key, value) in wordReplace)
            {
                replaced = replaced.Replace(key, value);
            }
            var nameTokens = replaced.Split(' ', '-');


            // リンクの解析
            List<LinkEntity> links = new();
            if (hasMdn)
            {
                links.Add(new LinkEntity(
                    title: "MDN Web Docs",
                    url: $"https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/{code}"
                ));
            }
            foreach (var url in new[] { target.Url1, target.Url2 })
            {
                var result = Regex.Match(url, @"(rfc\d{4,})");
                if (result.Success)
                {
                    links.Add(new LinkEntity(
                        title: result.Groups[1].Value.ToUpper(),
                        url: url
                    ));
                }
            }


            var suffix = !string.IsNullOrEmpty(target.Note) ? $"({target.Note})" : "";
            return new CodeEntity(
                links: links.ToImmutableArray(),
                memberNameTokens: nameTokens.ToImmutableArray(),
                memberValue: code,
                title: $"{code} {target.Name}{suffix}",
                warning: target.Caution
            );
        }


        /// <summary>
        /// ドキュメントへのリンク一覧
        /// </summary>
        public ImmutableArray<LinkEntity> Links { get; private set; }

        /// <summary>
        /// メンバー名向けの単語分解された一覧
        /// </summary>
        public ImmutableArray<string> MemberNameTokens { get; private set; }

        /// <summary>
        /// メンバーの値
        /// </summary>
        public int MemberValue { get; private set; }

        /// <summary>
        /// ドキュメントタイトル
        /// </summary>
        public string Title { get; private set; }

        /// <summary>
        /// 警告事項
        /// </summary>
        public string Warning { get; private set; }


        private CodeEntity(
            ImmutableArray<LinkEntity> links,
            ImmutableArray<string> memberNameTokens,
            int memberValue,
            string title,
            string warning
        )
        {
            Links = links;
            MemberNameTokens = memberNameTokens;
            MemberValue = memberValue;
            Title = title;
            Warning = warning;
        }
    }
}
