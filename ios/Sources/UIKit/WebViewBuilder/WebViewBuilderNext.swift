#if os(iOS)
    import WebKit

    internal class WebViewBuilderNext {

        private var _proxyWKNavigation: WKNavigationProxyNext? = nil
        private var proxyWKNavigation: WKNavigationProxyNext {
            if _proxyWKNavigation == nil {
                _proxyWKNavigation = WKNavigationProxyNext()
            }
            return _proxyWKNavigation!
        }


        public init() {
        }


        /// https://developer.apple.com/documentation/webkit/wknavigationdelegate/1455621-webview
        public func didFailProvisionalNavigation(
            _ handler: @escaping (WKWebView, WKNavigation, Error) -> Void
        ) -> WebViewBuilderNext {
            proxyWKNavigation.didFailProvisionalNavigation = handler
            return self
        }


        public func into(_ target: WKWebView) -> WKWebView {
            if let proxy = _proxyWKNavigation {
                target.navigationDelegate = proxy
            }
            return target
        }
    }
#endif
