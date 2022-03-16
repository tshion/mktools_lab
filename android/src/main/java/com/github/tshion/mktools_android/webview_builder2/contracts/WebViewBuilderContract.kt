package com.github.tshion.mktools_android.webview_builder2.contracts

import android.net.http.SslCertificate
import android.webkit.DownloadListener
import android.webkit.WebView
import android.webkit.WebView.FindListener
import android.webkit.WebView.PictureListener
import androidx.annotation.IntRange
import androidx.webkit.WebViewClientCompat
import androidx.webkit.WebViewCompat.WebMessageListener
import com.github.tshion.mktools_android.webview_builder.annotations.MktScrollBarStyle

/**
 * Defines [WebView] and [androidx.webkit.WebViewCompat] build rule.
 */
interface WebViewBuilderContract {

    /** @see WebView.addJavascriptInterface */
//    @JavascriptInterface
//    fun addJavascriptInterface(
//        `object`: Any,
//        name: String
//    ): WebViewBuilderContract

    /** @see androidx.webkit.WebViewCompat.addWebMessageListener */
    fun addWebMessageListener(
        jsObjectName: String,
        allowedOriginRules: MutableSet<String>,
        listener: WebMessageListener,
    ): WebViewBuilderContract

    /** @see WebView.setBackgroundColor */
//    fun backgroundColor(@ColorInt color: Int): WebViewBuilderContract

    /** @see WebView.setCertificate */
    @Deprecated("Deprecated in API level 17")
    fun certificate(certificate: SslCertificate): WebViewBuilderContract

    /** @see WebView.setDownloadListener */
    fun downloadListener(listener: DownloadListener?): WebViewBuilderContract

    /** @see WebView.setFindListener */
    fun findListener(listener: FindListener?): WebViewBuilderContract

    /** @see WebView.setHorizontalScrollbarOverlay */
    @Deprecated("Deprecated in API level 23")
    fun horizontalScrollbarOverlay(overlay: Boolean): WebViewBuilderContract

    /** @see WebView.setHttpAuthUsernamePassword */
//    @Deprecated("Deprecated in API level 26")
//    fun httpAuthUsernamePassword(
//        host: String,
//        realm: String,
//        username: String,
//        password: String
//    ): WebViewBuilderContract

    /** @see WebView.setInitialScale */
    fun initialScale(@IntRange(from = 0, to = 100) scaleInPercent: Int): WebViewBuilderContract

    /** @see WebView.setLayerType */
//    fun layerType(
//        @MktLayerType layerType: Int,
//        paint: Paint?
//    ): WebViewBuilderContract

    /** @see WebView.setLayoutParams */
//    fun layoutParams(params: LayoutParams): WebViewBuilderContract

    /** @see WebView.setMapTrackballToArrowKeys */
    @Deprecated("Deprecated in API level 17")
    fun mapTrackballToArrowKeys(setMap: Boolean): WebViewBuilderContract

    /** @see WebView.setNetworkAvailable */
//    fun networkAvailable(networkUp: Boolean): WebViewBuilderContract

    /** @see WebView.setOverScrollMode */
//    fun overScrollMode(mode: Int): WebViewBuilderContract

    /** @see WebView.setPictureListener */
    @Deprecated("Deprecated in API level 15")
    fun pictureListener(listener: PictureListener): WebViewBuilderContract

    /** @see androidx.webkit.WebViewCompat.postVisualStateCallback */
//    fun postVisualStateCallback(
//        requestId: Long,
//        callback: VisualStateCallback,
//    ): WebViewBuilderContract

    /** @see WebView.removeJavascriptInterface */
//    fun removeJavascriptInterface(name: String): WebViewBuilderContract

    /** @see androidx.webkit.WebViewCompat.removeWebMessageListener */
    fun removeWebMessageListener(jsObjectName: String): WebViewBuilderContract

    /** @see WebView.setRendererPriorityPolicy */
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun rendererPriorityPolicy(
//        @MktRendererPriority rendererRequestedPriority: Int,
//        waivedWhenNotVisible: Boolean,
//    ): WebViewBuilderContract

    /** @see WebView.setScrollBarStyle */
    fun scrollBarStyle(@MktScrollBarStyle style: Int): WebViewBuilderContract

    /** @see WebView.showFindDialog */
    @Deprecated("Deprecated in API level 18")
    fun showFindDialog(text: String?, showIme: Boolean): WebViewBuilderContract

    /** @see WebView.setTextClassifier */
//    @RequiresApi(Build.VERSION_CODES.O_MR1)
//    fun textClassifier(textClassifier: TextClassifier?): WebViewBuilderContract

    /** @see WebView.setVerticalScrollbarOverlay */
    @Deprecated("Deprecated in API level 23")
    fun verticalScrollbarOverlay(overlay: Boolean): WebViewBuilderContract

    /** @see WebView.zoomBy */
//    fun zoomBy(@FloatRange(from = 0.01, to = 100.0) zoomFactor: Float): WebViewBuilderContract


    fun applyWebViewBuilder(target: WebView)

    fun hasWebViewBuilder(): Boolean
}
