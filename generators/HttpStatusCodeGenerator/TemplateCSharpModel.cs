using GenerateCodeLibrary;

namespace HttpStatusCodeGenerator
{
    /// <summary>
    /// C# コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    internal sealed class TemplateCSharpModel : TemplateCSharpBaseModel<CodeEntity>
    {
        private readonly string _type = "";


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        public TemplateCSharpModel(
            IEnumerable<string> classNameWords
        ) : base(classNameWords, NamingStyle.Pascal)
        {
        }


        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected override SourceBodyEntity Parse(IEnumerable<CodeEntity> from)
            => new(
                Documents: FormatDocuments(Enumerable.Empty<KeyValuePair<string, string>>(), _classDescriptions),
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
