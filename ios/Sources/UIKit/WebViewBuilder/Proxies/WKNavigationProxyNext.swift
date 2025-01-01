#if os(iOS)
    import WebKit

    public class WKNavigationProxyNext: NSObject, WKNavigationDelegate {

        internal var didFailProvisionalNavigation: ((WKWebView, WKNavigation, Error) -> Void)? =
            nil


        // MARK: Responding to Navigation Errors
        public func webView(
            _ webView: WKWebView, didFailProvisionalNavigation navigation: WKNavigation!,
            withError: Error
        ) {
            didFailProvisionalNavigation?(webView, navigation, withError)
        }
    }
#endif