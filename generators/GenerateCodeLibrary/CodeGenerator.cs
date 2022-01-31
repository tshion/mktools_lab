namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成器
    /// </summary>
    public class CodeGenerator
    {
        private IEnumerable<SyntaxEntity> tree = Enumerable.Empty<SyntaxEntity>();


        public bool CanFormat() => tree.Any();

        public bool SetPattern(IEnumerable<string> lines)
        {
            try
            {
                List<SyntaxEntity> candidate = new();
                Parse(candidate, lines);

                var isSuccess = candidate.Any();
                if (isSuccess)
                {
                    tree = candidate;
                }
                return isSuccess;
            }
            catch (Exception ex)
            {
                return false;
            }
        }


        /// <summary>
        /// テンプレート文字列の解析
        /// </summary>
        /// <param name="accumulator">解析結果の集積場所</param>
        /// <param name="lines">解析対象データ</param>
        /// <param name="isNest">ネスト呼び出しかどうか</param>
        /// <param name="startPosition">データ読み取りの開始位置</param>
        /// <returns>次のデータ読み取りの開始位置</returns>
        private int Parse(
            List<SyntaxEntity> accumulator,
            IEnumerable<string> lines,
            bool isNest = false,
            int startPosition = 0
        )
        {
            // TODO: Indent の取り扱い
            int i = startPosition;
            while (i < lines.Count())
            {
                string line = lines.ElementAt(i);

                if (line.Contains(PlaceholderType.RepeatEnd.ToName()))
                {
                    var nextPosition = i + 1;
                    if (isNest) { return nextPosition; }

                    i = nextPosition;
                    continue;
                }
                else if (line.Contains(PlaceholderType.RepeatBegin.ToName()))
                {
                    var index = line.IndexOf(PlaceholderType.RepeatBegin.ToName());
                    string indent = line.Remove(index);

                    List<SyntaxEntity> children = new();
                    var nextPosition = Parse(children, lines, true, i + 1);
                    accumulator.Add(new SyntaxEntity(
                        Body: indent,
                        Children: children,
                        Placeholders: Enumerable.Empty<PlaceholderType>()
                    ));

                    i = nextPosition;
                    continue;
                }


                List<PlaceholderType> placeholders = new();
                if (line.Contains(PlaceholderType.ClassDocs.ToName()))
                {
                    placeholders.Add(PlaceholderType.ClassDocs);
                }
                if (line.Contains(PlaceholderType.ClassName.ToName()))
                {
                    placeholders.Add(PlaceholderType.ClassName);
                }
                if (line.Contains(PlaceholderType.PropertyDocs.ToName()))
                {
                    placeholders.Add(PlaceholderType.PropertyDocs);
                }
                if (line.Contains(PlaceholderType.PropertyName.ToName()))
                {
                    placeholders.Add(PlaceholderType.PropertyName);
                }
                if (line.Contains(PlaceholderType.PropertyPrefix.ToName()))
                {
                    placeholders.Add(PlaceholderType.PropertyPrefix);
                }
                if (line.Contains(PlaceholderType.PropertyType.ToName()))
                {
                    placeholders.Add(PlaceholderType.PropertyType);
                }
                if (line.Contains(PlaceholderType.PropertyValue.ToName()))
                {
                    placeholders.Add(PlaceholderType.PropertyValue);
                }

                accumulator.Add(new SyntaxEntity(
                    Body: line.ReplaceLineEndings("").TrimEnd(),
                    Children: Enumerable.Empty<SyntaxEntity>(),
                    Placeholders: placeholders
                ));
                i++;
            }
            return i;
        }
    }
}
