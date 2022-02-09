package com.github.tshion.mktools_android.webview_builder.inner

import android.annotation.TargetApi
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

interface WebSettingsContract {

    @IntDef(LOAD_CACHE_ELSE_NETWORK, LOAD_CACHE_ONLY, LOAD_DEFAULT, LOAD_NO_CACHE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class CacheModeType

    @IntDef(FORCE_DARK_AUTO, FORCE_DARK_OFF, FORCE_DARK_ON)
    @Retention(AnnotationRetention.SOURCE)
    @TargetApi(29)
    annotation class ForceDarkType

    @IntDef(MENU_ITEM_NONE, MENU_ITEM_PROCESS_TEXT, MENU_ITEM_SHARE, MENU_ITEM_WEB_SEARCH)
    @Retention(AnnotationRetention.SOURCE)
    @TargetApi(24)
    annotation class MenuItemsType

    @IntDef(MIXED_CONTENT_ALWAYS_ALLOW, MIXED_CONTENT_COMPATIBILITY_MODE, MIXED_CONTENT_NEVER_ALLOW)
    @Retention(AnnotationRetention.SOURCE)
    annotation class MixedContentModeType


    /** @see WebSettings.setAllowContentAccess */
    fun allowContentAccess(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowFileAccess */
    fun allowFileAccess(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowFileAccessFromFileURLs */
    fun allowFileAccessFromFileURLs(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAllowUniversalAccessFromFileURLs */
    fun allowUniversalAccessFromFileURLs(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAppCacheEnabled */
    fun appCacheEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setAppCachePath */
    fun appCachePath(input: String?): WebSettingsContract

    /** @see WebSettings.setBlockNetworkImage */
    fun blockNetworkImage(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setBlockNetworkLoads */
    fun blockNetworkLoads(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setBuiltInZoomControls */
    fun builtInZoomControls(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setCacheMode */
    fun cacheMode(@CacheModeType input: Int?): WebSettingsContract

    /** @see WebSettings.setCursiveFontFamily */
    fun cursiveFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setDatabaseEnabled */
    fun databaseEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setDefaultFixedFontSize */
    fun defaultFixedFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setDefaultFontSize */
    fun defaultFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setDefaultTextEncodingName */
    fun defaultTextEncodingName(input: String?): WebSettingsContract

    /** @see WebSettings.setDisabledActionModeMenuItems */
    fun disabledActionModeMenuItems(@MenuItemsType input: Int?): WebSettingsContract

    /** @see WebSettings.setDisplayZoomControls */
    fun displayZoomControls(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setDomStorageEnabled */
    fun domStorageEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setFantasyFontFamily */
    fun fantasyFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setFixedFontFamily */
    fun fixedFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setForceDark */
    fun forceDark(@ForceDarkType input: Int?): WebSettingsContract

    /** @see WebSettings.setGeolocationEnabled */
    fun geolocationEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setJavaScriptCanOpenWindowsAutomatically */
    fun javaScriptCanOpenWindowsAutomatically(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setJavaScriptEnabled */
    fun javaScriptEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setLayoutAlgorithm */
    fun layoutAlgorithm(input: LayoutAlgorithm?): WebSettingsContract

    /** @see WebSettings.setLoadsImagesAutomatically */
    fun loadsImagesAutomatically(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setLoadWithOverviewMode */
    fun loadWithOverviewMode(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setMediaPlaybackRequiresUserGesture */
    fun mediaPlaybackRequiresUserGesture(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setMinimumFontSize */
    fun minimumFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setMinimumLogicalFontSize */
    fun minimumLogicalFontSize(input: Int?): WebSettingsContract

    /** @see WebSettings.setMixedContentMode */
    fun mixedContentMode(@MixedContentModeType input: Int?): WebSettingsContract

    /** @see WebSettings.setNeedInitialFocus */
    fun needInitialFocus(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setOffscreenPreRaster */
    fun offscreenPreRaster(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setSafeBrowsingEnabled */
    fun safeBrowsingEnabled(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setSansSerifFontFamily */
    fun sansSerifFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setSerifFontFamily */
    fun serifFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.setStandardFontFamily */
    fun standardFontFamily(input: String?): WebSettingsContract

    /** @see WebSettings.supportMultipleWindows */
    fun supportMultipleWindows(input: Boolean?): WebSettingsContract

    /** @see WebSettings.supportZoom */
    fun supportZoom(input: Boolean?): WebSettingsContract

    /** @see WebSettings.setTextZoom */
    fun textZoom(input: Int?): WebSettingsContract

    /** @see WebSettings.setUserAgentString */
    fun userAgentString(input: String?): WebSettingsContract

    /** @see WebSettings.setUseWideViewPort */
    fun useWideViewPort(input: Boolean?): WebSettingsContract
}
