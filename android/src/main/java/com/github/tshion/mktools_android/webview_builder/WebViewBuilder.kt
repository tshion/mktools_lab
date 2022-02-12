package com.github.tshion.mktools_android.webview_builder

import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebSettingsCompat.*
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewFeature
import androidx.webkit.WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE
import androidx.webkit.WebViewRenderProcess
import com.github.tshion.mktools_android.webview_builder.aliases.*
import com.github.tshion.mktools_android.webview_builder.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.annotations.MktMixedContentMode
import com.github.tshion.mktools_android.webview_builder.contracts.WebChromeClientBuilderContract
import com.github.tshion.mktools_android.webview_builder.contracts.WebSettingsBuilderContract
import com.github.tshion.mktools_android.webview_builder.contracts.WebViewClientCompatBuilderContract
import com.github.tshion.mktools_android.webview_builder.contracts.WebViewRenderProcessClientBuilderContract
import com.github.tshion.mktools_android.webview_builder.states.WebChromeClientState
import com.github.tshion.mktools_android.webview_builder.states.WebSettingsState
import com.github.tshion.mktools_android.webview_builder.states.WebViewClientCompatState
import com.github.tshion.mktools_android.webview_builder.states.WebViewRenderProcessClientState
import java.util.concurrent.Executor

/**
 * Builder for WebView.
 */
