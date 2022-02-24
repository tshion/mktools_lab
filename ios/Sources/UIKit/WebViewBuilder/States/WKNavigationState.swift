#if os(iOS)
    import WebKit

    internal struct WKNavigationState {

        internal var becameDownloadNavigationAction:
            ((WKWebView, WKNavigationAction, WKDownload) -> Void)? = nil
        internal var becameDownloadNavigationResponse:
            ((WKWebView, WKNavigationResponse, WKDownload) -> Void)? = nil
        internal var decidePolicyForAction:
            ((WKWebView, WKNavigationAction, (WKNavigationActionPolicy) -> Void) -> Void)? = nil
        internal var decidePolicyForAction:
            (
                (
                    WKWebView, WKNavigationAction, WKWebpagePreferences,
                    (WKNavigationActionPolicy, WKWebpagePreferences) -> Void
                ) -> Void
            )? = nil
        internal var decidePolicyForResponse:
            ((WKWebView, WKNavigationResponse, (WKNavigationResponsePolicy) -> Void) -> Void)? = nil
        internal var didCommit: ((WKWebView, WKNavigation) -> Void)? = nil
        internal var didFail: ((WKWebView, WKNavigation, Error) -> Void)? = nil
        internal var didFailProvisionalNavigation: ((WKWebView, WKNavigation, Error) -> Void)? =
            nil
        internal var didFinish: ((WKWebView, WKNavigation) -> Void)? = nil
        internal var didReceiveServerRedirectForProvisionalNavigation:
            ((WKWebView, WKNavigation) -> Void)? = nil
        internal var didStartProvisionalNavigation: ((WKWebView, WKNavigation) -> Void)? = nil
        internal var didTerminate: ((WKWebView) -> Void)? = nil


        internal init() {
        }


        func create() -> WKNavigationProxy {
            return WKNavigationProxy(state: self)
        }
    }
#endif
