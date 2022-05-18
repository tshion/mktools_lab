package com.github.tshion.mktools_android.webview_builder2.proxies

import android.webkit.WebView
import androidx.webkit.WebViewRenderProcess
import androidx.webkit.WebViewRenderProcessClient
import com.github.tshion.mktools_android.webview_builder.aliases.MktBiConsumer
import com.github.tshion.mktools_android.webview_builder2.contracts.WebViewRenderProcessClientBuilderContract

/**
 * Proxy of [androidx.webkit.WebViewRenderProcessClient].
 */
internal class WebViewRenderProcessClientProxy : WebViewRenderProcessClientBuilderContract {

    private var onRenderProcessResponsive: MktBiConsumer<WebView, WebViewRenderProcess?>? = null

    private var onRenderProcessUnresponsive: MktBiConsumer<WebView, WebViewRenderProcess?>? = null


    override fun onRenderProcessResponsive(
        fx: MktBiConsumer<WebView, WebViewRenderProcess?>
    ) = apply { onRenderProcessResponsive = fx }

    override fun onRenderProcessUnresponsive(
        fx: MktBiConsumer<WebView, WebViewRenderProcess?>
    ) = apply { onRenderProcessUnresponsive = fx }


    override fun buildWebViewRenderProcessClientBuilder() = object : WebViewRenderProcessClient() {
        override fun onRenderProcessResponsive(view: WebView, renderer: WebViewRenderProcess?) {
            onRenderProcessResponsive?.invoke(view, renderer)
        }

        override fun onRenderProcessUnresponsive(view: WebView, renderer: WebViewRenderProcess?) {
            onRenderProcessUnresponsive?.invoke(view, renderer)
        }
    }

    override fun canBuildWebViewRenderProcessClientBuilder() = (
        onRenderProcessResponsive
            ?: onRenderProcessUnresponsive
        ).let { it != null }
}
