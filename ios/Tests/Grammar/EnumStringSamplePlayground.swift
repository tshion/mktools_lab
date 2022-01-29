import XCTest

/// String ベースのEnum サンプルの挙動確認
final class EnumStringSamplePlayground: XCTestCase {

    private let testData = ["97", "105", "113", "122"]
    private let testRange = 0..<1000


    func test_benchmark_parse() throws {
        let name = "parse"
        print("\nStart: \(name)\n")
        self.measure {
            for _ in testRange {
                for item in testData {
                    EnumStringSample.parse(value: item)
                }
            }
        }
        print("\nFinish: \(name)\n")
    }

    func test_benchmark_parseByCacheArray() throws {
        let name = "parseByCacheArray"
        print("\nStart: \(name)\n")
        self.measure {
            for _ in testRange {
                for item in testData {
                    EnumStringSample.parseByCacheArray(value: item)
                }
            }
        }
        print("\nFinish: \(name)\n")
    }

    func test_benchmark_parseByCacheDictionary() throws {
        let name = "parseByCacheDictionary"
        print("\nStart: \(name)\n")
        self.measure {
            for _ in testRange {
                for item in testData {
                    EnumStringSample.parseByCacheDictionary(value: item)
                }
            }
        }
        print("\nFinish: \(name)\n")
    }

    func test_benchmark_parseBySwitch() throws {
        let name = "parseBySwitch"
        print("\nStart: \(name)\n")
        self.measure {
            for _ in testRange {
                for item in testData {
                    EnumStringSample.parseBySwitch(value: item)
                }
            }
        }
        print("\nFinish: \(name)\n")
    }
}
