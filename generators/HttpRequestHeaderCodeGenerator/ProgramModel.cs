using GenerateCodeLibrary;
using System.Text.RegularExpressions;

namespace HttpRequestHeaderCodeGenerator
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
            return new EnumCodeEntity(
                DocsDescription: new[] { $"{from.Name}" },
                DocsLinks: queryLinks,
                MemberValue: $"{from.Name}",
                MemberWords: nameWords,
                Warning: from.Caution
            );
        }


        private readonly IEnumerable<KeyValuePair<string, string>> _classDocsLinks;
        private readonly string[] _classDocsTitle;
        public string ClassName { get; private set; }


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">クラス名を構成する単語一覧</param>
        public ProgramModel(
            IEnumerable<KeyValuePair<string, string>>? classDocsLinks,
            string[] classNameWords
        )
        {
            _classDocsLinks = classDocsLinks ?? Enumerable.Empty<KeyValuePair<string, string>>();
            _classDocsTitle = new[] { string.Join(" ", classNameWords) };
            ClassName = NamingStyle.Pascal.Format(classNameWords);
        }


        public SourceBodyEntity ToKotlinData(IEnumerable<EnumCodeEntity> from)
        {
            TextKotlinModel model = new(NamingStyle.Snake);
            string type = "String";

            return new SourceBodyEntity(
                Documents: model.FormatDocuments(_classDocsLinks, _classDocsTitle),
                Properties: from.Select(item => new SourcePropertyEntity(
                    Documents: model.FormatDocuments(item.DocsLinks, item.DocsDescription),
                    Name: model.FormatMemberName(item.MemberWords),
                    Prefix: new[] { model.FormatWarning(item.Warning) },
                    Type: "",
                    Value: model.FormatMemberValue(type, item.MemberValue)
                )),
                Name: ClassName,
                TypeBase: type
            );
        }

        public SourceBodyEntity ToSwiftData(IEnumerable<EnumCodeEntity> from)
        {
            TextSwiftModel model = new(NamingStyle.Camel);
            string type = "String";

            return new SourceBodyEntity(
                Documents: model.FormatDocuments(_classDocsLinks, _classDocsTitle, ""),
                Properties: from.Select(item => new SourcePropertyEntity(
                    Documents: model.FormatDocuments(item.DocsLinks, item.DocsDescription, item.Warning),
                    Name: model.FormatMemberName(item.MemberWords),
                    Prefix: Enumerable.Empty<string>(),
                    Type: "",
                    Value: model.FormatMemberValue(type, item.MemberValue)
                )),
                Name: ClassName,
                TypeBase: type
            );
        }
    }
}
