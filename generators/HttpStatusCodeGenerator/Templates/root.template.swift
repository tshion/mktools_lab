/**
 Http Status Code
 */
enum HttpStatusCode: Int {

    /// Returns the element matching the given value.
    public static func parse(value: Int) -> HttpStatusCode {
        return HttpStatusCode.init(rawValue: value)!!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: Int) -> HttpStatusCode? {
        return HttpStatusCode.init(rawValue: value)
    }


%%ITEMS%%
}
