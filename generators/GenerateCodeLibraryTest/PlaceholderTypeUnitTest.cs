using GenerateCodeLibrary;
using NUnit.Framework;
using System;

namespace GenerateCodeLibraryTest
{
    public class PlaceholderTypeUnitTests
    {
        [Test]
        public void Test_Class()
        {
            var target = new SampleClass();
            Assert.IsNotNull(target.Type);
            Assert.AreEqual(PlaceholderType.Undefined, target.Type);
        }

        [Test]
        public void Test_Names()
        {
            var target = PlaceholderTypeExtensions.Names;
            Assert.AreEqual(
                 Enum.GetNames<PlaceholderType>().Length - 1,
                 target.Count
            );
        }


        private class SampleClass
        {
            public PlaceholderType Type { get; set; }
        }
    }
}
