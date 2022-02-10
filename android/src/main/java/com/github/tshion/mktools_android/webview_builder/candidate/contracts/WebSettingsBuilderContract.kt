package com.github.tshion.mktools_android.webview_builder.candidate.contracts

import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktForceDark
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMenuItemFlags
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMixedContentMode

/**
 * Defines [WebSettings] build rule.
 */
interface WebSettingsBuilderContract {

    /**
     * Apply settings to [WebSettings] instance.
     */
    fun apply(target: WebSettings)


    /** @see WebSettings.setAllowContentAccess */
    fun allowContentAccess(allow: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowFileAccess */
    fun allowFileAccess(allow: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    @Deprecated("Please visit 'See Also'.")
    fun allowFileAccessFromFileURLs(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    @Deprecated("Please visit 'See Also'.")
    fun allowUniversalAccessFromFileURLs(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAppCacheEnabled */
    @Deprecated("Please visit 'See Also'.")
    fun appCacheEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAppCacheMaxSize */
    @Deprecated("Please visit 'See Also'.")
    fun appCacheMaxSize(appCacheMaxSize: Long): WebSettingsBuilderContract

    /** @see WebSettings.setAppCachePath */
    @Deprecated("Please visit 'See Also'.")
    fun appCachePath(appCachePath: String?): WebSettingsBuilderContract

    /** @see WebSettings.setBlockNetworkImage */
    fun blockNetworkImage(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setBlockNetworkLoads */
    fun blockNetworkLoads(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setBuiltInZoomControls */
    fun builtInZoomControls(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setCacheMode */
    fun cacheMode(@MktCacheMode mode: Int): WebSettingsBuilderContract

    /** @see WebSettings.setCursiveFontFamily */
    fun cursiveFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setDatabaseEnabled */
    fun databaseEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setDatabasePath */
    @Deprecated("Please visit 'See Also'.")
    fun databasePath(databasePath: String?): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultFixedFontSize */
    fun defaultFixedFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultFontSize */
    fun defaultFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultTextEncodingName */
    fun defaultTextEncodingName(encoding: String?): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultZoom */
    @Deprecated("Please visit 'See Also'.")
    fun defaultZoom(zoom: ZoomDensity?): WebSettingsBuilderContract

    /** @see WebSettings.setDisabledActionModeMenuItems */
    fun disabledActionModeMenuItems(@MktMenuItemFlags menuItems: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDisplayZoomControls */
    fun displayZoomControls(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setDomStorageEnabled */
    fun domStorageEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setEnableSmoothTransition */
    @Deprecated("Please visit 'See Also'.")
    fun enableSmoothTransition(enable: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setFantasyFontFamily */
    fun fantasyFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setFixedFontFamily */
    fun fixedFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setForceDark */
    fun forceDark(@MktForceDark forceDarkMode: Int): WebSettingsBuilderContract

    /** @see WebSettings.setGeolocationDatabasePath */
    @Deprecated("Please visit 'See Also'.")
    fun geolocationDatabasePath(databasePath: String?): WebSettingsBuilderContract

    /** @see WebSettings.setGeolocationEnabled */
    fun geolocationEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    fun javaScriptCanOpenWindowsAutomatically(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setJavaScriptEnabled */
    fun javaScriptEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setLayoutAlgorithm */
    fun layoutAlgorithm(l: LayoutAlgorithm?): WebSettingsBuilderContract

    /** @see WebSettings.setLightTouchEnabled */
    @Deprecated("Please visit 'See Also'.")
    fun lightTouchEnabled(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setLoadsImagesAutomatically */
    fun loadsImagesAutomatically(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setLoadWithOverviewMode */
    fun loadWithOverviewMode(overview: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    fun mediaPlaybackRequiresUserGesture(require: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setMinimumFontSize */
    fun minimumFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setMinimumLogicalFontSize */
    fun minimumLogicalFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setMixedContentMode */
    fun mixedContentMode(@MktMixedContentMode mode: Int): WebSettingsBuilderContract

    /** @see WebSettings.setNeedInitialFocus */
    fun needInitialFocus(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setOffscreenPreRaster */
    fun offscreenPreRaster(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setPluginState */
    @Deprecated("Please visit 'See Also'.")
    fun pluginState(state: PluginState?): WebSettingsBuilderContract

    /** @see WebSettings.setRenderPriority */
    @Deprecated("Please visit 'See Also'.")
    fun renderPriority(priority: RenderPriority?): WebSettingsBuilderContract

    /** @see WebSettings.setSafeBrowsingEnabled */
    fun safeBrowsingEnabled(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSansSerifFontFamily */
    fun sansSerifFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setSaveFormData */
    @Deprecated("Please visit 'See Also'.")
    fun saveFormData(save: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSavePassword */
    @Deprecated("Please visit 'See Also'.")
    fun savePassword(save: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSerifFontFamily */
    fun serifFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setStandardFontFamily */
    fun standardFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.supportMultipleWindows */
    fun supportMultipleWindows(support: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.supportZoom */
    fun supportZoom(support: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setTextZoom */
    fun textZoom(textZoom: Int): WebSettingsBuilderContract

    /** @see WebSettings.setUserAgentString */
    fun userAgentString(ua: String?): WebSettingsBuilderContract

    /** @see WebSettings.setUseWideViewPort */
    fun useWideViewPort(use: Boolean): WebSettingsBuilderContract
}
