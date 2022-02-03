using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// Swift コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    internal sealed class TemplateSwiftModel : TemplateSwiftEnumBaseModel<CodeEntity>
    {
        private readonly string _type = "String";


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateSwiftModel(
            IEnumerable<KeyValuePair<string, string>>? classDocsLinks,
            IEnumerable<string> classNameWords
        ) : base(classDocsLinks, classNameWords)
        {
        }


        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected override SourceBodyEntity Parse(IEnumerable<CodeEntity> from)
            => new(
                Documents: FormatDocuments(_classDocsLinks, _classDescriptions, ""),
                Properties: from.Select(item => new SourcePropertyEntity(
                    Documents: FormatDocuments(item.DocsLinks, item.DocsDescription, item.Warning),
                    Name: FormatMemberName(item.MemberWords),
                    Prefix: Enumerable.Empty<string>(),
                    Type: "",
                    Value: FormatMemberValue(_type, item.MemberValue)
                )),
                Name: _className,
                TypeBase: _type
            );
    }
}
