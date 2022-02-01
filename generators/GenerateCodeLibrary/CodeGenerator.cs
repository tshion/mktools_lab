using System.Text.RegularExpressions;

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
        /// テンプレート文字列の解析(副作用あり)
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
                    List<SyntaxEntity> children = new();
                    var nextPosition = Parse(children, lines, true, i + 1);
                    accumulator.Add(new SyntaxEntity(
                        Body: "",
                        Children: children,
                        Indent: "",
                        Placeholders: Enumerable.Empty<PlaceholderType>()
                    ));

                    i = nextPosition;
                    continue;
                }

                accumulator.Add(new SyntaxEntity(
                    Body: line.ReplaceLineEndings("").Trim(),
                    Children: Enumerable.Empty<SyntaxEntity>(),
                    Indent: PickIndent(line),
                    Placeholders: PlaceholderTypeExtensions.Members
                        .Where(member => line.Contains(member.ToName()))
                ));
                i++;
            }
            return i;
        }

        /// <summary>
        /// インデントの抜き出し
        /// </summary>
        /// <param name="target">対象文字列</param>
        /// <returns>見つからない場合は空文字</returns>
        private string PickIndent(string target)
        {
            Match result = Regex.Match(target, @"^(\s*)\S.*$");
            return result.Success ? result.Groups[1].Value : "";
        }
    }
}
