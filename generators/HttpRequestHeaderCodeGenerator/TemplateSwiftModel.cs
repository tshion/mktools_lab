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
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateSwiftModel(
            IEnumerable<string> classNameWords
        ) : base(classNameWords)
        {
        }


        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected override SourceBodyEntity Parse(IEnumerable<CodeEntity> from)
            => new(
                Documents: FormatDocuments(Enumerable.Empty<KeyValuePair<string, string>>(), _classDescriptions, ""),
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
