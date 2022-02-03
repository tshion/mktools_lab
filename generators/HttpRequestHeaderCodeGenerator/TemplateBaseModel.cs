using GenerateCodeLibrary;

namespace HttpRequestHeaderCodeGenerator
{
    /// <summary>
    /// コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    internal abstract class TemplateBaseModel
    {
        /// <summary>
        /// クラスの説明(コメント用)
        /// </summary>
        protected readonly string[] _classDescriptions;

        /// <summary>
        /// クラスのドキュメントコメント内のリンク一覧
        /// </summary>
        protected readonly IEnumerable<KeyValuePair<string, string>> _classDocsLinks;

        /// <summary>
        /// クラス名
        /// </summary>
        protected readonly string _className;

        /// <summary>
        /// コード生成ロジック
        /// </summary>
        private CodeTemplateModel? _templateModel;

        /// <summary>
        /// コード生成出来るかどうか
        /// </summary>
        public bool CanFormat => _templateModel != null;

        /// <summary>
        /// 出力時のファイル名
        /// </summary>
        public string OutputFilename { get; private set; } = "";


        /// <summary>
        /// コンストラクタ
        /// </summary>
        /// <param name="classDocsLinks">クラスのドキュメントコメント内に記載するリンク一覧</param>
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        protected TemplateBaseModel(
            IEnumerable<KeyValuePair<string, string>>? classDocsLinks,
            IEnumerable<string> classNameWords
        )
        {
            _classDescriptions = new[] { string.Join(" ", classNameWords) };
            _classDocsLinks = classDocsLinks ?? Enumerable.Empty<KeyValuePair<string, string>>();
            _className = NamingStyle.Pascal.Format(classNameWords);
        }


        /// <summary>
        /// コード文字列生成
        /// </summary>
        /// <param name="from">対象データ</param>
        public string Format(IEnumerable<CodeEntity> from)
            => _templateModel?.Format(Parse(from)) ?? "";

        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected abstract SourceBodyEntity Parse(IEnumerable<CodeEntity> from);

        /// <summary>
        /// テンプレートデータの設定
        /// </summary>
        /// <param name="path">テンプレートファイルパス</param>
        public void SetTemplate(string path)
        {
            if (File.Exists(path)) { return; }

            _templateModel = CodeTemplateModel.CreateOrNull(File.ReadLines(path));
            if (CanFormat)
            {
                OutputFilename = $"{_className}{Path.GetExtension(path)}";
            }
        }
    }
}
