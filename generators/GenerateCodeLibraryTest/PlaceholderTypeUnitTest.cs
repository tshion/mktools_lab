using GenerateCodeLibrary.Inner;
using NUnit.Framework;
using System;
using System.Linq;

namespace GenerateCodeLibraryTest
{
    internal class PlaceholderTypeUnitTests
    {
        [Test]
        public void Test_Class()
        {
            var target = new SampleClass();
            Assert.IsNotNull(target.Type);
            Assert.AreEqual(PlaceholderType.Undefined, target.Type);
        }

        [Test]
        public void Test_Members()
        {
            var target = PlaceholderTypeExtensions.Members;
            Assert.AreEqual(
                 Enum.GetNames<PlaceholderType>().Length - 1,
                 target.Count()
            );
        }


        private class SampleClass
        {
            public PlaceholderType Type { get; set; }
        }
    }
}
