namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成時の元になるテンプレート関連ロジック
    /// </summary>
    /// <typeparam name="TEntity">対象データの型</typeparam>
    public abstract class TemplateBaseModel<TEntity>
    {
        /// <summary>
        /// クラスの説明(コメント用)
        /// </summary>
        protected readonly string[] _classDescriptions;

        /// <summary>
        /// クラス名
        /// </summary>
        protected readonly string _className;

        /// <summary>
        /// 命名スタイル
        /// </summary>
        protected readonly NamingStyle _style;

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
        /// <param name="classNameWords">生成クラス名を構成する単語一覧</param>
        /// <param name="style">命名スタイル</param>
        protected TemplateBaseModel(
            IEnumerable<string> classNameWords,
            NamingStyle style
        )
        {
            _classDescriptions = new[] { string.Join(" ", classNameWords) };
            _className = NamingStyle.Pascal.Format(classNameWords);
            _style = style;
        }


        /// <summary>
        /// コード文字列生成
        /// </summary>
        /// <param name="from">対象データ</param>
        public string Format(IEnumerable<TEntity> from)
            => _templateModel?.Format(Parse(from)) ?? "";

        /// <summary>
        /// メンバー名の文字列生成
        /// </summary>
        /// <param name="words">メンバー名を構成する単語一覧</param>
        protected string FormatMemberName(IEnumerable<string> words)
            => _style.Format(words);

        /// <summary>
        /// メンバーの値の文字列生成
        /// </summary>
        /// <param name="type">メンバーの型</param>
        /// <param name="value">メンバーの値</param>
        protected string FormatMemberValue(string type, string value)
            => type.Equals("string", StringComparison.OrdinalIgnoreCase)
                ? $"\"{value}\""
                : value;

        /// <summary>
        /// 出力用データへ変換
        /// </summary>
        protected abstract SourceBodyEntity Parse(IEnumerable<TEntity> from);

        /// <summary>
        /// テンプレートデータの設定
        /// </summary>
        /// <param name="path">テンプレートファイルパス</param>
        public void SetTemplate(string path)
        {
            if (!File.Exists(path)) { return; }

            _templateModel = CodeTemplateModel.CreateOrNull(File.ReadLines(path));
            if (CanFormat)
            {
                OutputFilename = $"{_className}{Path.GetExtension(path)}";
            }
        }
    }
}
