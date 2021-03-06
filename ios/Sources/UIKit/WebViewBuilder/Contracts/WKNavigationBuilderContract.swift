#if os(iOS)
    import WebKit

    /// Defines [WKNavigationDelegate](https://developer.apple.com/documentation/webkit/wknavigationdelegate) build rule.
    public protocol WKNavigationBuilderContract {

        // MARK: Allowing or Denying Navigation Requests

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3223382-webview
        @available(iOS 13.0, *)
        func decidePolicyForAction(
            _ handler: @escaping (
                WKWebView, WKNavigationAction, WKWebpagePreferences,
                (WKNavigationActionPolicy, WKWebpagePreferences) -> Void
            ) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, decidePolicyFor: WKNavigationAction, preferences: WKWebpagePreferences, decisionHandler: (WKNavigationActionPolicy, WKWebpagePreferences) -> Void)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455641-webview
        func decidePolicyForAction(
            _ handler: @escaping (WKWebView, WKNavigationAction, (WKNavigationActionPolicy) -> Void)
                -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, decidePolicyFor: WKNavigationAction, decisionHandler: (WKNavigationActionPolicy) -> Void)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455643-webview
        func decidePolicyForResponse(
            _ handler: @escaping (
                WKWebView, WKNavigationResponse, (WKNavigationResponsePolicy) -> Void
            ) ->
                Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, decidePolicyFor: WKNavigationResponse, decisionHandler: (WKNavigationResponsePolicy) -> Void)


        // MARK: Tracking the Load Progress of a Request

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455621-webview
        func didStartProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didStartProvisionalNavigation: WKNavigation!)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455627-webview
        func didReceiveServerRedirectForProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didReceiveServerRedirectForProvisionalNavigation: WKNavigation!)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455635-webview
        func didCommit(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didCommit: WKNavigation!)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455629-webview
        func didFinish(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didFinish: WKNavigation!)


        // MARK: Responding to Authentication Challenges

        //        func webView(WKWebView, didReceive: URLAuthenticationChallenge, completionHandler: (URLSession.AuthChallengeDisposition, URLCredential?) -> Void)

        //        func webView(WKWebView, authenticationChallenge: URLAuthenticationChallenge, shouldAllowDeprecatedTLS: (Bool) -> Void)


        // MARK: Responding to Navigation Errors

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455623-webview
        func didFail(
            _ handler: @escaping (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didFail: WKNavigation!, withError: Error)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455637-webview
        func didFailProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, didFailProvisionalNavigation: WKNavigation!, withError: Error)

        ///  https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455639-webviewwebcontentprocessdidtermi
        func didTerminate(
            _ handler: @escaping (WKWebView) -> Void
        ) -> WKNavigationBuilderContract
        //        func webViewWebContentProcessDidTerminate(WKWebView)


        // MARK: Handling Download Progress

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727360-webview
        @available(iOS 14.5, *)
        func becameDownloadNavigationResponse(
            _ handler: @escaping (WKWebView, WKNavigationResponse, WKDownload) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, navigationResponse: WKNavigationResponse, didBecome: WKDownload)

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727359-webview
        @available(iOS 14.5, *)
        func becameDownloadNavigationAction(
            _ handler: @escaping (WKWebView, WKNavigationAction, WKDownload) -> Void
        ) -> WKNavigationBuilderContract
        //        func webView(WKWebView, navigationAction: WKNavigationAction, didBecome: WKDownload)
    }
#endif
