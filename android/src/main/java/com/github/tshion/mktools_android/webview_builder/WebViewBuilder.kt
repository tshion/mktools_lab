package com.github.tshion.mktools_android.webview_builder

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import androidx.webkit.*
import com.github.tshion.mktools_android.webview_builder.inner.WebChromeClientContract
import com.github.tshion.mktools_android.webview_builder.inner.WebSettingsContract
import com.github.tshion.mktools_android.webview_builder.inner.WebViewClientContract
import com.github.tshion.mktools_android.webview_builder.inner.WebViewContract

/**
 * Builder for WebView
 */
class WebViewBuilder : WebChromeClientContract, WebSettingsContract, WebViewContract,
    WebViewClientContract {

    /** @see WebSettings.setAllowContentAccess */
    private var allowContentAccess: Boolean? = null

    /** @see WebSettings.setAllowFileAccess */
    private var allowFileAccess: Boolean? = null

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    private var allowFileAccessFromFileURLs: Boolean? = null

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    private var allowUniversalAccessFromFileURLs: Boolean? = null

    /** @see WebSettings.setAppCacheEnabled */
    private var appCacheEnabled: Boolean? = null

    /** @see WebSettings.setAppCachePath */
    private var appCachePath: String? = null

    /** @see WebSettings.setBlockNetworkImage */
    private var blockNetworkImage: Boolean? = null

    /** @see WebSettings.setBlockNetworkLoads */
    private var blockNetworkLoads: Boolean? = null

    /** @see WebSettings.setBuiltInZoomControls */
    private var builtInZoomControls: Boolean? = null

    /** @see WebSettings.setCacheMode */
    @get:WebSettingsContract.CacheModeType
    @setparam:WebSettingsContract.CacheModeType
    private var cacheMode: Int? = null

    /** @see WebSettings.setCursiveFontFamily */
    private var cursiveFontFamily: String? = null

    /** @see WebSettings.setDatabaseEnabled */
    private var databaseEnabled: Boolean? = null

    /** @see WebSettings.setDefaultFixedFontSize */
    private var defaultFixedFontSize: Int? = null

    /** @see WebSettings.setDefaultFontSize */
    private var defaultFontSize: Int? = null

    /** @see WebSettings.setDefaultTextEncodingName */
    private var defaultTextEncodingName: String? = null

    /** @see WebSettings.setDisabledActionModeMenuItems */
    @get:WebSettingsContract.MenuItemsType
    @setparam:WebSettingsContract.MenuItemsType
    private var disabledActionModeMenuItems: Int? = null

    /** @see WebSettings.setDisplayZoomControls */
    private var displayZoomControls: Boolean? = null

    /** @see WebSettings.setDomStorageEnabled */
    private var domStorageEnabled: Boolean? = null

    /** @see WebViewClient.doUpdateVisitedHistory */
    private var doUpdateVisitedHistory: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)? =
        null

    /** @see WebSettings.setFantasyFontFamily */
    private var fantasyFontFamily: String? = null

    /** @see WebSettings.setFixedFontFamily */
    private var fixedFontFamily: String? = null

    /** @see WebSettings.setForceDark */
    @get:WebSettingsContract.ForceDarkType
    @setparam:WebSettingsContract.ForceDarkType
    private var forceDark: Int? = null

    /** @see WebSettings.setGeolocationEnabled */
    private var geolocationEnabled: Boolean? = null

    /** @see WebChromeClient.getDefaultVideoPoster */
    private var getDefaultVideoPoster: (() -> Bitmap?)? = null

    /** @see WebChromeClient.getVideoLoadingProgressView */
    private var getVideoLoadingProgressView: (() -> View?)? = null

    /** @see WebChromeClient.getVisitedHistory */
    private var getVisitedHistory: ((callback: ValueCallback<Array<String>>?) -> Unit)? = null

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    private var javaScriptCanOpenWindowsAutomatically: Boolean? = null

    /** @see WebSettings.setJavaScriptEnabled */
    private var javaScriptEnabled: Boolean? = null

    /** @see WebSettings.setLayoutAlgorithm */
    private var layoutAlgorithm: WebSettings.LayoutAlgorithm? = null

    /** @see WebSettings.setLoadWithOverviewMode */
    private var loadWithOverviewMode: Boolean? = null

    /** @see WebSettings.setLoadsImagesAutomatically */
    private var loadsImagesAutomatically: Boolean? = null

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    private var mediaPlaybackRequiresUserGesture: Boolean? = null

    /** @see WebSettings.setMinimumFontSize */
    private var minimumFontSize: Int? = null

    /** @see WebSettings.setMinimumLogicalFontSize */
    @get:WebSettingsContract.MixedContentModeType
    @setparam:WebSettingsContract.MixedContentModeType
    private var minimumLogicalFontSize: Int? = null

    /** @see WebSettings.setMixedContentMode */
    private var mixedContentMode: Int? = null

    /** @see WebSettings.setNeedInitialFocus */
    private var needInitialFocus: Boolean? = null

    /** @see WebSettings.setOffscreenPreRaster */
    private var offscreenPreRaster: Boolean? = null

    /** @see WebChromeClient.onCloseWindow */
    private var onCloseWindow: ((window: WebView?) -> Unit)? = null

    /** @see WebChromeClient.onConsoleMessage */
    private var onConsoleMessage: ((consoleMessage: ConsoleMessage?) -> Boolean)? = null

    /** @see WebChromeClient.onCreateWindow */
    private var onCreateWindow: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)? =
        null

    /** @see WebViewClient.onFormResubmission */
    private var onFormResubmission: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)? =
        null

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    private var onGeolocationPermissionsHidePrompt: (() -> Unit)? = null

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    private var onGeolocationPermissionsShowPrompt: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)? =
        null

    /** @see WebChromeClient.onHideCustomView */
    private var onHideCustomView: (() -> Unit)? = null

    /** @see WebChromeClient.onJsAlert */
    private var onJsAlert: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? =
        null

    /** @see WebChromeClient.onJsBeforeUnload */
    private var onJsBeforeUnload: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? =
        null

    /** @see WebChromeClient.onJsConfirm */
    private var onJsConfirm: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)? =
        null

    /** @see WebChromeClient.onJsPrompt */
    private var onJsPrompt: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)? =
        null

    /** @see WebViewClient.onLoadResource */
    private var onLoadResource: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    private var onPageCommitVisible: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageFinished */
    private var onPageFinished: ((view: WebView?, url: String?) -> Unit)? = null

    /** @see WebViewClient.onPageStarted */
    private var onPageStarted: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)? = null

    /** @see WebChromeClient.onPermissionRequest */
    private var onPermissionRequest: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onPermissionRequestCanceled */
    private var onPermissionRequestCanceled: ((request: PermissionRequest?) -> Unit)? = null

    /** @see WebChromeClient.onProgressChanged */
    private var onProgressChanged: ((view: WebView?, newProgress: Int) -> Unit)? = null

    /** @see WebViewClient.onReceivedClientCertRequest */
    private var onReceivedClientCertRequest: ((view: WebView?, request: ClientCertRequest?) -> Unit)? =
        null

    /** @see WebViewClient.onReceivedError */
    @TargetApi(23)
    private var onReceivedError: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)? =
        null

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    private var onReceivedHttpAuthRequest: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)? =
        null

    /** @see WebViewClient.onReceivedHttpError */
    @TargetApi(23)
    private var onReceivedHttpError: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)? =
        null

    /** @see WebChromeClient.onReceivedIcon */
    private var onReceivedIcon: ((view: WebView?, icon: Bitmap?) -> Unit)? = null

    /** @see WebViewClient.onReceivedLoginRequest */
    private var onReceivedLoginRequest: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)? =
        null

    /** @see WebViewClient.onReceivedSslError */
    private var onReceivedSslError: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)? =
        null

    /** @see WebChromeClient.onReceivedTitle */
    private var onReceivedTitle: ((view: WebView?, title: String?) -> Unit)? = null

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    private var onReceivedTouchIconUrl: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)? =
        null

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    private var onRenderProcessGone: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)? =
        null

    /** @see WebChromeClient.onRequestFocus */
    private var onRequestFocus: ((view: WebView?) -> Unit)? = null

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    private var onSafeBrowsingHit: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)? =
        null

    /** @see WebViewClient.onScaleChanged */
    private var onScaleChanged: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)? = null

    /** @see WebChromeClient.onShowCustomView */
    private var onShowCustomView: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)? =
        null

    /** @see WebChromeClient.onShowFileChooser */
    private var onShowFileChooser: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)? =
        null

    /** @see WebSettings.setSafeBrowsingEnabled */
    private var safeBrowsingEnabled: Boolean? = null

    /** @see WebSettings.setSansSerifFontFamily */
    private var sansSerifFontFamily: String? = null

    /** @see WebSettings.setSerifFontFamily */
    private var serifFontFamily: String? = null

    /** @see WebViewClient.shouldInterceptRequest */
    private var shouldInterceptRequest: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)? =
        null

    /** @see WebViewClient.shouldOverrideKeyEvent */
    private var shouldOverrideKeyEvent: ((view: WebView?, event: KeyEvent?) -> Boolean)? = null

    /** @see WebViewClient.shouldOverrideUrlLoading */
    private var shouldOverrideUrlLoading: ((view: WebView?, request: WebResourceRequest?) -> Boolean)? =
        null

    /** @see WebSettings.setStandardFontFamily */
    private var standardFontFamily: String? = null

    /** @see WebSettings.supportMultipleWindows */
    private var supportMultipleWindows: Boolean? = null

    /** @see WebSettings.supportZoom */
    private var supportZoom: Boolean? = null

    /** @see WebSettings.setTextZoom */
    private var textZoom: Int? = null

    /** @see WebSettings.setUserAgentString */
    private var userAgentString: String? = null

    /** @see WebSettings.setUseWideViewPort */
    private var useWideViewPort: Boolean? = null


    /** @see WebSettings.setAllowContentAccess */
    override fun allowContentAccess(input: Boolean?) = apply { allowContentAccess = input }

    /** @see WebSettings.setAllowFileAccess */
    override fun allowFileAccess(input: Boolean?) = apply { allowFileAccess = input }

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    override fun allowFileAccessFromFileURLs(input: Boolean?) =
        apply { allowFileAccessFromFileURLs = input }

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    override fun allowUniversalAccessFromFileURLs(input: Boolean?) =
        apply { allowUniversalAccessFromFileURLs = input }

    /** @see WebSettings.setAppCacheEnabled */
    override fun appCacheEnabled(input: Boolean?) = apply { appCacheEnabled = input }

    /** @see WebSettings.setAppCachePath */
    override fun appCachePath(input: String?) = apply { appCachePath = input }

    /** @see WebSettings.setBlockNetworkImage */
    override fun blockNetworkImage(input: Boolean?) = apply { blockNetworkImage = input }

    /** @see WebSettings.setBlockNetworkLoads */
    override fun blockNetworkLoads(input: Boolean?) = apply { blockNetworkLoads = input }

    /** @see WebSettings.setBuiltInZoomControls */
    override fun builtInZoomControls(input: Boolean?) = apply { builtInZoomControls = input }

    /** @see WebSettings.setCacheMode */
    override fun cacheMode(@WebSettingsContract.CacheModeType input: Int?) =
        apply { cacheMode = input }

    /** @see WebSettings.setCursiveFontFamily */
    override fun cursiveFontFamily(input: String?) = apply { cursiveFontFamily = input }

    /** @see WebSettings.setDatabaseEnabled */
    override fun databaseEnabled(input: Boolean?) = apply { databaseEnabled = input }

    /** @see WebSettings.setDefaultFixedFontSize */
    override fun defaultFixedFontSize(input: Int?) = apply { defaultFixedFontSize = input }

    /** @see WebSettings.setDefaultFontSize */
    override fun defaultFontSize(input: Int?) = apply { defaultFontSize = input }

    /** @see WebSettings.setDefaultTextEncodingName */
    override fun defaultTextEncodingName(input: String?) = apply { defaultTextEncodingName = input }

    /** @see WebSettings.setDisabledActionModeMenuItems */
    override fun disabledActionModeMenuItems(@WebSettingsContract.MenuItemsType input: Int?) =
        apply { disabledActionModeMenuItems = input }

    /** @see WebSettings.setDisplayZoomControls */
    override fun displayZoomControls(input: Boolean?) = apply { displayZoomControls = input }

    /** @see WebSettings.setDomStorageEnabled */
    override fun domStorageEnabled(input: Boolean?) = apply { domStorageEnabled = input }

    /** @see WebViewClient.doUpdateVisitedHistory */
    override fun doUpdateVisitedHistory(callback: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?) =
        apply { doUpdateVisitedHistory = callback }

    /** @see WebSettings.setFantasyFontFamily */
    override fun fantasyFontFamily(input: String?) = apply { fantasyFontFamily = input }

    /** @see WebSettings.setFixedFontFamily */
    override fun fixedFontFamily(input: String?) = apply { fixedFontFamily = input }

    /** @see WebSettings.setForceDark */
    override fun forceDark(@WebSettingsContract.ForceDarkType input: Int?) =
        apply { forceDark = input }

    /** @see WebSettings.setGeolocationEnabled */
    override fun geolocationEnabled(input: Boolean?) = apply { geolocationEnabled = input }

    /** @see WebChromeClient.getDefaultVideoPoster */
    override fun getDefaultVideoPoster(callback: (() -> Bitmap?)?) =
        apply { getDefaultVideoPoster = callback }

    /** @see WebChromeClient.getVideoLoadingProgressView */
    override fun getVideoLoadingProgressView(callback: (() -> View?)?) =
        apply { getVideoLoadingProgressView = callback }

    /** @see WebChromeClient.getVisitedHistory */
    override fun getVisitedHistory(callback: ((callback: ValueCallback<Array<String>>?) -> Unit)?) =
        apply { getVisitedHistory = callback }

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    override fun javaScriptCanOpenWindowsAutomatically(input: Boolean?) =
        apply { javaScriptCanOpenWindowsAutomatically = input }

    /** @see WebSettings.setJavaScriptEnabled */
    override fun javaScriptEnabled(input: Boolean?) = apply { javaScriptEnabled = input }

    /** @see WebSettings.setLayoutAlgorithm */
    override fun layoutAlgorithm(input: WebSettings.LayoutAlgorithm?) =
        apply { layoutAlgorithm = input }

    /** @see WebSettings.setLoadsImagesAutomatically */
    override fun loadsImagesAutomatically(input: Boolean?) =
        apply { loadsImagesAutomatically = input }

    /** @see WebSettings.setLoadWithOverviewMode */
    override fun loadWithOverviewMode(input: Boolean?) = apply { loadWithOverviewMode = input }

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    override fun mediaPlaybackRequiresUserGesture(input: Boolean?) =
        apply { mediaPlaybackRequiresUserGesture = input }

    /** @see WebSettings.setMinimumFontSize */
    override fun minimumFontSize(input: Int?) = apply { minimumFontSize = input }

    /** @see WebSettings.setMinimumLogicalFontSize */
    override fun minimumLogicalFontSize(input: Int?) = apply { minimumLogicalFontSize = input }

    /** @see WebSettings.setMixedContentMode */
    override fun mixedContentMode(@WebSettingsContract.MixedContentModeType input: Int?) =
        apply { mixedContentMode = input }

    /** @see WebSettings.setNeedInitialFocus */
    override fun needInitialFocus(input: Boolean?) = apply { needInitialFocus = input }

    /** @see WebSettings.setOffscreenPreRaster */
    override fun offscreenPreRaster(input: Boolean?) = apply { offscreenPreRaster = input }

    /** @see WebChromeClient.onCloseWindow */
    override fun onCloseWindow(callback: ((window: WebView?) -> Unit)?) =
        apply { onCloseWindow = callback }

    /** @see WebChromeClient.onConsoleMessage */
    override fun onConsoleMessage(callback: ((consoleMessage: ConsoleMessage?) -> Boolean)?) =
        apply { onConsoleMessage = callback }

    /** @see WebChromeClient.onCreateWindow */
    override fun onCreateWindow(callback: ((view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean)?) =
        apply { onCreateWindow = callback }

    /** @see WebChromeClient.onGeolocationPermissionsHidePrompt */
    override fun onGeolocationPermissionsHidePrompt(callback: (() -> Unit)?) =
        apply { onGeolocationPermissionsHidePrompt = callback }

    /** @see WebChromeClient.onGeolocationPermissionsShowPrompt */
    override fun onGeolocationPermissionsShowPrompt(callback: ((origin: String?, callback: GeolocationPermissions.Callback?) -> Unit)?) =
        apply { onGeolocationPermissionsShowPrompt = callback }

    /** @see WebViewClient.onFormResubmission */
    override fun onFormResubmission(callback: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?) =
        apply { onFormResubmission = callback }

    /** @see WebChromeClient.onHideCustomView */
    override fun onHideCustomView(callback: (() -> Unit)?) = apply { onHideCustomView = callback }

    /** @see WebChromeClient.onJsAlert */
    override fun onJsAlert(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) =
        apply { onJsAlert = callback }

    /** @see WebChromeClient.onJsBeforeUnload */
    override fun onJsBeforeUnload(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) =
        apply { onJsBeforeUnload = callback }

    /** @see WebChromeClient.onJsConfirm */
    override fun onJsConfirm(callback: ((view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean)?) =
        apply { onJsConfirm = callback }

    /** @see WebChromeClient.onJsPrompt */
    override fun onJsPrompt(callback: ((view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean)?) =
        apply { onJsPrompt = callback }

    /** @see WebViewClient.onLoadResource */
    override fun onLoadResource(callback: ((view: WebView?, url: String?) -> Unit)?) =
        apply { onLoadResource = callback }

    /** @see WebViewClient.onPageCommitVisible */
    @TargetApi(23)
    override fun onPageCommitVisible(callback: ((view: WebView?, url: String?) -> Unit)?) =
        apply { onPageCommitVisible = callback }

    /** @see WebViewClient.onPageFinished */
    override fun onPageFinished(callback: ((view: WebView?, url: String?) -> Unit)?) =
        apply { onPageFinished = callback }

    /** @see WebViewClient.onPageStarted */
    override fun onPageStarted(callback: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?) =
        apply { onPageStarted = callback }

    /** @see WebChromeClient.onPermissionRequest */
    override fun onPermissionRequest(callback: ((request: PermissionRequest?) -> Unit)?) =
        apply { onPermissionRequest = callback }

    /** @see WebChromeClient.onPermissionRequestCanceled */
    override fun onPermissionRequestCanceled(callback: ((request: PermissionRequest?) -> Unit)?) =
        apply { onPermissionRequestCanceled = callback }

    /** @see WebChromeClient.onProgressChanged */
    override fun onProgressChanged(callback: ((view: WebView?, newProgress: Int) -> Unit)?) =
        apply { onProgressChanged = callback }

    /** @see WebViewClient.onReceivedClientCertRequest */
    override fun onReceivedClientCertRequest(callback: ((view: WebView?, request: ClientCertRequest?) -> Unit)?) =
        apply { onReceivedClientCertRequest = callback }

    /** @see WebViewClient.onReceivedError */
    @TargetApi(23)
    override fun onReceivedError(callback: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?) =
        apply { onReceivedError = callback }

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    override fun onReceivedHttpAuthRequest(callback: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?) =
        apply { onReceivedHttpAuthRequest = callback }

    /** @see WebViewClient.onReceivedHttpError */
    @TargetApi(23)
    override fun onReceivedHttpError(callback: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?) =
        apply { onReceivedHttpError = callback }

    /** @see WebChromeClient.onReceivedIcon */
    override fun onReceivedIcon(callback: ((view: WebView?, icon: Bitmap?) -> Unit)?) =
        apply { onReceivedIcon = callback }

    /** @see WebViewClient.onReceivedLoginRequest */
    override fun onReceivedLoginRequest(callback: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?) =
        apply { onReceivedLoginRequest = callback }

    /** @see WebViewClient.onReceivedSslError */
    override fun onReceivedSslError(callback: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?) =
        apply { onReceivedSslError = callback }

    /** @see WebChromeClient.onReceivedTitle */
    override fun onReceivedTitle(callback: ((view: WebView?, title: String?) -> Unit)?) =
        apply { onReceivedTitle = callback }

    /** @see WebChromeClient.onReceivedTouchIconUrl */
    override fun onReceivedTouchIconUrl(callback: ((view: WebView?, url: String?, precomposed: Boolean) -> Unit)?) =
        apply { onReceivedTouchIconUrl = callback }

    /** @see WebViewClient.onRenderProcessGone */
    @TargetApi(26)
    override fun onRenderProcessGone(callback: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?) =
        apply { onRenderProcessGone = callback }

    /** @see WebChromeClient.onRequestFocus */
    override fun onRequestFocus(callback: ((view: WebView?) -> Unit)?) =
        apply { onRequestFocus = callback }

    /** @see WebViewClient.onSafeBrowsingHit */
    @TargetApi(27)
    override fun onSafeBrowsingHit(callback: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?) =
        apply { onSafeBrowsingHit = callback }

    /** @see WebViewClient.onScaleChanged */
    override fun onScaleChanged(callback: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?) =
        apply { onScaleChanged = callback }

    /** @see WebChromeClient.onShowCustomView */
    override fun onShowCustomView(callback: ((view: View?, callback: WebChromeClient.CustomViewCallback?) -> Unit)?) =
        apply { onShowCustomView = callback }

    /** @see WebChromeClient.onShowFileChooser */
    override fun onShowFileChooser(callback: ((webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?) -> Boolean)?) =
        apply { onShowFileChooser = callback }

    /** @see WebSettings.setSafeBrowsingEnabled */
    override fun safeBrowsingEnabled(input: Boolean?) = apply { safeBrowsingEnabled = input }

    /** @see WebSettings.setSansSerifFontFamily */
    override fun sansSerifFontFamily(input: String?) = apply { sansSerifFontFamily = input }

    /** @see WebSettings.setSerifFontFamily */
    override fun serifFontFamily(input: String?) = apply { serifFontFamily = input }

    /** @see WebViewClient.shouldInterceptRequest */
    override fun shouldInterceptRequest(callback: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?) =
        apply { shouldInterceptRequest = callback }

    /** @see WebViewClient.shouldOverrideKeyEvent */
    override fun shouldOverrideKeyEvent(callback: ((view: WebView?, event: KeyEvent?) -> Boolean)?) =
        apply { shouldOverrideKeyEvent = callback }

    /** @see WebViewClient.shouldOverrideUrlLoading */
    override fun shouldOverrideUrlLoading(callback: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?) =
        apply { shouldOverrideUrlLoading = callback }

    /** @see WebSettings.setStandardFontFamily */
    override fun standardFontFamily(input: String?) = apply { standardFontFamily = input }

    /** @see WebSettings.supportMultipleWindows */
    override fun supportMultipleWindows(input: Boolean?) = apply { supportMultipleWindows = input }

    /** @see WebSettings.supportZoom */
    override fun supportZoom(input: Boolean?) = apply { supportZoom = input }

    /** @see WebSettings.setTextZoom */
    override fun textZoom(input: Int?) = apply { textZoom = input }

    /** @see WebSettings.setUserAgentString */
    override fun userAgentString(input: String?) = apply { userAgentString = input }

    /** @see WebSettings.setUseWideViewPort */
    override fun useWideViewPort(input: Boolean?) = apply { useWideViewPort = input }


    /**
     * Reflect builder's settings.
     */
    fun into(target: WebView) = target.apply {
        into(settings)
        webChromeClient = buildChromeClient()
        webViewClient = buildViewClient()
    }


    private fun buildChromeClient() = object : WebChromeClient() {
        override fun getDefaultVideoPoster() = getDefaultVideoPoster?.invoke()
            ?: super.getDefaultVideoPoster()

        override fun getVideoLoadingProgressView() = getVideoLoadingProgressView?.invoke()
            ?: super.getVideoLoadingProgressView()

        override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) =
            getVisitedHistory?.invoke(callback)
                ?: super.getVisitedHistory(callback)

        override fun onCloseWindow(window: WebView?) = onCloseWindow?.invoke(window)
            ?: super.onCloseWindow(window)

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?) =
            onConsoleMessage?.invoke(consoleMessage)
                ?: super.onConsoleMessage(consoleMessage)

        override fun onCreateWindow(
            view: WebView?,
            isDialog: Boolean,
            isUserGesture: Boolean,
            resultMsg: Message?
        ) = onCreateWindow?.invoke(view, isDialog, isUserGesture, resultMsg)
            ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)

        override fun onGeolocationPermissionsHidePrompt() =
            onGeolocationPermissionsHidePrompt?.invoke()
                ?: super.onGeolocationPermissionsHidePrompt()

        override fun onGeolocationPermissionsShowPrompt(
            origin: String?,
            callback: GeolocationPermissions.Callback?
        ) = onGeolocationPermissionsShowPrompt?.invoke(origin, callback)
            ?: super.onGeolocationPermissionsShowPrompt(origin, callback)

        override fun onHideCustomView() = onHideCustomView?.invoke()
            ?: super.onHideCustomView()

        override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?) =
            onJsAlert?.invoke(view, url, message, result)
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

        override fun onPermissionRequest(request: PermissionRequest?) =
            onPermissionRequest?.invoke(request)
                ?: super.onPermissionRequest(request)

        override fun onPermissionRequestCanceled(request: PermissionRequest?) =
            onPermissionRequestCanceled?.invoke(request)
                ?: super.onPermissionRequestCanceled(request)

        override fun onProgressChanged(view: WebView?, newProgress: Int) =
            onProgressChanged?.invoke(view, newProgress)
                ?: super.onProgressChanged(view, newProgress)

        override fun onReceivedIcon(view: WebView?, icon: Bitmap?) =
            onReceivedIcon?.invoke(view, icon)
                ?: super.onReceivedIcon(view, icon)

        override fun onReceivedTitle(view: WebView?, title: String?) =
            onReceivedTitle?.invoke(view, title)
                ?: super.onReceivedTitle(view, title)

        override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) =
            onReceivedTouchIconUrl?.invoke(view, url, precomposed)
                ?: super.onReceivedTouchIconUrl(view, url, precomposed)

        override fun onRequestFocus(view: WebView?) = onRequestFocus?.invoke(view)
            ?: super.onRequestFocus(view)

        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) =
            onShowCustomView?.invoke(view, callback)
                ?: super.onShowCustomView(view, callback)

        override fun onShowFileChooser(
            webView: WebView?,
            filePathCallback: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ) = onShowFileChooser?.invoke(webView, filePathCallback, fileChooserParams)
            ?: super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }

    private fun buildViewClient() = object : WebViewClientCompat() {
        override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) =
            doUpdateVisitedHistory?.invoke(view, url, isReload)
                ?: super.doUpdateVisitedHistory(view, url, isReload)

        override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) =
            onFormResubmission?.invoke(view, dontResend, resend)
                ?: super.onFormResubmission(view, dontResend, resend)

        override fun onLoadResource(view: WebView?, url: String?) =
            onLoadResource?.invoke(view, url)
                ?: super.onLoadResource(view, url)

        override fun onPageCommitVisible(view: WebView, url: String) =
            onPageCommitVisible?.invoke(view, url)
                ?: super.onPageCommitVisible(view, url)

        override fun onPageFinished(view: WebView?, url: String?) =
            onPageFinished?.invoke(view, url)
                ?: super.onPageFinished(view, url)

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) =
            onPageStarted?.invoke(view, url, favicon)
                ?: super.onPageStarted(view, url, favicon)

        override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) =
            onReceivedClientCertRequest?.invoke(view, request)
                ?: super.onReceivedClientCertRequest(view, request)

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceErrorCompat
        ) = onReceivedError?.invoke(view, request, error)
            ?: super.onReceivedError(view, request, error)

        override fun onReceivedHttpAuthRequest(
            view: WebView?,
            handler: HttpAuthHandler?,
            host: String?,
            realm: String?
        ) = onReceivedHttpAuthRequest?.invoke(view, handler, host, realm)
            ?: super.onReceivedHttpAuthRequest(view, handler, host, realm)

        override fun onReceivedHttpError(
            view: WebView,
            request: WebResourceRequest,
            errorResponse: WebResourceResponse
        ) = onReceivedHttpError?.invoke(view, request, errorResponse)
            ?: super.onReceivedHttpError(view, request, errorResponse)

        override fun onReceivedLoginRequest(
            view: WebView?,
            realm: String?,
            account: String?,
            args: String?
        ) = onReceivedLoginRequest?.invoke(view, realm, account, args)
            ?: super.onReceivedLoginRequest(view, realm, account, args)

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) = onReceivedSslError?.invoke(view, handler, error)
            ?: super.onReceivedSslError(view, handler, error)

        override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?) =
            onRenderProcessGone?.invoke(view, detail)
                ?: super.onRenderProcessGone(view, detail)

        override fun onSafeBrowsingHit(
            view: WebView,
            request: WebResourceRequest,
            threatType: Int,
            callback: SafeBrowsingResponseCompat
        ) = onSafeBrowsingHit?.invoke(view, request, threatType, callback)
            ?: super.onSafeBrowsingHit(view, request, threatType, callback)

        override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) =
            onScaleChanged?.invoke(view, oldScale, newScale)
                ?: super.onScaleChanged(view, oldScale, newScale)

        override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?) =
            shouldInterceptRequest?.invoke(view, request)
                ?: super.shouldInterceptRequest(view, request)

        override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?) =
            shouldOverrideKeyEvent?.invoke(view, event)
                ?: super.shouldOverrideKeyEvent(view, event)

        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest) =
            shouldOverrideUrlLoading?.invoke(view, request)
                ?: super.shouldOverrideUrlLoading(view, request)
    }

    private fun into(target: WebSettings) {
        allowContentAccess?.also { target.allowContentAccess = it }
        allowFileAccess?.also { target.allowFileAccess = it }
        allowFileAccessFromFileURLs?.also { target.allowFileAccessFromFileURLs = it }
        allowUniversalAccessFromFileURLs?.also { target.allowUniversalAccessFromFileURLs = it }
        appCacheEnabled?.also { target.setAppCacheEnabled(it) }
        appCachePath?.also { target.setAppCachePath(it) }
        blockNetworkImage?.also { target.blockNetworkImage = it }
        blockNetworkLoads?.also { target.blockNetworkLoads = it }
        builtInZoomControls?.also { target.builtInZoomControls = it }
        cacheMode?.also { target.cacheMode = it }
        cursiveFontFamily?.also { target.cursiveFontFamily = it }
        databaseEnabled?.also { target.databaseEnabled = it }
        defaultFixedFontSize?.also { target.defaultFixedFontSize = it }
        defaultFontSize?.also { target.defaultFontSize = it }
        defaultTextEncodingName?.also { target.defaultTextEncodingName = it }
        disabledActionModeMenuItems?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS)) {
                WebSettingsCompat.setDisabledActionModeMenuItems(target, it)
            }
        }
        displayZoomControls?.also { target.displayZoomControls = it }
        domStorageEnabled?.also { target.domStorageEnabled = it }
        fantasyFontFamily?.also { target.fantasyFontFamily = it }
        fixedFontFamily?.also { target.fixedFontFamily = it }
        forceDark?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(target, it)
            }
        }
        geolocationEnabled?.also { target.setGeolocationEnabled(it) }
        javaScriptCanOpenWindowsAutomatically?.also {
            target.javaScriptCanOpenWindowsAutomatically = it
        }
        javaScriptEnabled?.also { target.javaScriptEnabled = it }
        layoutAlgorithm?.also { target.layoutAlgorithm = it }
        loadsImagesAutomatically?.also { target.loadsImagesAutomatically = it }
        loadWithOverviewMode?.also { target.loadWithOverviewMode = it }
        mediaPlaybackRequiresUserGesture?.also { target.mediaPlaybackRequiresUserGesture = it }
        minimumFontSize?.also { target.minimumFontSize = it }
        minimumLogicalFontSize?.also { target.minimumLogicalFontSize = it }
        mixedContentMode?.also { target.mixedContentMode = it }
        needInitialFocus?.also { target.setNeedInitialFocus(it) }
        offscreenPreRaster?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.OFF_SCREEN_PRERASTER)) {
                WebSettingsCompat.setOffscreenPreRaster(target, it)
            }
        }
        safeBrowsingEnabled?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_ENABLE)) {
                WebSettingsCompat.setSafeBrowsingEnabled(target, it)
            }
        }
        sansSerifFontFamily?.also { target.sansSerifFontFamily = it }
        serifFontFamily?.also { target.serifFontFamily = it }
        standardFontFamily?.also { target.standardFontFamily = it }
        supportMultipleWindows?.also { target.setSupportMultipleWindows(it) }
        supportZoom?.also { target.setSupportZoom(it) }
        textZoom?.also { target.textZoom = it }
        userAgentString?.also { target.userAgentString = it }
        useWideViewPort?.also { target.useWideViewPort = it }
    }
}
