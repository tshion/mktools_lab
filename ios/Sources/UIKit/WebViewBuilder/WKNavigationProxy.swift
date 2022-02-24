#if os(iOS)
    import WebKit

    internal class WKNavigationProxy: NSObject, WKNavigationDelegate {
        private let _state: WKNavigationState


        internal init(state: WKNavigationState) {
            self._state = state
            super.init()
        }


        func webView(
            _ webView: WKWebView, didFailProvisionalNavigation navigation: WKNavigation!,
            withError: Error
        ) {
            _state.didFailProvisionalNavigation?(webView, navigation, withError)
        }
    }

#endif
