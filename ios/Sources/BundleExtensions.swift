import Foundation

extension Bundle {

    /// A unique identifier for a bundle.
    public var appIdentifier: String {
        return pickInfo("CFBundleIdentifier")
    }

    /// A user-visible short name for the bundle.
    public var appName: String {
        return pickInfo("CFBundleName")
    }

    /// The user-visible name for the bundle, used by Siri and visible on the iOS Home screen.
    public var appNameForDisplay: String {
        return pickInfo("CFBundleDisplayName")
    }

    /// A replacement for the app name in text-to-speech operations.
    public var appNameForVoice: String {
        return pickInfo("CFBundleSpokenName")
    }

    /// Bundle version
    public var appVersion: String {
        return pickInfo("CFBundleVersion")
    }

    /// Bundle versions string, short
    public var appVersionShort: String {
        return pickInfo("CFBundleShortVersionString")
    }


    private func pickInfo(_ key: String) -> String {
        return infoDictionary?[key] as! String
    }
}
