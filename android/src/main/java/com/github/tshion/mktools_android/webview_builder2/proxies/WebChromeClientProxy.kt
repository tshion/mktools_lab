package com.github.tshion.mktools_android.webview_builder2.proxies

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import android.webkit.WebChromeClient.CustomViewCallback
import android.webkit.WebChromeClient.FileChooserParams
import com.github.tshion.mktools_android.webview_builder.aliases.*
import com.github.tshion.mktools_android.webview_builder2.contracts.WebChromeClientBuilderContract

/**
 * Proxy of [WebChromeClient].
 */
internal class WebChromeClientProxy : WebChromeClientBuilderContract {

    private var getDefaultVideoPoster: MktSupplier<Bitmap?>? = null

    private var getVideoLoadingProgressView: MktSupplier<View?>? = null

    private var getVisitedHistory: MktConsumer<ValueCallback<Array<String>>>? = null

    private var onCloseWindow: MktConsumer<WebView>? = null

    private var onConsoleMessage: MktPredicate<ConsoleMessage>? = null

    private var onCreateWindow: MktOnCreateWindowPredicate? = null

    private var onGeolocationPermissionsHidePrompt: MktRunnable? = null

    private var onGeolocationPermissionsShowPrompt: MktBiConsumer<String, GeolocationPermissions.Callback>? =
        null

    private var onHideCustomView: MktRunnable? = null

    private var onJsAlert: MktOnJsPredicate? = null

    private var onJsBeforeUnload: MktOnJsPredicate? = null

    private var onJsConfirm: MktOnJsPredicate? = null

    private var onJsPrompt: MktOnJsPromptPredicate? = null

    private var onPermissionRequest: MktConsumer<PermissionRequest>? = null

    private var onPermissionRequestCanceled: MktConsumer<PermissionRequest>? = null

    private var onProgressChanged: MktObjIntConsumer<WebView>? = null

    private var onReceivedIcon: MktBiConsumer<WebView, Bitmap>? = null

    private var onReceivedTitle: MktBiConsumer<WebView, String>? = null

    private var onReceivedTouchIconUrl: MktBiObjBooleanConsumer<WebView, String>? = null

    private var onRequestFocus: MktConsumer<WebView>? = null

    private var onShowCustomView: MktBiConsumer<View, CustomViewCallback>? = null

    private var onShowFileChooser: MktTriPredicate<WebView, ValueCallback<Array<Uri>>, FileChooserParams>? =
        null


    override fun getDefaultVideoPoster(
        fx: MktSupplier<Bitmap?>
    ) = apply { getDefaultVideoPoster = fx }

    override fun getVideoLoadingProgressView(
        fx: MktSupplier<View?>
    ) = apply { getVideoLoadingProgressView = fx }

    override fun getVisitedHistory(
        fx: MktConsumer<ValueCallback<Array<String>>>
    ) = apply { getVisitedHistory = fx }

    override fun onCloseWindow(
        fx: MktConsumer<WebView>
    ) = apply { onCloseWindow = fx }

    override fun onConsoleMessageUntil15(
        fx: MktTriConsumer<String, Int, String>
    ) = this

    override fun onConsoleMessage(
        fx: MktPredicate<ConsoleMessage>
    ) = apply { onConsoleMessage = fx }

    override fun onCreateWindow(
        fx: MktOnCreateWindowPredicate
    ) = apply { onCreateWindow = fx }

    override fun onExceededDatabaseQuota(
        fx: MktOnExceededDatabaseQuotaConsumer
    ) = this

    override fun onGeolocationPermissionsHidePrompt(
        fx: MktRunnable
    ) = apply { onGeolocationPermissionsHidePrompt = fx }

    override fun onGeolocationPermissionsShowPrompt(
        fx: MktBiConsumer<String, GeolocationPermissions.Callback>
    ) = apply { onGeolocationPermissionsShowPrompt = fx }

    override fun onHideCustomView(
        fx: MktRunnable
    ) = apply { onHideCustomView = fx }

    override fun onJsAlert(
        fx: MktOnJsPredicate
    ) = apply { onJsAlert = fx }

    override fun onJsBeforeUnload(
        fx: MktOnJsPredicate
    ) = apply { onJsBeforeUnload = fx }

    override fun onJsConfirm(
        fx: MktOnJsPredicate
    ) = apply { onJsConfirm = fx }

    override fun onJsPrompt(
        fx: MktOnJsPromptPredicate
    ) = apply { onJsPrompt = fx }

    override fun onJsTimeout(
        fx: MktBooleanSupplier
    ) = this

    override fun onPermissionRequest(
        fx: MktConsumer<PermissionRequest>
    ) = apply { onPermissionRequest = fx }

    override fun onPermissionRequestCanceled(
        fx: MktConsumer<PermissionRequest>
    ) = apply { onPermissionRequestCanceled = fx }

    override fun onProgressChanged(
        fx: MktObjIntConsumer<WebView>
    ) = apply { onProgressChanged = fx }

    override fun onReceivedIcon(
        fx: MktBiConsumer<WebView, Bitmap>
    ) = apply { onReceivedIcon = fx }

    override fun onReceivedTitle(
        fx: MktBiConsumer<WebView, String>
    ) = apply { onReceivedTitle = fx }

    override fun onReceivedTouchIconUrl(
        fx: MktBiObjBooleanConsumer<WebView, String>
    ) = apply { onReceivedTouchIconUrl = fx }

    override fun onRequestFocus(
        fx: MktConsumer<WebView>
    ) = apply { onRequestFocus = fx }

    override fun onShowCustomViewUntil18(
        fx: MktTriConsumer<View, Int, CustomViewCallback>
    ) = this

