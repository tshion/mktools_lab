#if os(iOS)
    import WebKit

@available(iOS 14.5, *)
internal class WKNavigationProxy: NSObject, WKNavigationDelegate {
        private let _state: WKNavigationState


        internal init(state: WKNavigationState) {
            self._state = state
            super.init()
        }


        // MARK: Allowing or Denying Navigation Requests
        func webView(
            _ webView: WKWebView,
            decidePolicyFor navigationAction: WKNavigationAction,
            preferences: WKWebpagePreferences,
            decisionHandler: @escaping (WKNavigationActionPolicy, WKWebpagePreferences) -> Void
        ) {
            _state.decidePolicyForActionWithPreferences?(webView, navigationAction, preferences, decisionHandler)
        }
        func webView(
            _ webView: WKWebView,
            decidePolicyFor navigationAction: WKNavigationAction,
            decisionHandler: @escaping (WKNavigationActionPolicy) -> Void
        ) {
            _state.decidePolicyForAction?(webView, navigationAction, decisionHandler)
        }
        func webView(
            _ webView: WKWebView,
            decidePolicyFor navigationResponse: WKNavigationResponse,
            decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void
        ) {
            _state.decidePolicyForResponse?(webView, navigationResponse, decisionHandler)
        }


        // MARK: Tracking the Load Progress of a Request
        func webView(
            _ webView: WKWebView,
            didStartProvisionalNavigation navigation: WKNavigation!
        ) {
            _state.didStartProvisionalNavigation?(webView, navigation)
        }
        func webView(
            _ webView: WKWebView,
            didReceiveServerRedirectForProvisionalNavigation navigation: WKNavigation!
        ) {
            _state.didReceiveServerRedirectForProvisionalNavigation?(webView, navigation)
        }
        func webView(
            _ webView: WKWebView,
            didCommit navigation: WKNavigation!
        ) {
            _state.didCommit?(webView, navigation)
        }
        func webView(
            _ webView: WKWebView,
            didFinish navigation: WKNavigation!
        ) {
            _state.didFinish?(webView, navigation)
        }


        // MARK: Responding to Authentication Challenges


        // MARK: Responding to Navigation Errors
        func webView(
            _ webView: WKWebView,
            didFail navigation: WKNavigation!,
            withError error: Error
        ) {
            _state.didFail?(webView, navigation, error)
        }
        func webView(
            _ webView: WKWebView, didFailProvisionalNavigation navigation: WKNavigation!,
            withError: Error
        ) {
            _state.didFailProvisionalNavigation?(webView, navigation, withError)
        }
        func webViewWebContentProcessDidTerminate(_ webView: WKWebView) {
            _state.didTerminate?(webView)
        }


        // MARK: Handling Download Progress
        func webView(
            _ webView: WKWebView,
            navigationResponse: WKNavigationResponse,
            didBecome download: WKDownload
        ) {
            _state.becameDownloadNavigationResponse?(webView, navigationResponse, download)
        }
        func webView(
            _ webView: WKWebView,
            navigationAction: WKNavigationAction,
            didBecome download: WKDownload
        ) {
            _state.becameDownloadNavigationAction?(webView, navigationAction, download)
        }
    }
#endif
