@testable import mktools_ios
import XCTest

final class HelloWorldTests: XCTestCase {
    func testExample() throws {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct
        // results.
        XCTAssertNoThrow(HelloWorldModel().sayHello())
    }
}
