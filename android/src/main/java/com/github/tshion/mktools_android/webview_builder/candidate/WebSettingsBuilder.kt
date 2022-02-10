package com.github.tshion.mktools_android.webview_builder.candidate

import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntRange
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktCacheMode
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktForceDark
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMenuItemFlags
import com.github.tshion.mktools_android.webview_builder.candidate.annotations.MktMixedContentMode

class WebSettingsBuilder : WebSettingsBuilderContract {

    private var allowContentAccess: Boolean? = null
    private var allowFileAccess: Boolean? = null
    private var allowFileAccessFromFileURLs: Boolean? = null
    private var allowUniversalAccessFromFileURLs: Boolean? = null
    private var appCacheEnabled: Boolean? = null
    private var appCacheMaxSize: Long? = null
    private var appCachePath: String? = null
    private var blockNetworkImage: Boolean? = null
    private var blockNetworkLoads: Boolean? = null
    private var builtInZoomControls: Boolean? = null
    private var cacheMode: Int? = null
    private var cursiveFontFamily: String? = null
    private var databaseEnabled: Boolean? = null
    private var databasePath: String? = null
    private var defaultFixedFontSize: Int? = null
    private var defaultFontSize: Int? = null
    private var defaultTextEncodingName: String? = null
    private var defaultZoom: ZoomDensity? = null
    private var disabledActionModeMenuItems: Int? = null
    private var displayZoomControls: Boolean? = null
    private var domStorageEnabled: Boolean? = null
    private var enableSmoothTransition: Boolean? = null
    private var fantasyFontFamily: String? = null
    private var fixedFontFamily: String? = null
    private var forceDark: Int? = null
    private var geolocationDatabasePath: String? = null
    private var geolocationEnabled: Boolean? = null
    private var javaScriptCanOpenWindowsAutomatically: Boolean? = null
    private var javaScriptEnabled: Boolean? = null
    private var layoutAlgorithm: LayoutAlgorithm? = null
    private var lightTouchEnabled: Boolean? = null
    private var loadWithOverviewMode: Boolean? = null
    private var loadsImagesAutomatically: Boolean? = null
    private var mediaPlaybackRequiresUserGesture: Boolean? = null
    private var minimumFontSize: Int? = null
    private var minimumLogicalFontSize: Int? = null
    private var mixedContentMode: Int? = null
    private var needInitialFocus: Boolean? = null
    private var offscreenPreRaster: Boolean? = null
    private var pluginState: PluginState? = null
    private var renderPriority: RenderPriority? = null
    private var safeBrowsingEnabled: Boolean? = null
    private var sansSerifFontFamily: String? = null
    private var saveFormData: Boolean? = null
    private var savePassword: Boolean? = null
    private var serifFontFamily: String? = null
    private var standardFontFamily: String? = null
    private var supportMultipleWindows: Boolean? = null
    private var supportZoom: Boolean? = null
    private var textZoom: Int? = null
    private var userAgentString: String? = null
    private var useWideViewPort: Boolean? = null


    /** @see WebSettings.setAllowContentAccess */
    override fun allowContentAccess(allow: Boolean) = apply {
        allowContentAccess = allow
    }

    /** @see WebSettings.setAllowFileAccess */
    override fun allowFileAccess(allow: Boolean) = apply {
        allowFileAccess = allow
    }

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    override fun allowFileAccessFromFileURLs(flag: Boolean) = apply {
        allowFileAccessFromFileURLs = flag
    }

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    override fun allowUniversalAccessFromFileURLs(flag: Boolean) = apply {
        allowUniversalAccessFromFileURLs = flag
    }

    /** @see WebSettings.setAppCacheEnabled */
    override fun appCacheEnabled(flag: Boolean) = apply {
        appCacheEnabled = flag
    }

    /** @see WebSettings.setAppCacheMaxSize */
    override fun appCacheMaxSize(appCacheMaxSize: Long) = apply {
        this.appCacheMaxSize = appCacheMaxSize
    }

    /** @see WebSettings.setAppCachePath */
    override fun appCachePath(appCachePath: String?) = apply {
        this.appCachePath = appCachePath
    }

    /** @see WebSettings.setBlockNetworkImage */
    override fun blockNetworkImage(flag: Boolean) = apply {
        blockNetworkImage = flag
    }

    /** @see WebSettings.setBlockNetworkLoads */
    override fun blockNetworkLoads(flag: Boolean) = apply {
        blockNetworkLoads = flag
    }

    /** @see WebSettings.setBuiltInZoomControls */
    override fun builtInZoomControls(enabled: Boolean) = apply {
        builtInZoomControls = enabled
    }

    /** @see WebSettings.setCacheMode */
    override fun cacheMode(@MktCacheMode mode: Int) = apply {
        cacheMode = mode
    }

    /** @see WebSettings.setCursiveFontFamily */
    override fun cursiveFontFamily(font: String?) = apply {
        cursiveFontFamily = font
    }

