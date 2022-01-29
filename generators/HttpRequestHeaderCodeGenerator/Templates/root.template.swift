/**
 Http Request Header
 */
enum HttpRequestHeader: String {

    /// Returns the element matching the given value.
    public static func parse(value: String) -> HttpRequestHeader {
        return HttpRequestHeader.init(rawValue: value)!!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: String) -> HttpRequestHeader? {
        return HttpRequestHeader.init(rawValue: value)
    }


%%ITEMS%%
}
