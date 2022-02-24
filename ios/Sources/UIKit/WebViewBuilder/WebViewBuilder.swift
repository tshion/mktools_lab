#if os(iOS)
    import WebKit

    public class WebViewBuilder {
        private var _stateWKNavigation: WKNavigationState? = nil
        private var stateWKNavigation: WKNavigationState {
            if _stateWKNavigation == nil {
                _stateWKNavigation = WKNavigationState()
            }
            return _stateWKNavigation!
        }


        public init() {
        }


        func didFailProvisionalNavigation(
            _ callback: @escaping (WKWebView, WKNavigation?, Error) -> Void
        ) -> WebViewBuilder {
            stateWKNavigation.didFailProvisionalNavigation = callback
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
