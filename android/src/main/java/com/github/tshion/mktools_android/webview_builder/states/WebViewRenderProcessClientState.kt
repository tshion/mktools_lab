package com.github.tshion.mktools_android.webview_builder.states

import android.webkit.WebView
import androidx.webkit.WebViewRenderProcess
import androidx.webkit.WebViewRenderProcessClient
import com.github.tshion.mktools_android.webview_builder.aliases.MktBiConsumer

/**
 * State of [androidx.webkit.WebViewRenderProcessClient].
 */
internal class WebViewRenderProcessClientState {

    var onRenderProcessResponsive: MktBiConsumer<WebView, WebViewRenderProcess?>? = null

    var onRenderProcessUnresponsive: MktBiConsumer<WebView, WebViewRenderProcess?>? = null


    fun create() = object : WebViewRenderProcessClient() {
        override fun onRenderProcessResponsive(view: WebView, renderer: WebViewRenderProcess?) {
            onRenderProcessResponsive?.invoke(view, renderer)
        }

        override fun onRenderProcessUnresponsive(view: WebView, renderer: WebViewRenderProcess?) {
            onRenderProcessUnresponsive?.invoke(view, renderer)
        }
    }
}
