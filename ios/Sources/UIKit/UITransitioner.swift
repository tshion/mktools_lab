#if os(iOS)
    import UIKit

    public protocol UITransitioner: AnyObject where Self: UIViewController {
        func pushViewController(_ viewController: UIViewController, animated: Bool)
    }


    extension UITransitioner {
        public func pushViewController(_ viewController: UIViewController, animated: Bool) {
            guard let nc = navigationController else { return }
            nc.pushViewController(viewController, animated: animated)
        }
    }
#endif
