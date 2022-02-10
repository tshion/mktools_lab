package com.github.tshion.mktools_android.webview_builder.candidate.entities

import android.webkit.WebSettings
import android.webkit.WebSettings.LayoutAlgorithm
import android.webkit.WebSettings.RenderPriority
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature

/**
 * State of [WebSettings].
 */
internal data class WebSettingsEntity(
    var allowContentAccess: Boolean? = null,
    var allowFileAccess: Boolean? = null,
    var allowFileAccessFromFileURLs: Boolean? = null,
    var allowUniversalAccessFromFileURLs: Boolean? = null,
    var appCacheEnabled: Boolean? = null,
//    var appCacheMaxSize: Long? = null,
    var appCachePath: String? = null,
    var blockNetworkImage: Boolean? = null,
    var blockNetworkLoads: Boolean? = null,
    var builtInZoomControls: Boolean? = null,
    var cacheMode: Int? = null,
    var cursiveFontFamily: String? = null,
    var databaseEnabled: Boolean? = null,
//    var databasePath: String? = null,
    var defaultFixedFontSize: Int? = null,
    var defaultFontSize: Int? = null,
    var defaultTextEncodingName: String? = null,
//    var defaultZoom: ZoomDensity? = null,
    var disabledActionModeMenuItems: Int? = null,
    var displayZoomControls: Boolean? = null,
    var domStorageEnabled: Boolean? = null,
//    var enableSmoothTransition: Boolean? = null,
    var fantasyFontFamily: String? = null,
    var fixedFontFamily: String? = null,
    var forceDark: Int? = null,
    var geolocationDatabasePath: String? = null,
    var geolocationEnabled: Boolean? = null,
    var javaScriptCanOpenWindowsAutomatically: Boolean? = null,
    var javaScriptEnabled: Boolean? = null,
    var layoutAlgorithm: LayoutAlgorithm? = null,
//    var lightTouchEnabled: Boolean? = null,
    var loadsImagesAutomatically: Boolean? = null,
    var loadWithOverviewMode: Boolean? = null,
    var mediaPlaybackRequiresUserGesture: Boolean? = null,
    var minimumFontSize: Int? = null,
    var minimumLogicalFontSize: Int? = null,
    var mixedContentMode: Int? = null,
    var needInitialFocus: Boolean? = null,
    var offscreenPreRaster: Boolean? = null,
//    var pluginState: PluginState? = null,
    var renderPriority: RenderPriority? = null,
    var safeBrowsingEnabled: Boolean? = null,
    var sansSerifFontFamily: String? = null,
    var saveFormData: Boolean? = null,
//    var savePassword: Boolean? = null,
    var serifFontFamily: String? = null,
    var standardFontFamily: String? = null,
    var supportMultipleWindows: Boolean? = null,
    var supportZoom: Boolean? = null,
//    var textSize: TextSize? = null,
    var textZoom: Int? = null,
    var userAgentString: String? = null,
    var useWideViewPort: Boolean? = null,
) {

    /**
     * Apply settings to [WebSettings] instance.
     */
    fun into(target: WebSettings) {
        allowContentAccess?.also { target.allowContentAccess = it }
        allowFileAccess?.also { target.allowFileAccess = it }
        allowFileAccessFromFileURLs?.also { target.allowFileAccessFromFileURLs = it }
        allowUniversalAccessFromFileURLs?.also {
            target.allowUniversalAccessFromFileURLs = it
        }
        appCacheEnabled?.also { target.setAppCacheEnabled(it) }
//        appCacheMaxSize?.also { target.setAppCacheMaxSize(it) }
        appCachePath?.also { target.setAppCachePath(it) }
        blockNetworkImage?.also { target.blockNetworkImage = it }
        blockNetworkLoads?.also { target.blockNetworkLoads = it }
        builtInZoomControls?.also { target.builtInZoomControls = it }
        cacheMode?.also { target.cacheMode = it }
        cursiveFontFamily?.also { target.cursiveFontFamily = it }
        databaseEnabled?.also { target.databaseEnabled = it }
//        databasePath?.also { target.databasePath = it }
        defaultFixedFontSize?.also { target.defaultFixedFontSize = it }
        defaultFontSize?.also { target.defaultFontSize = it }
        defaultTextEncodingName?.also { target.defaultTextEncodingName = it }
//        defaultZoom?.also { target.defaultZoom = it }
        disabledActionModeMenuItems?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS)) {
                WebSettingsCompat.setDisabledActionModeMenuItems(target, it)
            }
        }
        displayZoomControls?.also { target.displayZoomControls = it }
        domStorageEnabled?.also { target.domStorageEnabled = it }
//        enableSmoothTransition?.also { target.setEnableSmoothTransition(it) }
        fantasyFontFamily?.also { target.fantasyFontFamily = it }
        fixedFontFamily?.also { target.fixedFontFamily = it }
        forceDark?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(target, it)
            }
        }
//        geolocationDatabasePath?.also { target.setGeolocationDatabasePath(it) }
        geolocationEnabled?.also { target.setGeolocationEnabled(it) }
        javaScriptCanOpenWindowsAutomatically?.also {
            target.javaScriptCanOpenWindowsAutomatically = it
        }
        javaScriptEnabled?.also { target.javaScriptEnabled = it }
        layoutAlgorithm?.also { target.layoutAlgorithm = it }
//        lightTouchEnabled?.also { target.lightTouchEnabled = it }
        loadsImagesAutomatically?.also { target.loadsImagesAutomatically = it }
        loadWithOverviewMode?.also { target.loadWithOverviewMode = it }
//        mediaPlaybackRequiresUserGesture?.also {
//            target.mediaPlaybackRequiresUserGesture = it
//        }
        minimumFontSize?.also { target.minimumFontSize = it }
        minimumLogicalFontSize?.also { target.minimumLogicalFontSize = it }
        mixedContentMode?.also { target.mixedContentMode = it }
        needInitialFocus?.also { target.setNeedInitialFocus(it) }
        offscreenPreRaster?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.OFF_SCREEN_PRERASTER)) {
                WebSettingsCompat.setOffscreenPreRaster(target, it)
            }
        }
//        pluginState?.also { target.pluginState = it }
//        renderPriority?.also { target.setRenderPriority(it) }
        safeBrowsingEnabled?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_ENABLE)) {
                WebSettingsCompat.setSafeBrowsingEnabled(target, it)
            }
        }
        sansSerifFontFamily?.also { target.sansSerifFontFamily = it }
        saveFormData?.also { target.saveFormData = it }
//        savePassword?.also { target.savePassword = it }
        serifFontFamily?.also { target.serifFontFamily = it }
        standardFontFamily?.also { target.standardFontFamily = it }
        supportMultipleWindows?.also { target.setSupportMultipleWindows(it) }
        supportZoom?.also { target.setSupportZoom(it) }
//        textSize?.also { target.textSize = it }
        textZoom?.also { target.textZoom = it }
        userAgentString?.also { target.userAgentString = it }
        useWideViewPort?.also { target.useWideViewPort = it }
    }
}
