/**
 Http Response Header
 */
enum HttpResponseHeader: String {

    /// Returns the element matching the given value.
    public static func parse(value: String) -> HttpResponseHeader {
        return HttpResponseHeader.init(rawValue: value)!
    }

    /// Returns the element matching the given value or null.
    public static func parseOrNull(value: String) -> HttpResponseHeader? {
        return HttpResponseHeader.init(rawValue: value)
    }


%%ITEMS%%
}
