package com.github.tshion.mktools_android.webview_builder.candidate.entities

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import android.webkit.WebChromeClient.CustomViewCallback
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*
import android.webkit.GeolocationPermissions.Callback as GeoCallback

/**
 * State of [WebChromeClient].
 */
internal data class WebChromeClientEntity(
    var getDefaultVideoPoster: MktSupplier<Bitmap?>? = null,
    var getVideoLoadingProgressView: MktSupplier<View?>? = null,
    var getVisitedHistory: MktConsumer<ValueCallback<Array<String?>?>>? = null,
    var onCloseWindow: MktConsumer<WebView?>? = null,
    // var onConsoleMessage: ((String?, Int, String?) -> Unit)? = null, // Deprecated in API level 15
    var onConsoleMessage: MktPredicate<ConsoleMessage?>? = null,
    var onCreateWindow: MktOnCreateWindowPredicate? = null,
    // var onExceededDatabaseQuota: ((String?, String?, Long, Long, Long, WebStorage.QuotaUpdater?) -> Unit)? = null, // Deprecated in API level 19
    var onGeolocationPermissionsHidePrompt: MktRunnable? = null,
    var onGeolocationPermissionsShowPrompt: MktBiConsumer<String?, GeoCallback?>? = null,
    var onHideCustomView: MktRunnable? = null,
    var onJsAlert: MktOnJsPredicate? = null,
    var onJsBeforeUnload: MktOnJsPredicate? = null,
    var onJsConfirm: MktOnJsPredicate? = null,
    var onJsPrompt: MktOnJsPromptPredicate? = null,
    // var onJsTimeout: MktBooleanSupplier? = null, // Deprecated in API level 17
    var onPermissionRequest: MktConsumer<PermissionRequest?>? = null,
    var onPermissionRequestCanceled: MktConsumer<PermissionRequest?>? = null,
    var onProgressChanged: MktObjIntConsumer<WebView?>? = null,
    // var onReachedMaxAppCacheSize: ((Long, Long, WebStorage.QuotaUpdater?) -> Unit)? = null, // Deprecated in API level 19
    var onReceivedIcon: MktBiConsumer<WebView?, Bitmap?>? = null,
    var onReceivedTitle: MktBiConsumer<WebView?, String?>? = null,
    var onReceivedTouchIconUrl: MktOnReceivedTouchIconUrlConsumer? = null,
    var onRequestFocus: MktConsumer<WebView?>? = null,
    // var onShowCustomView: ((View?, Int, CustomViewCallback?) -> Unit? = null, // Deprecated in API level 18
    var onShowCustomView: MktBiConsumer<View?, CustomViewCallback?>? = null,
    var onShowFileChooser: MktOnShowFileChooserPredicate? = null,
) {

    /**
     * Creates [WebChromeClient] instance.
     */
    fun newInstance() = object : WebChromeClient() {

        override fun getDefaultVideoPoster(
        ) = getDefaultVideoPoster?.invoke()
            ?: super.getDefaultVideoPoster()

        override fun getVideoLoadingProgressView(
        ) = getVideoLoadingProgressView?.invoke()
            ?: super.getVideoLoadingProgressView()

        override fun getVisitedHistory(
            callback: ValueCallback<Array<String?>?>
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
            filePathCallback: ValueCallback<Array<Uri?>?>?,
            fileChooserParams: FileChooserParams?
        ) = onShowFileChooser?.invoke(webView, filePathCallback, fileChooserParams)
            ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}
