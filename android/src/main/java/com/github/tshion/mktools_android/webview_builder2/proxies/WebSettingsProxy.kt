package com.github.tshion.mktools_android.webview_builder2.proxies

import android.os.Build
import android.webkit.WebSettings
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.webkit.WebSettingsCompat.*
import androidx.webkit.WebViewFeature.*
import com.github.tshion.mktools_android.webview_builder.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.annotations.MktMixedContentMode
import com.github.tshion.mktools_android.webview_builder2.contracts.WebSettingsBuilderContract

/**
 * Proxy of [WebSettings] and [androidx.webkit.WebSettingsCompat].
 */
internal class WebSettingsProxy : WebSettingsBuilderContract {

    private var allowContentAccess: Boolean? = null

    private var allowFileAccess: Boolean? = null

    @Deprecated("Deprecated in API level 30")
    private var allowFileAccessFromFileURLs: Boolean? = null

    @Deprecated("Deprecated in API level 30")
    private var allowUniversalAccessFromFileURLs: Boolean? = null

    private var blockNetworkImage: Boolean? = null

    private var blockNetworkLoads: Boolean? = null

    private var builtInZoomControls: Boolean? = null

    @MktCacheMode
    private var cacheMode: Int? = null

    private var cursiveFontFamily: String? = null

    private var databaseEnabled: Boolean? = null

    @IntRange(from = 1, to = 72)
    private var defaultFixedFontSize: Int? = null

    @IntRange(from = 1, to = 72)
    private var defaultFontSize: Int? = null

    private var defaultTextEncodingName: String? = null

    @get:MenuItemFlags
    private var disabledActionModeMenuItems: Int? = null

    private var displayZoomControls: Boolean? = null

    private var domStorageEnabled: Boolean? = null

    private var fantasyFontFamily: String? = null

    private var fixedFontFamily: String? = null

    @get:ForceDark
    private var forceDark: Int? = null

    @get:ForceDarkStrategy
    private var forceDarkStrategy: Int? = null

    @Deprecated("Deprecated in API level 24")
    private var geolocationDatabasePath: String? = null

    private var geolocationEnabled: Boolean? = null

    private var javaScriptCanOpenWindowsAutomatically: Boolean? = null

    private var javaScriptEnabled: Boolean? = null

    private var layoutAlgorithm: WebSettings.LayoutAlgorithm? = null

    private var loadsImagesAutomatically: Boolean? = null

    private var loadWithOverviewMode: Boolean? = null

    private var mediaPlaybackRequiresUserGesture: Boolean? = null

    @IntRange(from = 1, to = 72)
    private var minimumFontSize: Int? = null

    @IntRange(from = 1, to = 72)
    private var minimumLogicalFontSize: Int? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private var mixedContentMode: Int? = null

    private var needInitialFocus: Boolean? = null

    private var offscreenPreRaster: Boolean? = null

    private var safeBrowsingEnabled: Boolean? = null

    private var sansSerifFontFamily: String? = null

    @Deprecated("Deprecated in API level 26")
    private var saveFormData: Boolean? = null

    private var serifFontFamily: String? = null

    private var standardFontFamily: String? = null

    private var supportMultipleWindows: Boolean? = null

    private var supportZoom: Boolean? = null

    private var textZoom: Int? = null

    private var _hasUserAgentString: Boolean = false
    private var userAgentString: String? = null
        set(value) {
            _hasUserAgentString = true
            field = value
        }

    private var useWideViewPort: Boolean? = null


    override fun allowContentAccess(
        allow: Boolean
    ) = apply { allowContentAccess = allow }

    override fun allowFileAccess(
        allow: Boolean
    ) = apply { allowFileAccess = allow }

    override fun allowFileAccessFromFileURLs(
        flag: Boolean
    ) = apply { allowFileAccessFromFileURLs = flag }

    override fun allowUniversalAccessFromFileURLs(
        flag: Boolean
    ) = apply { allowUniversalAccessFromFileURLs = flag }

    override fun blockNetworkImage(
        flag: Boolean
    ) = apply { blockNetworkImage = flag }

    override fun blockNetworkLoads(
        flag: Boolean
    ) = apply { blockNetworkLoads = flag }

    override fun builtInZoomControls(
        enabled: Boolean
    ) = apply { builtInZoomControls = enabled }

    override fun cacheMode(
        @MktCacheMode mode: Int
    ) = apply { cacheMode = mode }

