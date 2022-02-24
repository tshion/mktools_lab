#if os(iOS)
    import UIKit

    public class UIAlertControllerBuilder {
        private var actions: [UIAlertAction] = []
        private var message: String? = nil
        private let style: UIAlertController.Style
        private var title: String? = nil


        internal init(style: UIAlertController.Style) {
            self.style = style
        }


        public func addAction(_ action: UIAlertAction) -> UIAlertControllerBuilder {
            actions.append(action)
            return self
        }

        public func create() -> UIAlertController {
            let target = UIAlertController(title: title, message: message, preferredStyle: style)
            for a in actions {
                target.addAction(a)
            }
            return target
        }

        public func message(_ value: String?) -> UIAlertControllerBuilder {
            self.message = value
            return self
        }

        public func title(_ value: String?) -> UIAlertControllerBuilder {
            self.title = value
            return self
        }
    }
#endif
