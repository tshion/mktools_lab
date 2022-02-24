#if os(iOS)
    import WebKit

    internal class WKNavigationState {

        internal var didFailProvisionalNavigation: ((WKWebView, WKNavigation?, Error) -> Void)? =
            nil


        internal init() {
        }


        func create() -> WKNavigationProxy {
            return WKNavigationProxy(state: self)
        }
    }

#endif
