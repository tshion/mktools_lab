using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// Kotlin コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    internal sealed class TemplateKotlinModel : TemplateBaseModel
    {
        private readonly TextKotlinModel _model = new(NamingStyle.Snake);
        private readonly string _type = "String";


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateKotlinModel(
            IEnumerable<KeyValuePair<string, string>>? classDocsLinks,
            IEnumerable<string> classNameWords
        ) : base(classDocsLinks, classNameWords)
        {
        }


        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected override SourceBodyEntity Parse(IEnumerable<EnumCodeEntity> from)
            => new(
                Documents: _model.FormatDocuments(_classDocsLinks, _classDescriptions),
                Properties: from.Select(item => new SourcePropertyEntity(
                    Documents: _model.FormatDocuments(item.DocsLinks, item.DocsDescription),
                    Name: _model.FormatMemberName(item.MemberWords),
                    Prefix: new[] { _model.FormatWarning(item.Warning) },
                    Type: "",
                    Value: _model.FormatMemberValue(_type, item.MemberValue)
                )),
                Name: _className,
                TypeBase: _type
            );
    }
}
