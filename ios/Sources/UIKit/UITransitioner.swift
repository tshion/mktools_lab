#if os(iOS)
    import UIKit

    public protocol UITransitioner: AnyObject where Self: UIViewController {

        func pushViewController(
            _ viewController: UIViewController,
            animated: Bool
        )

        func popViewController(animated: Bool)

        func popToRootViewController(animated: Bool)

        func present(
            viewController: UIViewController,
            animated: Bool,
            completion: (() -> Void)?
        )

        func dismiss(animated: Bool)
    }


    extension UITransitioner {

        public func pushViewController(
            _ viewController: UIViewController,
            animated: Bool
        ) {
            guard let nc = navigationController else { return }
            nc.pushViewController(viewController, animated: animated)
        }

        public func popViewController(animated: Bool) {
            guard let nc = navigationController else { return }
            nc.popViewController(animated: animated)
        }

        public func popToRootViewController(animated: Bool) {
            guard let nc = navigationController else { return }
            nc.popToRootViewController(animated: animated)
        }

        public func present(
            viewController: UIViewController,
            animated: Bool,
            completion: (() -> Void)? = nil
        ) {
            present(viewController, animated: animated, completion: completion)
        }

        public func dismiss(animated: Bool) {
            dismiss(animated: animated)
        }
    }
#endif
