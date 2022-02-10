package com.github.tshion.mktools_android.webview_builder.candidate

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktForceDark
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMenuItemFlags
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMixedContentMode
import com.github.tshion.mktools_android.webview_builder.candidate.contracts.WebSettingsBuilderContract
import com.github.tshion.mktools_android.webview_builder.candidate.entities.WebSettingsEntity

/**
 * Builds [WebSettings].
 *
 * ## Example
 * ``` kotlin
 * WebSettingsBuilder()
 *     .javaScriptEnabled(true)
 *     .apply(settings)
 * ```
 */
class WebSettingsBuilder : WebSettingsBuilderContract {

    private val state = WebSettingsEntity()


    /** @see WebSettings.setAllowContentAccess */
    override fun allowContentAccess(allow: Boolean) = apply {
        state.allowContentAccess = allow
    }

    /** @see WebSettings.setAllowFileAccess */
    override fun allowFileAccess(allow: Boolean) = apply {
        state.allowFileAccess = allow
    }

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    override fun allowFileAccessFromFileURLs(flag: Boolean) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            state.allowFileAccessFromFileURLs = flag
        }
    }

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    override fun allowUniversalAccessFromFileURLs(flag: Boolean) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            state.allowUniversalAccessFromFileURLs = flag
        }
    }

    /** @see WebSettings.setAppCacheEnabled */
    override fun appCacheEnabled(flag: Boolean) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            state.appCacheEnabled = flag
        }
    }

    /** @see WebSettings.setAppCacheMaxSize */
    override fun appCacheMaxSize(appCacheMaxSize: Long) = this

    /** @see WebSettings.setAppCachePath */
    override fun appCachePath(appCachePath: String?) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            state.appCachePath = appCachePath
        }
    }

    /** @see WebSettings.setBlockNetworkImage */
    override fun blockNetworkImage(flag: Boolean) = apply {
        state.blockNetworkImage = flag
    }

    /** @see WebSettings.setBlockNetworkLoads */
    override fun blockNetworkLoads(flag: Boolean) = apply {
        state.blockNetworkLoads = flag
    }

    /** @see WebSettings.setBuiltInZoomControls */
    override fun builtInZoomControls(enabled: Boolean) = apply {
        state.builtInZoomControls = enabled
    }

    /** @see WebSettings.setCacheMode */
    override fun cacheMode(@MktCacheMode mode: Int) = apply {
        state.cacheMode = mode
    }

    /** @see WebSettings.setCursiveFontFamily */
    override fun cursiveFontFamily(font: String?) = apply {
        state.cursiveFontFamily = font
    }

    /** @see WebSettings.setDatabaseEnabled */
    override fun databaseEnabled(flag: Boolean) = apply {
        state.databaseEnabled = flag
    }

    /** @see WebSettings.setDatabasePath */
    override fun databasePath(databasePath: String?) = this

    /** @see WebSettings.setDefaultFixedFontSize */
    override fun defaultFixedFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        state.defaultFixedFontSize = size
    }

    /** @see WebSettings.setDefaultFontSize */
    override fun defaultFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        state.defaultFixedFontSize = size
    }

    /** @see WebSettings.setDefaultTextEncodingName */
    override fun defaultTextEncodingName(encoding: String?) = apply {
        state.defaultTextEncodingName = encoding
    }

    /** @see WebSettings.setDefaultZoom */
    override fun defaultZoom(zoom: ZoomDensity?) = this

    /** @see WebSettings.setDisabledActionModeMenuItems */
    @RequiresApi(Build.VERSION_CODES.N)
    override fun disabledActionModeMenuItems(@MktMenuItemFlags menuItems: Int) = apply {
        state.disabledActionModeMenuItems = menuItems
    }

    /** @see WebSettings.setDisplayZoomControls */
    override fun displayZoomControls(enabled: Boolean) = apply {
        state.displayZoomControls = enabled
    }

    /** @see WebSettings.setDomStorageEnabled */
    override fun domStorageEnabled(flag: Boolean) = apply {
        state.domStorageEnabled = flag
    }

    /** @see WebSettings.setEnableSmoothTransition */
    override fun enableSmoothTransition(enable: Boolean) = this

    /** @see WebSettings.setFantasyFontFamily */
    override fun fantasyFontFamily(font: String?) = apply {
        state.fantasyFontFamily = font
    }

    /** @see WebSettings.setFixedFontFamily */
    override fun fixedFontFamily(font: String?) = apply {
        state.fixedFontFamily = font
    }

    /** @see WebSettings.setForceDark */
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun forceDark(@MktForceDark forceDarkMode: Int) = apply {
        state.forceDark = forceDarkMode
    }

    /** @see WebSettings.setGeolocationDatabasePath */
    override fun geolocationDatabasePath(databasePath: String?) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            state.geolocationDatabasePath = databasePath
        }
    }

    /** @see WebSettings.setGeolocationEnabled */
    override fun geolocationEnabled(flag: Boolean) = apply {
        state.geolocationEnabled = flag
    }

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    override fun javaScriptCanOpenWindowsAutomatically(flag: Boolean) = apply {
        state.javaScriptCanOpenWindowsAutomatically = flag
    }

    /** @see WebSettings.setJavaScriptEnabled */
    override fun javaScriptEnabled(flag: Boolean) = apply {
        state.javaScriptEnabled = flag
    }

    /** @see WebSettings.setLayoutAlgorithm */
    override fun layoutAlgorithm(l: LayoutAlgorithm?) = apply {
        state.layoutAlgorithm = l
    }

    /** @see WebSettings.setLightTouchEnabled */
    override fun lightTouchEnabled(enabled: Boolean) = this

    /** @see WebSettings.setLoadsImagesAutomatically */
    override fun loadsImagesAutomatically(flag: Boolean) = apply {
        state.loadsImagesAutomatically = flag
    }

    /** @see WebSettings.setLoadWithOverviewMode */
    override fun loadWithOverviewMode(overview: Boolean) = apply {
        state.loadWithOverviewMode = overview
    }

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    override fun mediaPlaybackRequiresUserGesture(require: Boolean) = this

    /** @see WebSettings.setMinimumFontSize */
    override fun minimumFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        state.minimumFontSize = size
    }

    /** @see WebSettings.setMinimumLogicalFontSize */
    override fun minimumLogicalFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        state.minimumLogicalFontSize = size
    }

    /** @see WebSettings.setMixedContentMode */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun mixedContentMode(@MktMixedContentMode mode: Int) = apply {
        state.mixedContentMode = mode
    }

    /** @see WebSettings.setNeedInitialFocus */
    override fun needInitialFocus(flag: Boolean) = apply {
        state.needInitialFocus = flag
    }

    /** @see WebSettings.setOffscreenPreRaster */
    @RequiresApi(Build.VERSION_CODES.M)
    override fun offscreenPreRaster(enabled: Boolean) = apply {
        state.offscreenPreRaster = enabled
    }

    /** @see WebSettings.setPluginState */
    override fun pluginState(state: PluginState?) = this

    /** @see WebSettings.setRenderPriority */
    override fun renderPriority(priority: RenderPriority?) = this

    /** @see WebSettings.setSafeBrowsingEnabled */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun safeBrowsingEnabled(enabled: Boolean) = apply {
        state.safeBrowsingEnabled = enabled
    }

    /** @see WebSettings.setSansSerifFontFamily */
    override fun sansSerifFontFamily(font: String?) = apply {
        state.sansSerifFontFamily = font
    }

    /** @see WebSettings.setSaveFormData */
    override fun saveFormData(save: Boolean) = apply {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            state.saveFormData = save
        }
    }

    /** @see WebSettings.setSavePassword */
    override fun savePassword(save: Boolean) = this

    /** @see WebSettings.setSerifFontFamily */
    override fun serifFontFamily(font: String?) = apply {
        state.serifFontFamily = font
    }

    /** @see WebSettings.setStandardFontFamily */
    override fun standardFontFamily(font: String?) = apply {
        state.standardFontFamily = font
    }

    /** @see WebSettings.supportMultipleWindows */
    override fun supportMultipleWindows(support: Boolean) = apply {
        state.supportMultipleWindows = support
    }

    /** @see WebSettings.supportZoom */
    override fun supportZoom(support: Boolean) = apply {
        state.supportZoom = support
    }

    /** @see WebSettings.setTextSize */
    override fun textSize(t: TextSize?) = this

    /** @see WebSettings.setTextZoom */
    override fun textZoom(textZoom: Int) = apply {
        state.textZoom = textZoom
    }

    /** @see WebSettings.setUserAgentString */
    override fun userAgentString(ua: String?) = apply {
        state.userAgentString = ua
    }

    /** @see WebSettings.setUseWideViewPort */
    override fun useWideViewPort(use: Boolean) = apply {
        state.useWideViewPort = use
    }


    /**
     * Apply settings to [WebSettings] instance.
     */
    fun apply(target: WebSettings) {
        state.into(target)
    }
}
