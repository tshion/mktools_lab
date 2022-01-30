using GenerateCodeLibrary;
using NUnit.Framework;
using System.Collections.Generic;
using System.Collections.Immutable;

namespace GenerateCodeLibraryTest
{
    public class CodeNameStyleUnitTests
    {
        private readonly IReadOnlyList<string> words1 = new[]
        {
            "a",
            "b",
            "c"
        }.ToImmutableList();

        private readonly IReadOnlyList<string> words2 = new[]
        {
            "aaa",
            "bbb",
            "ccc"
        }.ToImmutableList();


        [Test]
        public void Test_Class()
        {
            var target = new SampleClass();
            Assert.IsNotNull(target.Type);
            Assert.AreEqual(CodeNameStyle.Undefined, target.Type);

            Assert.AreEqual("", CodeNameStyle.Undefined.Format(words1));
            Assert.AreEqual("", CodeNameStyle.Undefined.Format(words2));
        }

        [Test]
        public void Test_Camel()
        {
            Assert.AreEqual("aBC", CodeNameStyle.Camel.Format(words1));
            Assert.AreEqual("aaaBbbCcc", CodeNameStyle.Camel.Format(words2));
        }

        [Test]
        public void Test_Pascal()
        {
            Assert.AreEqual("ABC", CodeNameStyle.Pascal.Format(words1));
            Assert.AreEqual("AaaBbbCcc", CodeNameStyle.Pascal.Format(words2));
        }

        [Test]
        public void Test_Snake()
        {
            Assert.AreEqual("A_B_C", CodeNameStyle.Snake.Format(words1));
            Assert.AreEqual("AAA_BBB_CCC", CodeNameStyle.Snake.Format(words2));
        }


        private class SampleClass
        {
            public CodeNameStyle Type { get; set; }
        }
    }
}
