package com.github.tshion.mktools_android.webview_builder2.contracts

import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import android.webkit.*
import android.webkit.WebChromeClient.CustomViewCallback
import android.webkit.WebChromeClient.FileChooserParams
import com.github.tshion.mktools_android.webview_builder.aliases.*

/**
 * Defines [WebChromeClient] build rule.
 */
interface WebChromeClientBuilderContract {

    /** @see WebChromeClient.getDefaultVideoPoster */
    fun getDefaultVideoPoster(fx: MktSupplier<Bitmap?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.getVideoLoadingProgressView */
    fun getVideoLoadingProgressView(fx: MktSupplier<View?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.getVisitedHistory */
    fun getVisitedHistory(fx: MktConsumer<ValueCallback<Array<String>>>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onCloseWindow */
    fun onCloseWindow(fx: MktConsumer<WebView>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onConsoleMessage */
    @Deprecated("Deprecated in API level 15")
    fun onConsoleMessageUntil15(fx: MktTriConsumer<String, Int, String>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onConsoleMessage */
    fun onConsoleMessage(fx: MktPredicate<ConsoleMessage>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onCreateWindow */
    fun onCreateWindow(fx: MktOnCreateWindowPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onExceededDatabaseQuota */
    @Deprecated("Deprecated in API level 19")
    fun onExceededDatabaseQuota(fx: MktOnExceededDatabaseQuotaConsumer): WebChromeClientBuilderContract

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    fun onGeolocationPermissionsHidePrompt(fx: MktRunnable): WebChromeClientBuilderContract

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    fun onGeolocationPermissionsShowPrompt(fx: MktBiConsumer<String, GeolocationPermissions.Callback>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onHideCustomView */
    fun onHideCustomView(fx: MktRunnable): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsAlert */
    fun onJsAlert(fx: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsBeforeUnload */
    fun onJsBeforeUnload(fx: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsConfirm */
    fun onJsConfirm(fx: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsPrompt */
    fun onJsPrompt(fx: MktOnJsPromptPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsTimeout */
    @Deprecated("Deprecated in API level 17")
    fun onJsTimeout(fx: MktBooleanSupplier): WebChromeClientBuilderContract

    /** @see WebChromeClient.onPermissionRequest */
    fun onPermissionRequest(fx: MktConsumer<PermissionRequest>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onPermissionRequestCanceled */
    fun onPermissionRequestCanceled(fx: MktConsumer<PermissionRequest>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onProgressChanged */
    fun onProgressChanged(fx: MktObjIntConsumer<WebView>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedIcon */
    fun onReceivedIcon(fx: MktBiConsumer<WebView, Bitmap>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedTitle */
    fun onReceivedTitle(fx: MktBiConsumer<WebView, String>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    fun onReceivedTouchIconUrl(fx: MktBiObjBooleanConsumer<WebView, String>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onRequestFocus */
    fun onRequestFocus(fx: MktConsumer<WebView>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onShowCustomView */
    @Deprecated("Deprecated in API level 18")
    fun onShowCustomViewUntil18(fx: MktTriConsumer<View, Int, CustomViewCallback>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onShowCustomView */
    fun onShowCustomView(fx: MktBiConsumer<View, CustomViewCallback>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onShowFileChooser */
    fun onShowFileChooser(fx: MktTriPredicate<WebView, ValueCallback<Array<Uri>>, FileChooserParams>): WebChromeClientBuilderContract


    fun buildWebChromeClientBuilder(): WebChromeClient

    fun canBuildWebChromeClientBuilder(): Boolean
}
