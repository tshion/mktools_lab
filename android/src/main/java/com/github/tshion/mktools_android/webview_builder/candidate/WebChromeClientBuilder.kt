package com.github.tshion.mktools_android.webview_builder.candidate

import android.graphics.Bitmap
import android.view.View
import android.webkit.*
import android.webkit.WebChromeClient.CustomViewCallback
import android.webkit.WebStorage.QuotaUpdater
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*
import com.github.tshion.mktools_android.webview_builder.candidate.contracts.WebChromeClientBuilderContract
import com.github.tshion.mktools_android.webview_builder.candidate.entities.WebChromeClientEntity
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
 */
class WebChromeClientBuilder : WebChromeClientBuilderContract {

    private val state = WebChromeClientEntity()


    /** @see WebChromeClient.getDefaultVideoPoster */
    override fun getDefaultVideoPoster(fx: MktSupplier<Bitmap?>) = apply {
        state.getDefaultVideoPoster = fx
    }

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override fun getVideoLoadingProgressView(fx: MktSupplier<View?>) = apply {
        state.getVideoLoadingProgressView = fx
    }

    /** @see WebChromeClient.getVisitedHistory */
    override fun getVisitedHistory(fx: MktConsumer<ValueCallback<Array<String?>?>?>) = apply {
        state.getVisitedHistory = fx
    }

    /** @see WebChromeClient.onCloseWindow */
    override fun onCloseWindow(fx: MktConsumer<WebView?>) = apply {
        state.onCloseWindow = fx
    }

    /** @see WebChromeClient.onConsoleMessage */
    override fun onConsoleMessage(fx: (String?, Int, String?) -> Unit) = this

    /** @see WebChromeClient.onConsoleMessage */
    override fun onConsoleMessage(fx: MktPredicate<ConsoleMessage?>) = apply {
        state.onConsoleMessage = fx
    }

    /** @see WebChromeClient.onCreateWindow */
    override fun onCreateWindow(fx: MktOnCreateWindowPredicate) = apply {
        state.onCreateWindow = fx
    }

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    override fun onGeolocationPermissionsHidePrompt(fx: MktRunnable) = apply {
        state.onGeolocationPermissionsHidePrompt = fx
    }

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    override fun onGeolocationPermissionsShowPrompt(
        fx: MktBiConsumer<String?, GeoCallback?>
    ) = apply {
        state.onGeolocationPermissionsShowPrompt = fx
    }

    /** @see WebChromeClient.onExceededDatabaseQuota */
    override fun onExceededDatabaseQuota(
        fx: (String?, String?, Long, Long, Long, QuotaUpdater?) -> Unit
    ) = this

    /** @see WebChromeClient.onHideCustomView */
    override fun onHideCustomView(fx: MktRunnable) = apply {
        state.onHideCustomView = fx
    }

    /** @see WebChromeClient.onJsAlert */
    override fun onJsAlert(fx: MktOnJsPredicate) = apply {
        state.onJsAlert = fx
    }

    /** @see WebChromeClient.onJsBeforeUnload */
    override fun onJsBeforeUnload(fx: MktOnJsPredicate) = apply {
        state.onJsBeforeUnload = fx
    }

    /** @see WebChromeClient.onJsConfirm */
    override fun onJsConfirm(fx: MktOnJsPredicate) = apply {
        state.onJsConfirm = fx
    }

    /** @see WebChromeClient.onJsPrompt */
    override fun onJsPrompt(fx: MktOnJsPromptPredicate) = apply {
        state.onJsPrompt = fx
    }

    /** @see WebChromeClient.onJsTimeout */
    override fun onJsTimeout(fx: MktBooleanSupplier) = this

    /** @see WebChromeClient.onPermissionRequest */
    override fun onPermissionRequest(fx: MktConsumer<PermissionRequest?>) = apply {
        state.onPermissionRequest = fx
    }

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override fun onPermissionRequestCanceled(fx: MktConsumer<PermissionRequest?>) = apply {
        state.onPermissionRequestCanceled = fx
    }

    /** @see WebChromeClient.onProgressChanged */
    override fun onProgressChanged(fx: MktObjIntConsumer<WebView?>) = apply {
        state.onProgressChanged = fx
    }

    /** @see WebChromeClient.onReachedMaxAppCacheSize */
    override fun onReachedMaxAppCacheSize(fx: (Long, Long, QuotaUpdater?) -> Unit) = this

    /** @see WebChromeClient.onReceivedIcon */
    override fun onReceivedIcon(fx: MktBiConsumer<WebView?, Bitmap?>) = apply {
        state.onReceivedIcon = fx
    }

    /** @see WebChromeClient.onReceivedTitle */
    override fun onReceivedTitle(fx: MktBiConsumer<WebView?, String?>) = apply {
        state.onReceivedTitle = fx
    }

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override fun onReceivedTouchIconUrl(fx: MktOnReceivedTouchIconUrlConsumer) = apply {
        state.onReceivedTouchIconUrl = fx
    }

    /** @see WebChromeClient.onRequestFocus */
    override fun onRequestFocus(fx: MktConsumer<WebView?>) = apply {
        state.onRequestFocus = fx
    }

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(fx: (View?, Int, CustomViewCallback?) -> Unit) = this

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(
        fx: MktBiConsumer<View?, CustomViewCallback?>
    ) = apply {
        state.onShowCustomView = fx
    }

    /** @see WebChromeClient.onShowFileChooser */
    override fun onShowFileChooser(fx: MktOnShowFileChooserPredicate) = apply {
        state.onShowFileChooser = fx
    }


    /**
     * Creates [WebChromeClient] instance.
     */
    fun create() = state.newInstance()
}
