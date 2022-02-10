package com.github.tshion.mktools_android.webview_builder.candidate

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import android.webkit.GeolocationPermissions.Callback as GeoCallback

/**
 * Builds [WebChromeClient].
 *
 * ## Example
 * ``` kotlin
 * val instance = WebChromeClientBuilder()
 *     .onJsAlert { _, _, message, result ->
 *         showNativeDialog(message) // FIXME
 *         result?.confirm()
 *         return@onJsAlert false
 *     }
 *     .create()
 * ```
 *
 * ## Note
 * These are deprecated, so this builder doesn't have.
 *
 * * [WebChromeClient.onConsoleMessage] (message: String?, lineNumber: Int, sourceID: String?)
 * * [WebChromeClient.onExceededDatabaseQuota]
 * * [WebChromeClient.onJsTimeout]
 * * [WebChromeClient.onReachedMaxAppCacheSize]
 * * [WebChromeClient.onShowCustomView] (view: View?, requestedOrientation: Int, callback: CustomViewCallback?)
 */
class WebChromeClientBuilder : WebChromeClientBuilderContract {

    private var getDefaultVideoPoster: MktSupplier<Bitmap?>? = null
    private var getVideoLoadingProgressView: MktSupplier<View?>? = null
    private var getVisitedHistory: MktConsumer<ValueCallback<Array<String>>?>? = null
    private var onCloseWindow: MktConsumer<WebView?>? = null
    private var onConsoleMessage: MktPredicate<ConsoleMessage?>? = null
    private var onCreateWindow: MktOnCreateWindowPredicate? = null
    private var onGeolocationPermissionsHidePrompt: MktRunnable? = null
    private var onGeolocationPermissionsShowPrompt: MktBiConsumer<String?, GeoCallback?>? = null
    private var onHideCustomView: MktRunnable? = null
    private var onJsAlert: MktOnJsPredicate? = null
    private var onJsBeforeUnload: MktOnJsPredicate? = null
    private var onJsConfirm: MktOnJsPredicate? = null
    private var onJsPrompt: MktOnJsPromptPredicate? = null
    private var onPermissionRequest: MktConsumer<PermissionRequest?>? = null
    private var onPermissionRequestCanceled: MktConsumer<PermissionRequest?>? = null
    private var onProgressChanged: MktObjIntConsumer<WebView?>? = null
    private var onReceivedIcon: MktBiConsumer<WebView?, Bitmap?>? = null
    private var onReceivedTitle: MktBiConsumer<WebView?, String?>? = null
    private var onReceivedTouchIconUrl: MktOnReceivedTouchIconUrlConsumer? = null
    private var onRequestFocus: MktConsumer<WebView?>? = null
    private var onShowCustomView: MktBiConsumer<View?, WebChromeClient.CustomViewCallback?>? = null
    private var onShowFileChooser: MktOnShowFileChooserPredicate? = null


    /** @see WebChromeClient.getDefaultVideoPoster */
    override fun getDefaultVideoPoster(value: MktSupplier<Bitmap?>) = apply {
        getDefaultVideoPoster = value
    }

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override fun getVideoLoadingProgressView(value: MktSupplier<View?>) = apply {
        getVideoLoadingProgressView = value
    }

    /** @see WebChromeClient.getVisitedHistory */
    override fun getVisitedHistory(value: MktConsumer<ValueCallback<Array<String>>?>) = apply {
        getVisitedHistory = value
    }

    /** @see WebChromeClient.onCloseWindow */
    override fun onCloseWindow(value: MktConsumer<WebView?>) = apply {
        onCloseWindow = value
    }

    /** @see WebChromeClient.onConsoleMessage */
    override fun onConsoleMessage(value: MktPredicate<ConsoleMessage?>) = apply {
        onConsoleMessage = value
    }

    /** @see WebChromeClient.onCreateWindow */
    override fun onCreateWindow(value: MktOnCreateWindowPredicate) = apply {
        onCreateWindow = value
    }

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    override fun onGeolocationPermissionsHidePrompt(value: MktRunnable) = apply {
        onGeolocationPermissionsHidePrompt = value
    }

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    override fun onGeolocationPermissionsShowPrompt(
        value: MktBiConsumer<String?, GeoCallback?>
    ) = apply {
        onGeolocationPermissionsShowPrompt = value
    }

    /** @see WebChromeClient.onHideCustomView */
    override fun onHideCustomView(value: MktRunnable) = apply {
        onHideCustomView = value
    }

    /** @see WebChromeClient.onJsAlert */
    override fun onJsAlert(value: MktOnJsPredicate) = apply {
        onJsAlert = value
    }

    /** @see WebChromeClient.onJsBeforeUnload */
    override fun onJsBeforeUnload(value: MktOnJsPredicate) = apply {
        onJsBeforeUnload = value
    }

    /** @see WebChromeClient.onJsConfirm */
    override fun onJsConfirm(value: MktOnJsPredicate) = apply {
        onJsConfirm = value
    }

    /** @see WebChromeClient.onJsPrompt */
    override fun onJsPrompt(value: MktOnJsPromptPredicate) = apply {
        onJsPrompt = value
    }

    /** @see WebChromeClient.onPermissionRequest */
    override fun onPermissionRequest(value: MktConsumer<PermissionRequest?>) = apply {
        onPermissionRequest = value
    }

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override fun onPermissionRequestCanceled(value: MktConsumer<PermissionRequest?>) = apply {
        onPermissionRequestCanceled = value
    }

