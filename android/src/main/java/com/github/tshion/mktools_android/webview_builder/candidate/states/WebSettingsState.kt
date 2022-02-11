package com.github.tshion.mktools_android.webview_builder.candidate.states

import android.os.Build
import android.webkit.WebSettings
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.webkit.WebSettingsCompat.*
import androidx.webkit.WebViewFeature.*
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode

/**
 * State of [WebSettings] and [androidx.webkit.WebSettingsCompat].
 */
internal class WebSettingsState {
    var allowContentAccess: Boolean? = null

    var allowFileAccess: Boolean? = null

    @Deprecated("Deprecated in API level 30")
    var allowFileAccessFromFileURLs: Boolean? = null

    @Deprecated("Deprecated in API level 30")
    var allowUniversalAccessFromFileURLs: Boolean? = null

    var blockNetworkImage: Boolean? = null

    var blockNetworkLoads: Boolean? = null

    var builtInZoomControls: Boolean? = null

    @MktCacheMode
    var cacheMode: Int? = null

    var cursiveFontFamily: String? = null

    var databaseEnabled: Boolean? = null

    @IntRange(from = 1, to = 72)
    var defaultFixedFontSize: Int? = null

    @IntRange(from = 1, to = 72)
    var defaultFontSize: Int? = null

    var defaultTextEncodingName: String? = null

    @get:MenuItemFlags
    var disabledActionModeMenuItems: Int? = null

    var displayZoomControls: Boolean? = null

    var domStorageEnabled: Boolean? = null

    var fantasyFontFamily: String? = null

    var fixedFontFamily: String? = null

    @get:ForceDark
    var forceDark: Int? = null

    @get:ForceDarkStrategy
    var forceDarkStrategy: Int? = null

    @Deprecated("Deprecated in API level 24")
    var geolocationDatabasePath: String? = null

    var geolocationEnabled: Boolean? = null

    var javaScriptCanOpenWindowsAutomatically: Boolean? = null

    var javaScriptEnabled: Boolean? = null

    var layoutAlgorithm: WebSettings.LayoutAlgorithm? = null

    var loadsImagesAutomatically: Boolean? = null

    var loadWithOverviewMode: Boolean? = null

    var mediaPlaybackRequiresUserGesture: Boolean? = null

    @IntRange(from = 1, to = 72)
    var minimumFontSize: Int? = null

    @IntRange(from = 1, to = 72)
    var minimumLogicalFontSize: Int? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var mixedContentMode: Int? = null

    var needInitialFocus: Boolean? = null

    var offscreenPreRaster: Boolean? = null

    var safeBrowsingEnabled: Boolean? = null

    var sansSerifFontFamily: String? = null

    @Deprecated("Deprecated in API level 26")
    var saveFormData: Boolean? = null

    var serifFontFamily: String? = null

    var standardFontFamily: String? = null

    var supportMultipleWindows: Boolean? = null

    var supportZoom: Boolean? = null

    var textZoom: Int? = null

    private var _hasUserAgentString: Boolean = false
    var userAgentString: String? = null
        set(value) {
            _hasUserAgentString = true
            field = value
        }

    var useWideViewPort: Boolean? = null


    /**
     * Apply settings to [WebSettings] instance.
     */
    fun into(ws: WebSettings) {
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