    override fun cursiveFontFamily(
        font: String
    ) = apply { cursiveFontFamily = font }

    override fun databaseEnabled(
        flag: Boolean
    ) = apply { databaseEnabled = flag }

    override fun databasePath(
        databasePath: String
    ) = this

    override fun defaultFixedFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { defaultFixedFontSize = size }

    override fun defaultFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { defaultFontSize = size }

    override fun defaultTextEncodingName(
        encoding: String
    ) = apply { defaultTextEncodingName = encoding }

    override fun defaultZoom(
        zoom: WebSettings.ZoomDensity?
    ) = this

    override fun disabledActionModeMenuItems(
        @MenuItemFlags menuItems: Int
    ) = apply { disabledActionModeMenuItems = menuItems }

    override fun displayZoomControls(
        enabled: Boolean
    ) = apply { displayZoomControls = enabled }

    override fun domStorageEnabled(
        flag: Boolean
    ) = apply { domStorageEnabled = flag }

    override fun enableSmoothTransition(
        enable: Boolean
    ) = this

    override fun fantasyFontFamily(
        font: String
    ) = apply { fantasyFontFamily = font }

    override fun fixedFontFamily(
        font: String
    ) = apply { fixedFontFamily = font }

    override fun forceDark(
        @ForceDark forceDarkMode: Int
    ) = apply { forceDark = forceDarkMode }

    override fun forceDarkStrategy(
        @ForceDarkStrategy forceDarkBehavior: Int
    ) = apply { forceDarkStrategy = forceDarkBehavior }

    override fun geolocationDatabasePath(
        databasePath: String
    ) = apply { geolocationDatabasePath = databasePath }

    override fun geolocationEnabled(
        flag: Boolean
    ) = apply { geolocationEnabled = flag }

    override fun javaScriptCanOpenWindowsAutomatically(
        flag: Boolean
    ) = apply { javaScriptCanOpenWindowsAutomatically = flag }

    override fun javaScriptEnabled(
        flag: Boolean
    ) = apply { javaScriptEnabled = flag }

    override fun layoutAlgorithm(
        l: WebSettings.LayoutAlgorithm
    ) = apply { layoutAlgorithm = l }

    override fun lightTouchEnabled(
        enabled: Boolean
    ) = this

    override fun loadsImagesAutomatically(
        flag: Boolean
    ) = apply { loadsImagesAutomatically = flag }

    override fun loadWithOverviewMode(
        overview: Boolean
    ) = apply { loadWithOverviewMode = overview }

    override fun mediaPlaybackRequiresUserGesture(
        require: Boolean
    ) = apply { mediaPlaybackRequiresUserGesture = require }

    override fun minimumFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { minimumFontSize = size }

    override fun minimumLogicalFontSize(
        @IntRange(from = 1, to = 72) size: Int
    ) = apply { minimumLogicalFontSize = size }

    override fun mixedContentMode(
        @MktMixedContentMode mode: Int
    ) = apply { mixedContentMode = mode }

    override fun needInitialFocus(
        flag: Boolean
    ) = apply { needInitialFocus = flag }

    override fun offscreenPreRaster(
        enabled: Boolean
    ) = apply { offscreenPreRaster = enabled }

    override fun pluginState(
        state: WebSettings.PluginState
    ) = this

    override fun renderPriority(
        priority: WebSettings.RenderPriority
    ) = this

    override fun safeBrowsingEnabled(
        enabled: Boolean
    ) = apply { safeBrowsingEnabled = enabled }

    override fun sansSerifFontFamily(
        font: String
    ) = apply { sansSerifFontFamily = font }

    override fun saveFormData(
        save: Boolean
    ) = apply { saveFormData = save }

    override fun savePassword(
        save: Boolean
    ) = this

    override fun serifFontFamily(
        font: String
    ) = apply { serifFontFamily = font }

    override fun standardFontFamily(
        font: String
    ) = apply { standardFontFamily = font }

    override fun supportMultipleWindows(
        support: Boolean
    ) = apply { supportMultipleWindows = support }

    override fun supportZoom(
        support: Boolean
    ) = apply { supportZoom = support }

    override fun textSize(
        t: WebSettings.TextSize
    ) = this

    override fun textZoom(
        textZoom: Int
    ) = apply { this.textZoom = textZoom }

    override fun userAgentString(
        ua: String?
    ) = apply { userAgentString = ua }

