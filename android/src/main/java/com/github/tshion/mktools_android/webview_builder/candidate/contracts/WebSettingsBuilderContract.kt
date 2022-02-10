package com.github.tshion.mktools_android.webview_builder.candidate.contracts

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktForceDark
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMenuItemFlags
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMixedContentMode

/**
 * Defines [WebSettings] build rule.
 */
interface WebSettingsBuilderContract {

    /** @see WebSettings.setAllowContentAccess */
    fun allowContentAccess(allow: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowFileAccess */
    fun allowFileAccess(allow: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    @Deprecated("Deprecated in API level 30")
    fun allowFileAccessFromFileURLs(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    @Deprecated("Deprecated in API level 30")
    fun allowUniversalAccessFromFileURLs(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAppCacheEnabled */
    @Deprecated("Deprecated in API level 30")
    fun appCacheEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setAppCacheMaxSize */
    @Deprecated("Deprecated in API level 18")
    fun appCacheMaxSize(appCacheMaxSize: Long): WebSettingsBuilderContract

    /** @see WebSettings.setAppCachePath */
    @Deprecated("Deprecated in API level 30")
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
    @Deprecated("Deprecated in API level 19")
    fun databasePath(databasePath: String?): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultFixedFontSize */
    fun defaultFixedFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultFontSize */
    fun defaultFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultTextEncodingName */
    fun defaultTextEncodingName(encoding: String?): WebSettingsBuilderContract

    /** @see WebSettings.setDefaultZoom */
    @Deprecated("Deprecated in API level 19")
    fun defaultZoom(zoom: ZoomDensity?): WebSettingsBuilderContract

    /** @see WebSettings.setDisabledActionModeMenuItems */
    @RequiresApi(Build.VERSION_CODES.N)
    fun disabledActionModeMenuItems(@MktMenuItemFlags menuItems: Int): WebSettingsBuilderContract

    /** @see WebSettings.setDisplayZoomControls */
    fun displayZoomControls(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setDomStorageEnabled */
    fun domStorageEnabled(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setEnableSmoothTransition */
    @Deprecated("Deprecated in API level 17")
    fun enableSmoothTransition(enable: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setFantasyFontFamily */
    fun fantasyFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setFixedFontFamily */
    fun fixedFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setForceDark */
    @RequiresApi(Build.VERSION_CODES.Q)
    fun forceDark(@MktForceDark forceDarkMode: Int): WebSettingsBuilderContract

    /** @see WebSettings.setGeolocationDatabasePath */
    @Deprecated("Deprecated in API level 24")
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
    @Deprecated("Deprecated in API level 18")
    fun lightTouchEnabled(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setLoadsImagesAutomatically */
    fun loadsImagesAutomatically(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setLoadWithOverviewMode */
    fun loadWithOverviewMode(overview: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    @Deprecated("Deprecated in API level 17")
    fun mediaPlaybackRequiresUserGesture(require: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setMinimumFontSize */
    fun minimumFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setMinimumLogicalFontSize */
    fun minimumLogicalFontSize(@IntRange(from = 1, to = 72) size: Int): WebSettingsBuilderContract

    /** @see WebSettings.setMixedContentMode */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun mixedContentMode(@MktMixedContentMode mode: Int): WebSettingsBuilderContract

    /** @see WebSettings.setNeedInitialFocus */
    fun needInitialFocus(flag: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setOffscreenPreRaster */
    @RequiresApi(Build.VERSION_CODES.M)
    fun offscreenPreRaster(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setPluginState */
    @Deprecated("Deprecated in API level 18")
    fun pluginState(state: PluginState?): WebSettingsBuilderContract

    /** @see WebSettings.setRenderPriority */
    @Deprecated("Deprecated in API level 18")
    fun renderPriority(priority: RenderPriority?): WebSettingsBuilderContract

    /** @see WebSettings.setSafeBrowsingEnabled */
    @RequiresApi(Build.VERSION_CODES.O)
    fun safeBrowsingEnabled(enabled: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSansSerifFontFamily */
    fun sansSerifFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setSaveFormData */
    @Deprecated("Deprecated in API level 26")
    fun saveFormData(save: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSavePassword */
    @Deprecated("Deprecated in API level 18")
    fun savePassword(save: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setSerifFontFamily */
    fun serifFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.setStandardFontFamily */
    fun standardFontFamily(font: String?): WebSettingsBuilderContract

    /** @see WebSettings.supportMultipleWindows */
    fun supportMultipleWindows(support: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.supportZoom */
    fun supportZoom(support: Boolean): WebSettingsBuilderContract

    /** @see WebSettings.setTextSize */
    @Deprecated("Deprecated in API level 15")
    fun textSize(t: TextSize?): WebSettingsBuilderContract

    /** @see WebSettings.setTextZoom */
    fun textZoom(textZoom: Int): WebSettingsBuilderContract

    /** @see WebSettings.setUserAgentString */
    fun userAgentString(ua: String?): WebSettingsBuilderContract

    /** @see WebSettings.setUseWideViewPort */
    fun useWideViewPort(use: Boolean): WebSettingsBuilderContract
}
