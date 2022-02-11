package com.github.tshion.mktools_android.webview_builder.candidate

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebSettingsCompat.*
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMixedContentMode
import com.github.tshion.mktools_android.webview_builder.candidate.contracts.WebSettingsBuilderContract
import com.github.tshion.mktools_android.webview_builder.candidate.contracts.WebViewClientCompatBuilderContract
import com.github.tshion.mktools_android.webview_builder.candidate.states.WebSettingsState
import com.github.tshion.mktools_android.webview_builder.candidate.states.WebViewClientCompatState

/**
 * Builder for WebView.
 */
class WebViewBuilder : WebSettingsBuilderContract,
    WebViewClientCompatBuilderContract {

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

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
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
}