class WebViewBuilder : WebChromeClientBuilderContract,
    WebSettingsBuilderContract,
    WebViewClientCompatBuilderContract,
    WebViewRenderProcessClientBuilderContract {

    private var _stateWebChromeClient: WebChromeClientState? = null
    private val stateWebChromeClient: WebChromeClientState
        get() {
            // FIXME: スレッド防御
            if (_stateWebChromeClient == null) {
                _stateWebChromeClient = WebChromeClientState()
            }
            return _stateWebChromeClient!!
        }

    private var _stateWebSettings: WebSettingsState? = null
    private val stateWebSettings: WebSettingsState
        get() {
            // FIXME: スレッド防御
            if (_stateWebSettings == null) {
                _stateWebSettings = WebSettingsState()
            }
            return _stateWebSettings!!
        }

    private var _stateWebViewClientCompat: WebViewClientCompatState? = null
    private val stateWebViewClientCompat: WebViewClientCompatState
        get() {
            // FIXME: スレッド防御
            if (_stateWebViewClientCompat == null) {
                _stateWebViewClientCompat = WebViewClientCompatState()
            }
            return _stateWebViewClientCompat!!
        }

    private var _stateWebViewRenderProcessClient: WebViewRenderProcessClientState? = null
    private val stateWebViewRenderProcessClient: WebViewRenderProcessClientState
        get() {
            // FIXME: スレッド防御
            if (_stateWebViewRenderProcessClient == null) {
                _stateWebViewRenderProcessClient = WebViewRenderProcessClientState()
            }
            return _stateWebViewRenderProcessClient!!
        }


    // Start overrides [WebChromeClientBuilderContract].

    override fun getDefaultVideoPoster(
        fx: MktSupplier<Bitmap?>
    ) = apply { stateWebChromeClient.getDefaultVideoPoster = fx }

    override fun getVideoLoadingProgressView(
        fx: MktSupplier<View?>
    ) = apply { stateWebChromeClient.getVideoLoadingProgressView = fx }

    override fun getVisitedHistory(
        fx: MktConsumer<ValueCallback<Array<String>>>
    ) = apply { stateWebChromeClient.getVisitedHistory = fx }

    override fun onCloseWindow(
        fx: MktConsumer<WebView>
    ) = apply { stateWebChromeClient.onCloseWindow = fx }

    override fun onConsoleMessageUntil15(
        fx: MktTriConsumer<String, Int, String>
    ) = this

    override fun onConsoleMessage(
        fx: MktPredicate<ConsoleMessage>
    ) = apply { stateWebChromeClient.onConsoleMessage = fx }

    override fun onCreateWindow(
        fx: MktOnCreateWindowPredicate
    ) = apply { stateWebChromeClient.onCreateWindow = fx }

    override fun onExceededDatabaseQuota(
        fx: MktOnExceededDatabaseQuotaConsumer
    ) = this

    override fun onGeolocationPermissionsHidePrompt(
        fx: MktRunnable
    ) = apply { stateWebChromeClient.onGeolocationPermissionsHidePrompt = fx }

    override fun onGeolocationPermissionsShowPrompt(
        fx: MktBiConsumer<String, GeolocationPermissions.Callback>
    ) = apply { stateWebChromeClient.onGeolocationPermissionsShowPrompt = fx }

    override fun onHideCustomView(
        fx: MktRunnable
    ) = apply { stateWebChromeClient.onHideCustomView = fx }

    override fun onJsAlert(
        fx: MktOnJsPredicate
    ) = apply { stateWebChromeClient.onJsAlert = fx }

    override fun onJsBeforeUnload(
        fx: MktOnJsPredicate
    ) = apply { stateWebChromeClient.onJsBeforeUnload = fx }

    override fun onJsConfirm(
        fx: MktOnJsPredicate
    ) = apply { stateWebChromeClient.onJsConfirm = fx }

    override fun onJsPrompt(
        fx: MktOnJsPromptPredicate
    ) = apply { stateWebChromeClient.onJsPrompt = fx }

    override fun onJsTimeout(
        fx: MktBooleanSupplier
    ) = this

    override fun onPermissionRequest(
        fx: MktConsumer<PermissionRequest>
    ) = apply { stateWebChromeClient.onPermissionRequest = fx }

    override fun onPermissionRequestCanceled(
        fx: MktConsumer<PermissionRequest>
    ) = apply { stateWebChromeClient.onPermissionRequestCanceled = fx }

    override fun onProgressChanged(
        fx: MktObjIntConsumer<WebView>
    ) = apply { stateWebChromeClient.onProgressChanged = fx }

    override fun onReceivedIcon(
        fx: MktBiConsumer<WebView, Bitmap>
    ) = apply { stateWebChromeClient.onReceivedIcon = fx }

    override fun onReceivedTitle(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebChromeClient.onReceivedTitle = fx }

    override fun onReceivedTouchIconUrl(
        fx: MktBiObjBooleanConsumer<WebView, String>
    ) = apply { stateWebChromeClient.onReceivedTouchIconUrl = fx }

    override fun onRequestFocus(
        fx: MktConsumer<WebView>
    ) = apply { stateWebChromeClient.onRequestFocus = fx }

    override fun onShowCustomViewUntil18(
        fx: MktTriConsumer<View, Int, WebChromeClient.CustomViewCallback>
    ) = this

    override fun onShowCustomView(
        fx: MktBiConsumer<View, WebChromeClient.CustomViewCallback>
    ) = apply { stateWebChromeClient.onShowCustomView = fx }

    override fun onShowFileChooser(
        fx: MktTriPredicate<WebView, ValueCallback<Array<Uri>>, WebChromeClient.FileChooserParams>
    ) = apply { stateWebChromeClient.onShowFileChooser = fx }

    // End overrides [WebChromeClientBuilderContract].


    // Start overrides [WebSettingsBuilderContract].

    override fun allowContentAccess(
        allow: Boolean
    ) = apply { stateWebSettings.allowContentAccess = allow }

    override fun allowFileAccess(
        allow: Boolean
    ) = apply { stateWebSettings.allowFileAccess = allow }

    override fun allowFileAccessFromFileURLs(
        flag: Boolean
    ) = apply { stateWebSettings.allowFileAccessFromFileURLs = flag }

    override fun allowUniversalAccessFromFileURLs(
        flag: Boolean
    ) = apply { stateWebSettings.allowUniversalAccessFromFileURLs = flag }

    override fun blockNetworkImage(
        flag: Boolean
    ) = apply { stateWebSettings.blockNetworkImage = flag }

    override fun blockNetworkLoads(
        flag: Boolean
    ) = apply { stateWebSettings.blockNetworkLoads = flag }

    override fun builtInZoomControls(
        enabled: Boolean
    ) = apply { stateWebSettings.builtInZoomControls = enabled }

    override fun cacheMode(
        @MktCacheMode mode: Int
    ) = apply { stateWebSettings.cacheMode = mode }

    override fun cursiveFontFamily(
        font: String
    ) = apply { stateWebSettings.cursiveFontFamily = font }

    override fun databaseEnabled(
        flag: Boolean
    ) = apply { stateWebSettings.databaseEnabled = flag }

    override fun databasePath(
        databasePath: String
    ) = this

    override fun defaultFixedFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { stateWebSettings.defaultFixedFontSize = size }

    override fun defaultFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { stateWebSettings.defaultFontSize = size }

    override fun defaultTextEncodingName(
        encoding: String
    ) = apply { stateWebSettings.defaultTextEncodingName = encoding }

    override fun defaultZoom(
        zoom: WebSettings.ZoomDensity?
    ) = this

    override fun disabledActionModeMenuItems(
        @MenuItemFlags menuItems: Int
    ) = apply { stateWebSettings.disabledActionModeMenuItems = menuItems }

    override fun displayZoomControls(
        enabled: Boolean
    ) = apply { stateWebSettings.displayZoomControls = enabled }

    override fun domStorageEnabled(
        flag: Boolean
    ) = apply { stateWebSettings.domStorageEnabled = flag }

    override fun enableSmoothTransition(
        enable: Boolean
    ) = this

    override fun fantasyFontFamily(
        font: String
    ) = apply { stateWebSettings.fantasyFontFamily = font }

    override fun fixedFontFamily(
        font: String
    ) = apply { stateWebSettings.fixedFontFamily = font }

    override fun forceDark(
        @ForceDark forceDarkMode: Int
    ) = apply { stateWebSettings.forceDark = forceDarkMode }

    override fun forceDarkStrategy(
        @ForceDarkStrategy forceDarkBehavior: Int
    ) = apply { stateWebSettings.forceDarkStrategy = forceDarkBehavior }

    override fun geolocationDatabasePath(
        databasePath: String
    ) = apply { stateWebSettings.geolocationDatabasePath = databasePath }

    override fun geolocationEnabled(
        flag: Boolean
    ) = apply { stateWebSettings.geolocationEnabled = flag }

    override fun javaScriptCanOpenWindowsAutomatically(
        flag: Boolean
    ) = apply { stateWebSettings.javaScriptCanOpenWindowsAutomatically = flag }

    override fun javaScriptEnabled(
        flag: Boolean
    ) = apply { stateWebSettings.javaScriptEnabled = flag }

    override fun layoutAlgorithm(
        l: LayoutAlgorithm
    ) = apply { stateWebSettings.layoutAlgorithm = l }

    override fun lightTouchEnabled(
        enabled: Boolean
    ) = this

    override fun loadsImagesAutomatically(
        flag: Boolean
    ) = apply { stateWebSettings.loadsImagesAutomatically = flag }

    override fun loadWithOverviewMode(
        overview: Boolean
    ) = apply { stateWebSettings.loadWithOverviewMode = overview }

    override fun mediaPlaybackRequiresUserGesture(
        require: Boolean
    ) = apply { stateWebSettings.mediaPlaybackRequiresUserGesture = require }

    override fun minimumFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { stateWebSettings.minimumFontSize = size }

    override fun minimumLogicalFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { stateWebSettings.minimumLogicalFontSize = size }

    override fun mixedContentMode(
        @MktMixedContentMode mode: Int
    ) = apply { stateWebSettings.mixedContentMode = mode }

    override fun needInitialFocus(
        flag: Boolean
    ) = apply { stateWebSettings.needInitialFocus = flag }

    override fun offscreenPreRaster(
        enabled: Boolean
    ) = apply { stateWebSettings.offscreenPreRaster = enabled }

    override fun pluginState(
        state: PluginState
    ) = this

    override fun renderPriority(
        priority: RenderPriority
    ) = this

    override fun safeBrowsingEnabled(
        enabled: Boolean
    ) = apply { stateWebSettings.safeBrowsingEnabled = enabled }

    override fun sansSerifFontFamily(
        font: String
    ) = apply { stateWebSettings.sansSerifFontFamily = font }

    override fun saveFormData(
        save: Boolean
    ) = apply { stateWebSettings.saveFormData = save }

    override fun savePassword(
        save: Boolean
    ) = this

    override fun serifFontFamily(
        font: String
    ) = apply { stateWebSettings.serifFontFamily = font }

    override fun standardFontFamily(
        font: String
    ) = apply { stateWebSettings.standardFontFamily = font }

    override fun supportMultipleWindows(
        support: Boolean
    ) = apply { stateWebSettings.supportMultipleWindows = support }

    override fun supportZoom(
        support: Boolean
    ) = apply { stateWebSettings.supportZoom = support }

    override fun textSize(
        t: TextSize
    ) = this

    override fun textZoom(
        textZoom: Int
    ) = apply { stateWebSettings.textZoom = textZoom }

    override fun userAgentString(
        ua: String?
    ) = apply { stateWebSettings.userAgentString = ua }

    override fun useWideViewPort(
        use: Boolean
    ) = apply { stateWebSettings.useWideViewPort = use }

    // End overrides [WebSettingsBuilderContract].


    // Start overrides [WebViewClientCompatBuilderContract].

    override fun doUpdateVisitedHistory(
        fx: MktBiObjBooleanConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.doUpdateVisitedHistory = fx }

    override fun onFormResubmission(
        fx: MktTriConsumer<WebView, Message, Message>
    ) = apply { stateWebViewClientCompat.onFormResubmission = fx }

    override fun onLoadResource(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onLoadResource = fx }

    override fun onPageCommitVisible(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onPageCommitVisible = fx }

    override fun onPageFinished(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onPageFinished = fx }

    override fun onPageStarted(
        fx: MktTriConsumer<WebView, String, Bitmap>
    ) = apply { stateWebViewClientCompat.onPageStarted = fx }

    override fun onReceivedClientCertRequest(
        fx: MktBiConsumer<WebView, ClientCertRequest>
    ) = apply { stateWebViewClientCompat.onReceivedClientCertRequest = fx }

    override fun onReceivedError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>
    ) = apply { stateWebViewClientCompat.onReceivedError = fx }

    override fun onReceivedHttpAuthRequest(
        fx: MktOnReceivedHttpAuthRequestConsumer
    ) = apply { stateWebViewClientCompat.onReceivedHttpAuthRequest = fx }

    override fun onReceivedHttpError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>
    ) = apply { stateWebViewClientCompat.onReceivedHttpError = fx }

    override fun onReceivedLoginRequest(
        fx: MktOnReceivedLoginRequestConsumer
    ) = apply { stateWebViewClientCompat.onReceivedLoginRequest = fx }

    override fun onReceivedSslError(
        fx: MktTriConsumer<WebView, SslErrorHandler, SslError>
    ) = apply { stateWebViewClientCompat.onReceivedSslError = fx }

    override fun onRenderProcessGone(
        fx: MktBiPredicate<WebView, RenderProcessGoneDetail>
    ) = apply { stateWebViewClientCompat.onRenderProcessGone = fx }

    override fun onSafeBrowsingHit(
        fx: MktOnSafeBrowsingHitConsumer
    ) = apply { stateWebViewClientCompat.onSafeBrowsingHit = fx }

    override fun onScaleChanged(
        fx: MktObjBiFloatConsumer<WebView>
    ) = apply { stateWebViewClientCompat.onScaleChanged = fx }

    override fun onTooManyRedirects(
        fx: MktTriConsumer<WebView, Message, Message>
    ) = this

    override fun onUnhandledKeyEvent(
        fx: MktBiConsumer<WebView, KeyEvent>
    ) = this

    override fun shouldInterceptRequestUntil21(
        fx: MktBiFunction<WebView, String, WebResourceResponse?>
    ) = this

    override fun shouldInterceptRequest(
        fx: MktBiFunction<WebView, WebResourceRequest, WebResourceResponse?>
    ) = apply { stateWebViewClientCompat.shouldInterceptRequest = fx }

    override fun shouldOverrideKeyEvent(
        fx: MktBiPredicate<WebView, KeyEvent>
    ) = apply { stateWebViewClientCompat.shouldOverrideKeyEvent = fx }

    override fun shouldOverrideUrlLoading(
        fx: MktBiPredicate<WebView, WebResourceRequest>
    ) = apply { stateWebViewClientCompat.shouldOverrideUrlLoading = fx }

    // End overrides [WebViewClientCompatBuilderContract].


    // Start overrides [WebViewRenderProcessClientBuilderContract].

    override fun onRenderProcessResponsive(
        fx: MktBiConsumer<WebView, WebViewRenderProcess?>
    ) = apply { stateWebViewRenderProcessClient.onRenderProcessResponsive = fx }

    override fun onRenderProcessUnresponsive(
        fx: MktBiConsumer<WebView, WebViewRenderProcess?>
    ) = apply { stateWebViewRenderProcessClient.onRenderProcessUnresponsive = fx }

    // End overrides [WebViewRenderProcessClientBuilderContract].


    /**
     * Reflects builder's settings.
     */
    fun into(
        target: WebView,
        executor: Executor? = null,
    ) {
        _stateWebChromeClient?.also {
            target.webChromeClient = it.create()
        }
        _stateWebSettings?.also {
            it.into(target.settings)
        }
        _stateWebViewClientCompat?.also {
            target.webViewClient = it.create()
        }
        _stateWebViewRenderProcessClient?.also {
            if (!WebViewFeature.isFeatureSupported(WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE)) return@also
            if (executor != null) {
                WebViewCompat.setWebViewRenderProcessClient(target, executor, it.create())
            } else {
                WebViewCompat.setWebViewRenderProcessClient(target, it.create())
            }
        }
    }
}
