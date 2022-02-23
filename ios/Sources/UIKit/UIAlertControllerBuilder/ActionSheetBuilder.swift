#if os(iOS)
    import UIKit

    public class ActionSheetBuilder: UIAlertControllerBuilder {

        public init() {
            super.init(style: .actionSheet)
        }
    }
#endif