    override fun useWideViewPort(
        use: Boolean
    ) = apply { useWideViewPort = use }


    /**
     * Apply settings to [WebSettings] instance.
     */
    override fun applyWebSettingsBuilder(ws: WebSettings) {
        allowContentAccess?.also { ws.allowContentAccess = it }
        allowFileAccess?.also { ws.allowFileAccess = it }
        allowFileAccessFromFileURLs?.also {
            if (Build.VERSION_CODES.R <= Build.VERSION.SDK_INT) return@also
            ws.allowFileAccessFromFileURLs = it
        }
        allowUniversalAccessFromFileURLs?.also {
            if (Build.VERSION_CODES.R <= Build.VERSION.SDK_INT) return@also
            ws.allowUniversalAccessFromFileURLs = it
        }
        blockNetworkImage?.also { ws.blockNetworkImage = it }
        blockNetworkLoads?.also { ws.blockNetworkLoads = it }
        builtInZoomControls?.also { ws.builtInZoomControls = it }
        cacheMode?.also { ws.cacheMode = it }
        cursiveFontFamily?.also { ws.cursiveFontFamily = it }
        databaseEnabled?.also { ws.databaseEnabled = it }
        defaultFixedFontSize?.also { ws.defaultFixedFontSize = it }
        defaultFontSize?.also { ws.defaultFontSize = it }
        defaultTextEncodingName?.also { ws.defaultTextEncodingName = it }
        disabledActionModeMenuItems?.also {
            if (!isFeatureSupported(DISABLED_ACTION_MODE_MENU_ITEMS)) return@also
            setDisabledActionModeMenuItems(ws, it)
        }
        displayZoomControls?.also { ws.displayZoomControls = it }
        domStorageEnabled?.also { ws.domStorageEnabled = it }
        fantasyFontFamily?.also { ws.fantasyFontFamily = it }
        fixedFontFamily?.also { ws.fixedFontFamily = it }
        forceDark?.also {
            if (!isFeatureSupported(FORCE_DARK)) return@also
            setForceDark(ws, it)
        }
        forceDarkStrategy?.also {
            if (!isFeatureSupported(FORCE_DARK_STRATEGY)) return@also
            setForceDarkStrategy(ws, it)
        }
        geolocationDatabasePath?.also {
            if (Build.VERSION_CODES.N <= Build.VERSION.SDK_INT) return@also
            ws.setGeolocationDatabasePath(it)
        }
        geolocationEnabled?.also { ws.setGeolocationEnabled(it) }
        javaScriptCanOpenWindowsAutomatically?.also {
            ws.javaScriptCanOpenWindowsAutomatically = it
        }
        javaScriptEnabled?.also { ws.javaScriptEnabled = it }
        layoutAlgorithm?.also { ws.layoutAlgorithm = it }
        loadsImagesAutomatically?.also { ws.loadsImagesAutomatically = it }
        loadWithOverviewMode?.also { ws.loadWithOverviewMode = it }
        mediaPlaybackRequiresUserGesture?.also { ws.mediaPlaybackRequiresUserGesture = it }
        minimumFontSize?.also { ws.minimumFontSize = it }
        minimumLogicalFontSize?.also { ws.minimumLogicalFontSize = it }
        mixedContentMode?.also { ws.mixedContentMode = it }
        needInitialFocus?.also { ws.setNeedInitialFocus(it) }
        offscreenPreRaster?.also {
            if (!isFeatureSupported(OFF_SCREEN_PRERASTER)) return@also
            setOffscreenPreRaster(ws, it)
        }
        safeBrowsingEnabled?.also {
            if (!isFeatureSupported(SAFE_BROWSING_ENABLE)) return@also
            setSafeBrowsingEnabled(ws, it)
        }
        sansSerifFontFamily?.also { ws.sansSerifFontFamily = it }
        saveFormData?.also {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) return@also
            ws.saveFormData = it
        }
        serifFontFamily?.also { ws.serifFontFamily = it }
        standardFontFamily?.also { ws.standardFontFamily = it }
        supportMultipleWindows?.also { ws.setSupportMultipleWindows(it) }
        supportZoom?.also { ws.setSupportZoom(it) }
        textZoom?.also { ws.textZoom = it }
        if (_hasUserAgentString) {
            ws.userAgentString = userAgentString
        }
        useWideViewPort?.also { ws.useWideViewPort = it }
    }
}
