using GenerateCodeLibrary;
using NUnit.Framework;
using System.Collections.Generic;
using System.Collections.Immutable;

namespace GenerateCodeLibraryTest
{
    internal class NamingStyleUnitTests
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
            Assert.AreEqual(NamingStyle.Undefined, target.Type);

            Assert.AreEqual("", NamingStyle.Undefined.Format(words1));
            Assert.AreEqual("", NamingStyle.Undefined.Format(words2));
        }

        [Test]
        public void Test_Camel()
        {
            Assert.AreEqual("aBC", NamingStyle.Camel.Format(words1));
            Assert.AreEqual("aaaBbbCcc", NamingStyle.Camel.Format(words2));
        }

        [Test]
        public void Test_Pascal()
        {
            Assert.AreEqual("ABC", NamingStyle.Pascal.Format(words1));
            Assert.AreEqual("AaaBbbCcc", NamingStyle.Pascal.Format(words2));
        }

        [Test]
        public void Test_Snake()
        {
            Assert.AreEqual("A_B_C", NamingStyle.Snake.Format(words1));
            Assert.AreEqual("AAA_BBB_CCC", NamingStyle.Snake.Format(words2));
        }


        private class SampleClass
        {
            public NamingStyle Type { get; set; }
        }
    }
}
