package com.github.tshion.mktools_android.webview_builder2.contracts

import android.webkit.WebView
import androidx.webkit.WebViewRenderProcess
import androidx.webkit.WebViewRenderProcessClient
import com.github.tshion.mktools_android.webview_builder.aliases.MktBiConsumer

/**
 * Defines [androidx.webkit.WebViewRenderProcessClient] build rule.
 */
interface WebViewRenderProcessClientBuilderContract {

    /** @see androidx.webkit.WebViewRenderProcessClient.onRenderProcessResponsive */
    fun onRenderProcessResponsive(fx: MktBiConsumer<WebView, WebViewRenderProcess?>): WebViewRenderProcessClientBuilderContract

    /** @see androidx.webkit.WebViewRenderProcessClient.onRenderProcessUnresponsive */
    fun onRenderProcessUnresponsive(fx: MktBiConsumer<WebView, WebViewRenderProcess?>): WebViewRenderProcessClientBuilderContract


    fun buildWebViewRenderProcessClientBuilder(): WebViewRenderProcessClient

    fun canBuildWebViewRenderProcessClientBuilder(): Boolean
}