    /** @see WebChromeClient.onProgressChanged */
    override fun onProgressChanged(value: MktObjIntConsumer<WebView?>) = apply {
        onProgressChanged = value
    }

    /** @see WebChromeClient.onReceivedIcon */
    override fun onReceivedIcon(value: MktBiConsumer<WebView?, Bitmap?>) = apply {
        onReceivedIcon = value
    }

    /** @see WebChromeClient.onReceivedTitle */
    override fun onReceivedTitle(value: MktBiConsumer<WebView?, String?>) = apply {
        onReceivedTitle = value
    }

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override fun onReceivedTouchIconUrl(value: MktOnReceivedTouchIconUrlConsumer) = apply {
        onReceivedTouchIconUrl = value
    }

    /** @see WebChromeClient.onRequestFocus */
    override fun onRequestFocus(value: MktConsumer<WebView?>) = apply {
        onRequestFocus = value
    }

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(
        value: MktBiConsumer<View?, WebChromeClient.CustomViewCallback?>
    ) = apply {
        onShowCustomView = value
    }

    /** @see WebChromeClient.onShowFileChooser */
    override fun onShowFileChooser(value: MktOnShowFileChooserPredicate) = apply {
        onShowFileChooser = value
    }


    /**
     * Creates [WebChromeClient] instance.
     */
    override fun create() = object : WebChromeClient() {

        override fun getDefaultVideoPoster(
        ) = getDefaultVideoPoster?.invoke()
            ?: super.getDefaultVideoPoster()

        override fun getVideoLoadingProgressView(
        ) = getVideoLoadingProgressView?.invoke()
            ?: super.getVideoLoadingProgressView()

        override fun getVisitedHistory(
            callback: ValueCallback<Array<String>>?
        ) = getVisitedHistory?.invoke(callback)
            ?: super.getVisitedHistory(callback)

        override fun onCloseWindow(
            window: WebView?
        ) = onCloseWindow?.invoke(window)
            ?: super.onCloseWindow(window)

        override fun onConsoleMessage(
            consoleMessage: ConsoleMessage?
        ) = onConsoleMessage?.invoke(consoleMessage)
            ?: super.onConsoleMessage(consoleMessage)

        override fun onCreateWindow(
            view: WebView?,
            isDialog: Boolean,
            isUserGesture: Boolean,
            resultMsg: Message?
        ) = onCreateWindow?.invoke(view, isDialog, isUserGesture, resultMsg)
            ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)

        override fun onGeolocationPermissionsHidePrompt(
        ) = onGeolocationPermissionsHidePrompt?.invoke()
            ?: super.onGeolocationPermissionsHidePrompt()

        override fun onGeolocationPermissionsShowPrompt(
            origin: String?,
            callback: GeoCallback?
        ) = onGeolocationPermissionsShowPrompt?.invoke(origin, callback)
            ?: super.onGeolocationPermissionsShowPrompt(origin, callback)

        override fun onHideCustomView(
        ) = onHideCustomView?.invoke()
            ?: super.onHideCustomView()

        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsAlert?.invoke(view, url, message, result)
            ?: super.onJsAlert(view, url, message, result)

        override fun onJsBeforeUnload(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsBeforeUnload?.invoke(view, url, message, result)
            ?: super.onJsBeforeUnload(view, url, message, result)

        override fun onJsConfirm(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsConfirm?.invoke(view, url, message, result)
            ?: super.onJsConfirm(view, url, message, result)

        override fun onJsPrompt(
            view: WebView?,
            url: String?,
            message: String?,
            defaultValue: String?,
            result: JsPromptResult?
        ) = onJsPrompt?.invoke(view, url, message, defaultValue, result)
            ?: super.onJsPrompt(view, url, message, defaultValue, result)

        override fun onPermissionRequest(
            request: PermissionRequest?
        ) = onPermissionRequest?.invoke(request)
            ?: super.onPermissionRequest(request)

        override fun onPermissionRequestCanceled(
            request: PermissionRequest?
        ) = onPermissionRequestCanceled?.invoke(request)
            ?: super.onPermissionRequestCanceled(request)

        override fun onProgressChanged(
            view: WebView?,
            newProgress: Int
        ) = onProgressChanged?.invoke(view, newProgress)
            ?: super.onProgressChanged(view, newProgress)

        override fun onReceivedIcon(
            view: WebView?,
            icon: Bitmap?
        ) = onReceivedIcon?.invoke(view, icon)
            ?: super.onReceivedIcon(view, icon)

        override fun onReceivedTitle(
            view: WebView?,
            title: String?
        ) = onReceivedTitle?.invoke(view, title)
            ?: super.onReceivedTitle(view, title)

        override fun onReceivedTouchIconUrl(
            view: WebView?,
            url: String?,
            precomposed: Boolean
        ) = onReceivedTouchIconUrl?.invoke(view, url, precomposed)
            ?: super.onReceivedTouchIconUrl(view, url, precomposed)

        override fun onRequestFocus(
            view: WebView?
        ) = onRequestFocus?.invoke(view)
            ?: super.onRequestFocus(view)

        override fun onShowCustomView(
            view: View?,
            callback: CustomViewCallback?
        ) = onShowCustomView?.invoke(view, callback)
            ?: super.onShowCustomView(view, callback)

        override fun onShowFileChooser(
            webView: WebView?,
            filePathCallback: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ) = onShowFileChooser?.invoke(webView, filePathCallback, fileChooserParams)
            ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}
