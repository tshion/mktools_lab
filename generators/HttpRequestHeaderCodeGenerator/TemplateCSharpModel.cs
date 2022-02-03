using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// C# コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    internal sealed class TemplateCSharpModel : TemplateCSharpEnumBaseModel<CodeEntity>
    {
        private readonly string _type = "string";


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateCSharpModel(
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
                Documents: FormatDocuments(_classDocsLinks, _classDescriptions),
                Properties: from.Select(item => new SourcePropertyEntity(
                    Documents: FormatDocuments(item.DocsLinks, item.DocsDescription),
                    Name: FormatMemberName(item.MemberWords),
                    Prefix: new[] { FormatWarning(item.Warning) },
                    Type: "",
                    Value: FormatMemberValue(_type, item.MemberValue)
                )),
                Name: _className,
                TypeBase: _type
            );
    }
}
