package com.github.tshion.mktools_android.webview_builder.candidate

import android.graphics.Bitmap
import android.view.View
import android.webkit.*

/**
 * Defines [WebChromeClient] build rule.
 */
interface WebChromeClientBuilderContract {

    /**
     * Creates [WebChromeClient] instance.
     */
    fun create(): WebChromeClient

    /** @see WebChromeClient.getDefaultVideoPoster */
    fun getDefaultVideoPoster(value: MktSupplier<Bitmap?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.getVideoLoadingProgressView */
    fun getVideoLoadingProgressView(value: MktSupplier<View?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.getVisitedHistory */
    fun getVisitedHistory(value: MktConsumer<ValueCallback<Array<String>>?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onCloseWindow */
    fun onCloseWindow(value: MktConsumer<WebView?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onConsoleMessage */
    fun onConsoleMessage(value: MktPredicate<ConsoleMessage?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onCreateWindow */
    fun onCreateWindow(value: MktOnCreateWindowPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    fun onGeolocationPermissionsHidePrompt(value: MktRunnable): WebChromeClientBuilderContract

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    fun onGeolocationPermissionsShowPrompt(value: MktBiConsumer<String?, GeolocationPermissions.Callback?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onHideCustomView */
    fun onHideCustomView(value: MktRunnable): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsAlert */
    fun onJsAlert(value: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsBeforeUnload */
    fun onJsBeforeUnload(value: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsConfirm */
    fun onJsConfirm(value: MktOnJsPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onJsPrompt */
    fun onJsPrompt(value: MktOnJsPromptPredicate): WebChromeClientBuilderContract

    /** @see WebChromeClient.onPermissionRequest */
    fun onPermissionRequest(value: MktConsumer<PermissionRequest?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onPermissionRequestCanceled */
    fun onPermissionRequestCanceled(value: MktConsumer<PermissionRequest?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onProgressChanged */
    fun onProgressChanged(value: MktObjIntConsumer<WebView?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedIcon */
    fun onReceivedIcon(value: MktBiConsumer<WebView?, Bitmap?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedTitle */
    fun onReceivedTitle(value: MktBiConsumer<WebView?, String?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    fun onReceivedTouchIconUrl(value: MktOnReceivedTouchIconUrlConsumer): WebChromeClientBuilderContract

    /** @see WebChromeClient.onRequestFocus */
    fun onRequestFocus(value: MktConsumer<WebView?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onShowCustomView */
    fun onShowCustomView(value: MktBiConsumer<View?, WebChromeClient.CustomViewCallback?>): WebChromeClientBuilderContract

    /** @see WebChromeClient.onShowFileChooser */
    fun onShowFileChooser(value: MktOnShowFileChooserPredicate): WebChromeClientBuilderContract
}
