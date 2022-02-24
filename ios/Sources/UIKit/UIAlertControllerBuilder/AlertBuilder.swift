#if os(iOS)
    import UIKit

    public class AlertBuilder: UIAlertControllerBuilder {
        private var textFields: [((UITextField) -> Void)?] = []


        public init() {
            super.init(style: .alert)
        }


        func addTextField(_ configurationHandler: ((UITextField) -> Void)? = nil) -> AlertBuilder {
            textFields.append(configurationHandler)
            return self
        }

        public override func create() -> UIAlertController {
            let target = super.create()
            for tf in textFields {
                target.addTextField(configurationHandler: tf)
            }
            return target
        }
    }
#endif