    override fun onShowCustomView(
        fx: MktBiConsumer<View, CustomViewCallback>
    ) = apply { onShowCustomView = fx }

    override fun onShowFileChooser(
        fx: MktTriPredicate<WebView, ValueCallback<Array<Uri>>, FileChooserParams>
    ) = apply { onShowFileChooser = fx }


    override fun buildWebChromeClientBuilder() = object : WebChromeClient() {
        override fun getDefaultVideoPoster(
        ) = getDefaultVideoPoster?.invoke()
            ?: super.getDefaultVideoPoster()

        override fun getVideoLoadingProgressView(
        ) = getVideoLoadingProgressView?.invoke()
            ?: super.getVideoLoadingProgressView()

        override fun getVisitedHistory(
            callback: ValueCallback<Array<String>>?
        ) = getVisitedHistory?.invoke(callback!!)
            ?: super.getVisitedHistory(callback)

        override fun onCloseWindow(
            window: WebView?
        ) = onCloseWindow?.invoke(window!!)
            ?: super.onCloseWindow(window)

        override fun onConsoleMessage(
            consoleMessage: ConsoleMessage?
        ) = onConsoleMessage?.invoke(consoleMessage!!)
            ?: super.onConsoleMessage(consoleMessage)

        override fun onCreateWindow(
            view: WebView?,
            isDialog: Boolean,
            isUserGesture: Boolean,
            resultMsg: Message?
        ) = onCreateWindow?.invoke(view!!, isDialog, isUserGesture, resultMsg!!)
            ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)

        override fun onGeolocationPermissionsHidePrompt(
        ) = onGeolocationPermissionsHidePrompt?.invoke()
            ?: super.onGeolocationPermissionsHidePrompt()

        override fun onGeolocationPermissionsShowPrompt(
            origin: String?,
            callback: GeolocationPermissions.Callback?
        ) = onGeolocationPermissionsShowPrompt?.invoke(origin!!, callback!!)
            ?: super.onGeolocationPermissionsShowPrompt(origin, callback)

        override fun onHideCustomView(
        ) = onHideCustomView?.invoke()
            ?: super.onHideCustomView()

        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsAlert?.invoke(view!!, url!!, message!!, result!!)
            ?: super.onJsAlert(view, url, message, result)

        override fun onJsBeforeUnload(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsBeforeUnload?.invoke(view!!, url!!, message!!, result!!)
            ?: super.onJsBeforeUnload(view, url, message, result)

        override fun onJsConfirm(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ) = onJsConfirm?.invoke(view!!, url!!, message!!, result!!)
            ?: super.onJsConfirm(view, url, message, result)

        override fun onJsPrompt(
            view: WebView?,
            url: String?,
            message: String?,
            defaultValue: String?,
            result: JsPromptResult?
        ) = onJsPrompt?.invoke(view!!, url!!, message!!, defaultValue!!, result!!)
            ?: super.onJsPrompt(view, url, message, defaultValue, result)

        override fun onPermissionRequest(
            request: PermissionRequest?
        ) = onPermissionRequest?.invoke(request!!)
            ?: super.onPermissionRequest(request)

        override fun onPermissionRequestCanceled(
            request: PermissionRequest?
        ) = onPermissionRequestCanceled?.invoke(request!!)
            ?: super.onPermissionRequestCanceled(request)

        override fun onProgressChanged(
            view: WebView?,
            newProgress: Int
        ) = onProgressChanged?.invoke(view!!, newProgress)
            ?: super.onProgressChanged(view, newProgress)

        override fun onReceivedIcon(
            view: WebView?,
            icon: Bitmap?
        ) = onReceivedIcon?.invoke(view!!, icon!!)
            ?: super.onReceivedIcon(view, icon)

        override fun onReceivedTitle(
            view: WebView?,
            title: String?
        ) = onReceivedTitle?.invoke(view!!, title!!)
            ?: super.onReceivedTitle(view, title)

        override fun onReceivedTouchIconUrl(
            view: WebView?,
            url: String?,
            precomposed: Boolean
        ) = onReceivedTouchIconUrl?.invoke(view!!, url!!, precomposed)
            ?: super.onReceivedTouchIconUrl(view, url, precomposed)

        override fun onRequestFocus(
            view: WebView?
        ) = onRequestFocus?.invoke(view!!)
            ?: super.onRequestFocus(view)

        override fun onShowCustomView(
            view: View?,
            callback: CustomViewCallback?
        ) = onShowCustomView?.invoke(view!!, callback!!)
            ?: super.onShowCustomView(view, callback)

        override fun onShowFileChooser(
            webView: WebView?,
            filePathCallback: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ) = onShowFileChooser?.invoke(webView!!, filePathCallback!!, fileChooserParams!!)
            ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }

    override fun canBuildWebChromeClientBuilder() = (
        getDefaultVideoPoster
            ?: getVideoLoadingProgressView
            ?: getVisitedHistory
            ?: onCloseWindow
            ?: onConsoleMessage
            ?: onCreateWindow
            ?: onGeolocationPermissionsHidePrompt
            ?: onGeolocationPermissionsShowPrompt
            ?: onHideCustomView
            ?: onJsAlert
            ?: onJsBeforeUnload
            ?: onJsConfirm
            ?: onJsPrompt
            ?: onPermissionRequest
            ?: onPermissionRequestCanceled
            ?: onProgressChanged
            ?: onReceivedIcon
            ?: onReceivedTitle
            ?: onReceivedTouchIconUrl
            ?: onRequestFocus
            ?: onShowCustomView
            ?: onShowFileChooser
        ).let { it != null }
}
