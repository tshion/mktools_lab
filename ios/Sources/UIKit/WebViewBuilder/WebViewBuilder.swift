#if os(iOS)
    import WebKit

    public struct WebViewBuilder: WKNavigationBuilderContract {
        private var _stateWKNavigation: WKNavigationState? = nil
        private var stateWKNavigation: WKNavigationState {
            if _stateWKNavigation == nil {
                _stateWKNavigation = WKNavigationState()
            }
            return _stateWKNavigation!
        }


        public init() {
        }


        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727359-webview
        func becameDownloadNavigationAction(
            _ handler: (WKWebView, WKNavigationAction, WKDownload) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.becameDownloadNavigationAction = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727360-webview
        func becameDownloadNavigationResponse(
            _ handler: (WKWebView, WKNavigationResponse, WKDownload) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.becameDownloadNavigationResponse = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455641-webview
        func decidePolicyForAction(
            _ handler: (WKWebView, WKNavigationAction, (WKNavigationActionPolicy) -> Void) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.decidePolicyForAction = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3223382-webview
        func decidePolicyForAction(
            _ handler: (
                WKWebView, WKNavigationAction, WKWebpagePreferences,
                (WKNavigationActionPolicy, WKWebpagePreferences) -> Void
            ) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.decidePolicyForAction = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455643-webview
        func decidePolicyForResponse(
            _ handler: (WKWebView, WKNavigationResponse, (WKNavigationResponsePolicy) -> Void) ->
                Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.decidePolicyForResponse = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455635-webview
        func didCommit(
            _ handler: (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didCommit = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455623-webview
        func didFail(
            _ handler: (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didFail = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455621-webview
        func didFailProvisionalNavigation(
            _ handler: (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didFailProvisionalNavigation = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455629-webview
        func didFinish(
            _ handler: (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didFinish = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455627-webview
        func didReceiveServerRedirectForProvisionalNavigation(
            _ handler: (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didReceiveServerRedirectForProvisionalNavigation = handler
            return self
        }

        ///  https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455639-webviewwebcontentprocessdidtermi
        func didTerminate(
            _ handler: (WKWebView) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation.didTerminate = handler
            return self
        }


        public func into(_ target: WKWebView) -> WKWebView {
            if let state = _stateWKNavigation {
                target.navigationDelegate = state.create()
            }
            return target
        }
    }
#endif
