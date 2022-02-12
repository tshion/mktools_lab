package com.github.tshion.mktools_android.webview_builder.states

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

/**
 * State of [WebView] and [androidx.webkit.WebViewCompat].
 */
internal class WebViewState {

    var downloadListener: DownloadListener? = null

    var findListener: FindListener? = null

    var horizontalScrollbarOverlay: Boolean? = null

    @IntRange(from = 0, to = 100)
    var initialScale: Int? = null

    @MktScrollBarStyle
    var scrollBarStyle: Int? = null

    var verticalScrollbarOverlay: Boolean? = null

    var webMessage = ArrayMap<String, Pair<MutableSet<String>, WebMessageListener>?>()


    fun into(target: WebView) {
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
}