    /** @see WebSettings.setDatabaseEnabled */
    override fun databaseEnabled(flag: Boolean) = apply {
        databaseEnabled = flag
    }

    /** @see WebSettings.setDatabasePath */
    override fun databasePath(databasePath: String?) = apply {
        this.databasePath = databasePath
    }

    /** @see WebSettings.setDefaultFixedFontSize */
    override fun defaultFixedFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        defaultFixedFontSize = size
    }

    /** @see WebSettings.setDefaultFontSize */
    override fun defaultFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        defaultFixedFontSize = size
    }

    /** @see WebSettings.setDefaultTextEncodingName */
    override fun defaultTextEncodingName(encoding: String?) = apply {
        defaultTextEncodingName = encoding
    }

    /** @see WebSettings.setDefaultZoom */
    override fun defaultZoom(zoom: ZoomDensity?) = apply {
        defaultZoom = zoom
    }

    /** @see WebSettings.setDisabledActionModeMenuItems */
    override fun disabledActionModeMenuItems(@MktMenuItemFlags menuItems: Int) = apply {
        disabledActionModeMenuItems = menuItems
    }

    /** @see WebSettings.setDisplayZoomControls */
    override fun displayZoomControls(enabled: Boolean) = apply {
        displayZoomControls = enabled
    }

    /** @see WebSettings.setDomStorageEnabled */
    override fun domStorageEnabled(flag: Boolean) = apply {
        domStorageEnabled = flag
    }

    /** @see WebSettings.setEnableSmoothTransition */
    override fun enableSmoothTransition(enable: Boolean) = apply {
        enableSmoothTransition = enable
    }

    /** @see WebSettings.setFantasyFontFamily */
    override fun fantasyFontFamily(font: String?) = apply {
        fantasyFontFamily = font
    }

    /** @see WebSettings.setFixedFontFamily */
    override fun fixedFontFamily(font: String?) = apply {
        fixedFontFamily = font
    }

    /** @see WebSettings.setForceDark */
    override fun forceDark(@MktForceDark forceDarkMode: Int) = apply {
        forceDark = forceDarkMode
    }

    /** @see WebSettings.setGeolocationDatabasePath */
    override fun geolocationDatabasePath(databasePath: String?) = apply {
        geolocationDatabasePath = databasePath
    }

    /** @see WebSettings.setGeolocationEnabled */
    override fun geolocationEnabled(flag: Boolean) = apply {
        geolocationEnabled = flag
    }

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    override fun javaScriptCanOpenWindowsAutomatically(flag: Boolean) = apply {
        javaScriptCanOpenWindowsAutomatically = flag
    }

    /** @see WebSettings.setJavaScriptEnabled */
    override fun javaScriptEnabled(flag: Boolean) = apply {
        javaScriptEnabled = flag
    }

    /** @see WebSettings.setLayoutAlgorithm */
    override fun layoutAlgorithm(l: LayoutAlgorithm?) = apply {
        layoutAlgorithm = l
    }

    /** @see WebSettings.setLightTouchEnabled */
    override fun lightTouchEnabled(enabled: Boolean) = apply {
        lightTouchEnabled = enabled
    }

    /** @see WebSettings.setLoadsImagesAutomatically */
    override fun loadsImagesAutomatically(flag: Boolean) = apply {
        loadsImagesAutomatically = flag
    }

    /** @see WebSettings.setLoadWithOverviewMode */
    override fun loadWithOverviewMode(overview: Boolean) = apply {
        loadWithOverviewMode = overview
    }

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    override fun mediaPlaybackRequiresUserGesture(require: Boolean) = apply {
        mediaPlaybackRequiresUserGesture = require
    }

    /** @see WebSettings.setMinimumFontSize */
    override fun minimumFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        minimumFontSize = size
    }

    /** @see WebSettings.setMinimumLogicalFontSize */
    override fun minimumLogicalFontSize(@IntRange(from = 1, to = 72) size: Int) = apply {
        minimumLogicalFontSize = size
    }

    /** @see WebSettings.setMixedContentMode */
    override fun mixedContentMode(@MktMixedContentMode mode: Int) = apply {
        mixedContentMode = mode
    }

    /** @see WebSettings.setNeedInitialFocus */
    override fun needInitialFocus(flag: Boolean) = apply {
        needInitialFocus = flag
    }

    /** @see WebSettings.setOffscreenPreRaster */
    override fun offscreenPreRaster(enabled: Boolean) = apply {
        offscreenPreRaster = enabled
    }

    /** @see WebSettings.setPluginState */
    override fun pluginState(state: PluginState?) = apply {
        pluginState = state
    }

    /** @see WebSettings.setRenderPriority */
    override fun renderPriority(priority: RenderPriority?) = apply {
        renderPriority = priority
    }

    /** @see WebSettings.setSafeBrowsingEnabled */
    override fun safeBrowsingEnabled(enabled: Boolean) = apply {
        safeBrowsingEnabled = enabled
    }

    /** @see WebSettings.setSansSerifFontFamily */
    override fun sansSerifFontFamily(font: String?) = apply {
        sansSerifFontFamily = font
    }

    /** @see WebSettings.setSaveFormData */
    override fun saveFormData(save: Boolean) = apply {
        saveFormData = save
    }

    /** @see WebSettings.setSavePassword */
    override fun savePassword(save: Boolean) = apply {
        savePassword = save
    }

    /** @see WebSettings.setSerifFontFamily */
    override fun serifFontFamily(font: String?) = apply {
        serifFontFamily = font
    }

    /** @see WebSettings.setStandardFontFamily */
    override fun standardFontFamily(font: String?) = apply {
        standardFontFamily = font
    }

    /** @see WebSettings.supportMultipleWindows */
    override fun supportMultipleWindows(support: Boolean) = apply {
        supportMultipleWindows = support
    }

    /** @see WebSettings.supportZoom */
    override fun supportZoom(support: Boolean) = apply {
        supportZoom = support
    }

    /** @see WebSettings.setTextZoom */
    override fun textZoom(textZoom: Int) = apply {
        this.textZoom = textZoom
    }

    /** @see WebSettings.setUserAgentString */
    override fun userAgentString(ua: String?) = apply {
        userAgentString = ua
    }

    /** @see WebSettings.setUseWideViewPort */
    override fun useWideViewPort(use: Boolean) = apply {
        useWideViewPort = use
    }


    /**
     * Apply settings to [WebSettings] instance.
     */
    override fun apply(target: WebSettings) {
        allowContentAccess?.also { target.allowContentAccess = it }
        allowFileAccess?.also { target.allowFileAccess = it }
        allowFileAccessFromFileURLs?.also { target.allowFileAccessFromFileURLs = it }
        allowUniversalAccessFromFileURLs?.also { target.allowUniversalAccessFromFileURLs = it }
        appCacheEnabled?.also { target.setAppCacheEnabled(it) }
        appCacheMaxSize?.also { target.setAppCacheMaxSize(it) }
        appCachePath?.also { target.setAppCachePath(it) }
        blockNetworkImage?.also { target.blockNetworkImage = it }
        blockNetworkLoads?.also { target.blockNetworkLoads = it }
        builtInZoomControls?.also { target.builtInZoomControls = it }
        cacheMode?.also { target.cacheMode = it }
        cursiveFontFamily?.also { target.cursiveFontFamily = it }
        databaseEnabled?.also { target.databaseEnabled = it }
        databasePath?.also { target.databasePath = it }
        defaultFixedFontSize?.also { target.defaultFixedFontSize = it }
        defaultFontSize?.also { target.defaultFontSize = it }
        defaultTextEncodingName?.also { target.defaultTextEncodingName = it }
        defaultZoom?.also { target.defaultZoom = it }
        disabledActionModeMenuItems?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS)) {
                WebSettingsCompat.setDisabledActionModeMenuItems(target, it)
            }
        }
        displayZoomControls?.also { target.displayZoomControls = it }
        domStorageEnabled?.also { target.domStorageEnabled = it }
        enableSmoothTransition?.also { target.setEnableSmoothTransition(it) }
        fantasyFontFamily?.also { target.fantasyFontFamily = it }
        fixedFontFamily?.also { target.fixedFontFamily = it }
        forceDark?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(target, it)
            }
        }
        geolocationDatabasePath?.also { target.setGeolocationDatabasePath(it) }
        geolocationEnabled?.also { target.setGeolocationEnabled(it) }
        javaScriptCanOpenWindowsAutomatically?.also {
            target.javaScriptCanOpenWindowsAutomatically = it
        }
        javaScriptEnabled?.also { target.javaScriptEnabled = it }
        layoutAlgorithm?.also { target.layoutAlgorithm = it }
        lightTouchEnabled?.also { target.lightTouchEnabled = it }
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
        pluginState?.also { target.pluginState = it }
        renderPriority?.also { target.setRenderPriority(it) }
        safeBrowsingEnabled?.also {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_ENABLE)) {
                WebSettingsCompat.setSafeBrowsingEnabled(target, it)
            }
        }
        sansSerifFontFamily?.also { target.sansSerifFontFamily = it }
        saveFormData?.also { target.saveFormData = it }
        savePassword?.also { target.savePassword = it }
        serifFontFamily?.also { target.serifFontFamily = it }
        standardFontFamily?.also { target.standardFontFamily = it }
        supportMultipleWindows?.also { target.setSupportMultipleWindows(it) }
        supportZoom?.also { target.setSupportZoom(it) }
        textZoom?.also { target.textZoom = it }
        userAgentString?.also { target.userAgentString = it }
        useWideViewPort?.also { target.useWideViewPort = it }
    }
}
