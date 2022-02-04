using GenerateCodeLibrary;
using GenerateCodeLibrary.Inner;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;

namespace GenerateCodeLibraryTest
{
    internal class CodeTemplateModelUnitTest
    {
        private readonly SourceBodyEntity testData = new SourceBodyEntity(
            Documents: new[] { "/// AAA", "/// BBB", "/// CCC" },
            Properties: new[]
            {
                new SourcePropertyEntity(
                    Documents: new[] { "/// aaa", "/// bbb", "/// ccc" },
                    Name: "Name1",
                    Prefix: Enumerable.Empty<string>(),
                    Type: "",
                    Value: "\"name1\""
                ),
                new SourcePropertyEntity(
                    Documents: new[] { "/// aaa", "/// bbb", "/// ccc" },
                    Name: "Name2",
                    Prefix: new[] { "@Deprecated(\"hoge\")", "@Overrides" },
                    Type: "",
                    Value: "\"name2\""
                ),
                new SourcePropertyEntity(
                    Documents: new[] { "/// aaa", "/// bbb", "/// ccc" },
                    Name: "Name3",
                    Prefix: Enumerable.Empty<string>(),
                    Type: "",
                    Value: "\"name3\""
                )
            },
            Name: "ClassName",
            TypeBase: "String"
        );

        private const string testTemplate = @"package your.package

%%CLASS_DOCS%%
internal enum class %%CLASS_NAME%%(val value: %%CLASS_TYPE_BASE%%) {

    %%REPEAT_BEGIN%%
    %%PROPERTY_DOCS%%
    %%PROPERTY_PREFIX%%
    %%PROPERTY_NAME%%(%%PROPERTY_VALUE%%),

    %%REPEAT_END%%
    ;


    companion object {

        /**
         * Returns the element matching the given value.
         */
        @JvmStatic
        fun parse(value: %%CLASS_TYPE_BASE%%) = tryParse(value).let { (canParse, result) ->
            if (!canParse) {
                throw NoSuchElementException()
            } else {
                result!!
            }
        }

        /**
         * Returns the element matching the given value or null.
         */
        @JvmStatic
        fun parseOrNull(value: %%CLASS_TYPE_BASE%%) = tryParse(value).second

        @JvmStatic
        private fun tryParse(value: %%CLASS_TYPE_BASE%%) = when (value) {
            %%REPEAT_BEGIN%%
            %%PROPERTY_VALUE%% -> true to %%PROPERTY_NAME%%
            %%REPEAT_END%%
            else -> false to null
        }
    }
}";


        [Test]
        public void Test_CreateOrNull_Fail()
        {
            IEnumerable<string>[] testData = new[]
            {
                Enumerable.Empty<string>(),
                new[] { PlaceholderType.RepeatBegin, PlaceholderType.RepeatBegin }.Select(x => x.ToName()),
                new[] { PlaceholderType.RepeatBegin, PlaceholderType.RepeatEnd }.Select(x => x.ToName()),
                new[] { PlaceholderType.RepeatEnd, PlaceholderType.RepeatEnd }.Select(x => x.ToName()),
            };
            foreach (IEnumerable<string> data in testData)
            {
                Assert.IsNull(CodeTemplateModel.CreateOrNull(data));
            }
        }

        [Test]
        public void Test_CreateOrNull_Success()
        {
            (int, IEnumerable<string>)[] testData = new[]
            {
                (2, new[] { "", "" }),
                (2, new[] { PlaceholderType.PropertyDocs, PlaceholderType.PropertyPrefix }.Select(x => x.ToName())),
                (1, new[] { PlaceholderType.RepeatEnd, PlaceholderType.RepeatBegin, PlaceholderType.PropertyName, PlaceholderType.RepeatEnd }.Select(x => x.ToName())),
                (1, new[] { PlaceholderType.RepeatBegin, PlaceholderType.PropertyDocs, PlaceholderType.RepeatBegin, PlaceholderType.PropertyPrefix, PlaceholderType.RepeatEnd }.Select(x => x.ToName())),
                (36, testTemplate.Split(Environment.NewLine).Select(line => $"{line}{Environment.NewLine}")),
            };
            foreach ((int length, IEnumerable<string> data) in testData)
            {
                var model = CodeTemplateModel.CreateOrNull(data);
                Assert.IsNotNull(model);
#pragma warning disable CS0618 // 型またはメンバーが旧型式です
                Assert.AreEqual(length, model!.GetSyntaxCount);
#pragma warning restore CS0618 // 型またはメンバーが旧型式です
            }
        }

        [Test]
        public void Test_Format()
        {
            var model = CodeTemplateModel.CreateOrNull(testTemplate.Split(Environment.NewLine).Select(line => $"{line}{Environment.NewLine}"));
            Assert.IsNotNull(model);

            string result = model!.Format(testData);
            Assert.IsNotEmpty(result);
        }
    }
}
