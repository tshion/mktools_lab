#if os(iOS)
    import WebKit

    @available(iOS 14.5, *)
    public class WebViewBuilder: WKNavigationBuilderContract {

        private var _stateWKNavigation: WKNavigationState? = nil
        private func stateWKNavigation() -> WKNavigationState {
            if _stateWKNavigation == nil {
                _stateWKNavigation = WKNavigationState()
            }
            return _stateWKNavigation!
        }


        public init() {
        }


        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727359-webview
        @available(iOS 14.5, *)
        public func becameDownloadNavigationAction(
            _ handler: @escaping (WKWebView, WKNavigationAction, WKDownload) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().becameDownloadNavigationAction = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3727360-webview
        @available(iOS 14.5, *)
        public func becameDownloadNavigationResponse(
            _ handler: @escaping (WKWebView, WKNavigationResponse, WKDownload) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().becameDownloadNavigationResponse = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455641-webview
        public func decidePolicyForAction(
            _ handler: @escaping (WKWebView, WKNavigationAction, (WKNavigationActionPolicy) -> Void)
                -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().decidePolicyForAction = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/3223382-webview
        public func decidePolicyForAction(
            _ handler: @escaping (
                WKWebView, WKNavigationAction, WKWebpagePreferences,
                (WKNavigationActionPolicy, WKWebpagePreferences) -> Void
            ) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().decidePolicyForActionWithPreferences = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455643-webview
        public func decidePolicyForResponse(
            _ handler: @escaping (
                WKWebView, WKNavigationResponse, (WKNavigationResponsePolicy) -> Void
            ) ->
                Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().decidePolicyForResponse = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455635-webview
        public func didCommit(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didCommit = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455623-webview
        public func didFail(
            _ handler: @escaping (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didFail = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455621-webview
        public func didFailProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation, Error) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didFailProvisionalNavigation = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455629-webview
        public func didFinish(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didFinish = handler
            return self
        }

        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455627-webview
        public func didReceiveServerRedirectForProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didReceiveServerRedirectForProvisionalNavigation = handler
            return self
        }

        public func didStartProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didStartProvisionalNavigation = handler
            return self
        }

        ///  https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455639-webviewwebcontentprocessdidtermi
        public func didTerminate(
            _ handler: @escaping (WKWebView) -> Void
        ) -> WKNavigationBuilderContract {
            stateWKNavigation().didTerminate = handler
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
