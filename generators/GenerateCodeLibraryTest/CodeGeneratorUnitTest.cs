using GenerateCodeLibrary;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;

namespace GenerateCodeLibraryTest
{
    internal class CodeGeneratorUnitTest
    {
        private const string template = @"package your.package

%%CLASS_DOCS%%
internal enum class %%CLASS_NAME%%(val value: %%PROPERTY_TYPE%%) {

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
        fun parse(value: %%PROPERTY_TYPE%%) = tryParse(value).let { (canParse, result) ->
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
        fun parseOrNull(value: %%PROPERTY_TYPE%%) = tryParse(value).second

        @JvmStatic
        private fun tryParse(value: %%PROPERTY_TYPE%%) = when (value) {
            %%REPEAT_BEGIN%%
            %%PROPERTY_VALUE%% -> true to %%PROPERTY_NAME%%
            %%REPEAT_END%%
            else -> false to null
        }
    }
}
";

        private record class SyntaxEntity(
            string Body,
            IEnumerable<SyntaxEntity> Children
        );



        [Test]
        public void Test_SetPattern()
        {
            IEnumerable<string> lines = template.Split(Environment.NewLine)
                .Select(line => $"{line}{Environment.NewLine}");

            CodeGenerator model = new();
            model.SetPattern(lines);

            Assert.IsTrue(model.CanFormat());
        }
    }
}
