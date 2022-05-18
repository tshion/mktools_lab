package com.github.tshion.mktools_android.webview_builder2.proxies

import android.net.http.SslCertificate
import android.os.Build
import android.webkit.DownloadListener
import android.webkit.WebView
import android.webkit.WebView.FindListener
import androidx.annotation.IntRange
import androidx.collection.ArrayMap
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewCompat.WebMessageListener
import androidx.webkit.WebViewFeature
import androidx.webkit.WebViewFeature.WEB_MESSAGE_LISTENER
import com.github.tshion.mktools_android.webview_builder.annotations.MktScrollBarStyle
import com.github.tshion.mktools_android.webview_builder2.contracts.WebViewBuilderContract

/**
 * Proxy of [WebView] and [androidx.webkit.WebViewCompat].
 */
internal class WebViewProxy : WebViewBuilderContract {

    private var downloadListener: DownloadListener? = null

    private var findListener: FindListener? = null

    private var horizontalScrollbarOverlay: Boolean? = null

    @IntRange(from = 0, to = 100)
    private var initialScale: Int? = null

    @MktScrollBarStyle
    private var scrollBarStyle: Int? = null

    private var verticalScrollbarOverlay: Boolean? = null

    private var webMessage = ArrayMap<String, Pair<MutableSet<String>, WebMessageListener>?>()


    override fun addWebMessageListener(
        jsObjectName: String,
        allowedOriginRules: MutableSet<String>,
        listener: WebMessageListener
    ) = apply { webMessage[jsObjectName] = allowedOriginRules to listener }

    override fun certificate(
        certificate: SslCertificate
    ) = this

    override fun downloadListener(
        listener: DownloadListener?
    ) = apply { downloadListener = listener }

    override fun findListener(
        listener: FindListener?
    ) = apply { findListener = listener }

    override fun horizontalScrollbarOverlay(
        overlay: Boolean
    ) = apply { horizontalScrollbarOverlay = overlay }

    override fun initialScale(
        @IntRange(from = 0, to = 100) scaleInPercent: Int
    ) = apply { initialScale = scaleInPercent }

    override fun mapTrackballToArrowKeys(
        setMap: Boolean
    ) = this

    override fun pictureListener(
        listener: WebView.PictureListener
    ) = this

    override fun removeWebMessageListener(
        jsObjectName: String
    ) = apply {
        if (webMessage.contains(jsObjectName)) {
            webMessage.remove(jsObjectName)
        } else {
            webMessage[jsObjectName] = null
        }
    }

    override fun scrollBarStyle(
        @MktScrollBarStyle style: Int
    ) = apply { scrollBarStyle = style }

    override fun showFindDialog(
        text: String?,
        showIme: Boolean
    ) = this

    override fun verticalScrollbarOverlay(
        overlay: Boolean
    ) = apply { verticalScrollbarOverlay = overlay }


    override fun applyWebViewBuilder(target: WebView) {
        target.setDownloadListener(downloadListener)
        target.setFindListener(findListener)
        horizontalScrollbarOverlay?.also {
            if (Build.VERSION_CODES.M <= Build.VERSION.SDK_INT) return@also
            target.setHorizontalScrollbarOverlay(it)
        }
        initialScale?.also { target.setInitialScale(it) }
//        if (WebViewFeature.isFeatureSupported(VISUAL_STATE_CALLBACK)) {
//            for ((key, value) in postVisualStateCallback) {
//                WebViewCompat.postVisualStateCallback(target, key, value)
//            }
//        }
        scrollBarStyle?.also { target.scrollBarStyle = it }
        verticalScrollbarOverlay?.also {
            if (Build.VERSION_CODES.M <= Build.VERSION.SDK_INT) return@also
            target.setVerticalScrollbarOverlay(it)
        }
        if (WebViewFeature.isFeatureSupported(WEB_MESSAGE_LISTENER)) {
            for ((key, value) in webMessage) {
                if (value != null) {
                    WebViewCompat.addWebMessageListener(target, key, value.first, value.second)
                } else {
                    WebViewCompat.removeWebMessageListener(target, key)
                }
            }
        }
    }

    override fun hasWebViewBuilder() = (
        downloadListener
            ?: findListener
            ?: horizontalScrollbarOverlay
            ?: initialScale
            ?: scrollBarStyle
            ?: verticalScrollbarOverlay
        ).let { it != null || webMessage.isNotEmpty() }
}
