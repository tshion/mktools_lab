using System.Text.RegularExpressions;

namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// 各言語に展開するコードデータ
    /// </summary>
    internal class CodeEntity
    {
        /// <summary>
        /// データの変換
        /// </summary>
        public static CodeEntity? Parse(CsvEntity target)
        {
            if (!int.TryParse(target.Code, out var code))
            {
                return null;
            }
            if (!bool.TryParse(target.HasMdn, out var hasMdn))
            {
                return null;
            }


            // TODO: Name の分析



            // リンクの解析
            List<LinkEntity> links = new();
            if (hasMdn)
            {
                links.Add(new LinkEntity(
                    title: "MDN",
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
                commentLinks: links,
                commentTitle: $"{code} {target.Name}{suffix}",
                typeKey: $"",
                typeValue: code
            );
        }


        /// <summary>
        /// コメント欄のリンク一覧
        /// </summary>
        public List<LinkEntity> CommentLinks { get; private set; }

        /// <summary>
        /// コメントタイトル
        /// </summary>
        public string CommentTitle { get; private set; }

        /// <summary>
        /// 定数定義時のキー名
        /// </summary>
        public string TypeKey { get; private set; }

        /// <summary>
        /// 定数定義時の値
        /// </summary>
        public int TypeValue { get; private set; }


        private CodeEntity(
            List<LinkEntity> commentLinks,
            string commentTitle,
            string typeKey,
            int typeValue
        )
        {
            CommentLinks = commentLinks;
            CommentTitle = commentTitle;
            TypeKey = typeKey;
            TypeValue = typeValue;
        }
    }
}
