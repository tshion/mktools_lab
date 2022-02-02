using System.Text;
using System.Text.RegularExpressions;

namespace GenerateCodeLibrary
{
    /// <summary>
    /// コード生成器
    /// </summary>
    public class CodeGenerator
    {
        /// <summary>
        /// 与えられたプロパティ関連データを構文へ設定した文字列の取得
        /// </summary>
        /// <param name="parentIndent">引き継ぐインデント文字列</param>
        /// <param name="properties">設定するプロパティデータ</param>
        /// <param name="syntaxTree">プロパティ関連の構文木</param>
        /// <returns>データ設定した文字列</returns>
        private static string FormatProperty(
            string parentIndent,
            IEnumerable<SourcePropertyEntity> properties,
            IEnumerable<SyntaxEntity> syntaxTree
        )
        {
            StringBuilder resultBuilder = new();
            foreach (SourcePropertyEntity property in properties)
            {
                foreach (SyntaxEntity syntax in syntaxTree)
                {
                    // 設定するインデントの算出
                    string indent = $"{parentIndent}{syntax.Indent}";

                    // データ設定対象
                    string target = $"{indent}{syntax.Body}";

                    // プレースホルダーがない場合はそのまま受け入れる
                    if (!syntax.Placeholders.Any())
                    {
                        resultBuilder.AppendLine(target);
                        continue;
                    }

                    // データをプレースホルダーへ設定
                    StringBuilder lineBuilder = new(target);
                    foreach (var type in syntax.Placeholders)
                    {
                        switch (type)
                        {
                            case PlaceholderType.PropertyDocs:
                                lineBuilder.Replace(
                                    type.ToName(),
                                    string.Join($"{Environment.NewLine}{indent}", property.Documents)
                                );
                                break;
                            case PlaceholderType.PropertyName:
                                lineBuilder.Replace(type.ToName(), property.Name);
                                break;
                            case PlaceholderType.PropertyPrefix:
                                lineBuilder.Replace(
                                    type.ToName(),
                                    string.Join($"{Environment.NewLine}{indent}", property.Prefix)
                                );
                                break;
                            case PlaceholderType.PropertyType:
                                lineBuilder.Replace(type.ToName(), property.Type);
                                break;
                            case PlaceholderType.PropertyValue:
                                lineBuilder.Replace(type.ToName(), property.Value);
                                break;
                            default:
                                break;
                        }
                    }

                    // データ設定後に有効な文字列が残っていれば採用する
                    string line = lineBuilder.ToString();
                    if (!string.IsNullOrWhiteSpace(line))
                    {
                        resultBuilder.AppendLine(line);
                    }
                }
            }
            return resultBuilder.ToString();
        }

        /// <summary>
        /// インデントの抜き出し
        /// </summary>
        /// <param name="target">対象文字列</param>
        /// <returns>見つからない場合は空文字</returns>
        private static string PickIndent(string target)
        {
            Match result = Regex.Match(target, @"^(\s*)\S.*$");
            return result.Success ? result.Groups[1].Value : "";
        }


        private IEnumerable<SyntaxEntity> _tree = Enumerable.Empty<SyntaxEntity>();


        /// <summary>
        /// データ設定先の構文を持っているかどうか
        /// </summary
        public bool CanFormat() => _tree.Any();

        /// <summary>
        /// 与えられたデータを構文へ設定した文字列の取得
        /// </summary>
        /// <param name="data">設定するデータ</param>
        public string Format(SourceBodyEntity data)
        {
            if (!CanFormat())
            {
                return "";
            }

            StringBuilder resultBuilder = new();
            foreach (SyntaxEntity syntax in _tree)
            {
                // 子構文がある場合はその文字列を取得する
                if (syntax.Children.Any())
                {
                    resultBuilder.Append(FormatProperty(syntax.Indent, data.Properties, syntax.Children));
                    continue;
                }

                // データ設定対象
                string target = $"{syntax.Indent}{syntax.Body}";

                // プレースホルダーがない場合はそのまま受け入れる
                if (!syntax.Placeholders.Any())
                {
                    resultBuilder.AppendLine(target);
                    continue;
                }

                // データをプレースホルダーへ設定
                StringBuilder lineBuilder = new(target);
                foreach (var type in syntax.Placeholders)
                {
                    switch (type)
                    {
                        case PlaceholderType.ClassDocs:
                            lineBuilder.Replace(
                                type.ToName(),
                                string.Join($"{Environment.NewLine}{syntax.Indent}", data.Documents)
                            );
                            break;
                        case PlaceholderType.ClassName:
                            lineBuilder.Replace(type.ToName(), data.Name);
                            break;
                        case PlaceholderType.ClassTypeBase:
                            lineBuilder.Replace(type.ToName(), data.TypeBase);
                            break;
                        default:
                            break;
                    }
                }

                // データ設定後に有効な文字列が残っていれば採用する
                string line = lineBuilder.ToString();
                if (!string.IsNullOrWhiteSpace(line))
                {
                    resultBuilder.AppendLine(line);
                }
            }
            return resultBuilder.ToString();
        }

        /// <summary>
        /// 構文の設定
        /// </summary>
        /// <param name="lines">構文データの入った各行</param>
        /// <returns>設定できたかどうか</returns>
        public bool SetPattern(IEnumerable<string> lines)
        {
            try
            {
                List<SyntaxEntity> candidate = new();
                Parse(candidate, lines);

                var isSuccess = candidate.Any();
                if (isSuccess)
                {
                    _tree = candidate;
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
        /// <param name="accumulator">解析結果の集積場所(副作用あり)</param>
        /// <param name="lines">解析対象データ</param>
        /// <param name="nestDepth">再帰呼び出しの深さ</param>
        /// <param name="parentIndent">親要素のインデントサイズ</param>
        /// <param name="startPosition">データ読み取りの開始位置</param>
        /// <returns>次のデータ読み取りの開始位置</returns>
        private int Parse(
            List<SyntaxEntity> accumulator,
            IEnumerable<string> lines,
            int nestDepth = 0,
            string parentIndent = "",
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
                    if (0 < nestDepth) { return nextPosition; }

                    i = nextPosition;
                    continue;
                }

                string indent = PickIndent(line);
                if (line.Contains(PlaceholderType.RepeatBegin.ToName()))
                {
                    // ２回以上の再帰呼び出しを無視する
                    if (0 < nestDepth)
                    {
                        i++;
                        continue;
                    }

                    List<SyntaxEntity> children = new();
                    var nextPosition = Parse(children, lines, nestDepth + 1, indent, i + 1);
                    accumulator.Add(new SyntaxEntity(
                        Body: "",
                        Children: children,
                        Indent: indent,
                        Placeholders: Enumerable.Empty<PlaceholderType>()
                    ));
                    i = nextPosition;
                }
                else
                {
                    accumulator.Add(new SyntaxEntity(
                        Body: line.ReplaceLineEndings("").Trim(),
                        Children: Enumerable.Empty<SyntaxEntity>(),
                        Indent: parentIndent.Any() ? indent.Replace(parentIndent, "") : indent,
                        Placeholders: PlaceholderTypeExtensions.Members
                            .Where(member => line.Contains(member.ToName()))
                    ));
                    i++;
                }
            }
            return i;
        }
    }
}
