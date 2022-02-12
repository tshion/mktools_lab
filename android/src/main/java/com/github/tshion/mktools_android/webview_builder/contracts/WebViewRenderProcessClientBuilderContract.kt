package com.github.tshion.mktools_android.webview_builder.contracts

import android.webkit.WebView
import androidx.webkit.WebViewRenderProcess
import com.github.tshion.mktools_android.webview_builder.aliases.MktBiConsumer

/**
 * Defines [androidx.webkit.WebViewRenderProcessClient] build rule.
 */
interface WebViewRenderProcessClientBuilderContract {

    /** @see androidx.webkit.WebViewRenderProcessClient.onRenderProcessResponsive */
    fun onRenderProcessResponsive(fx: MktBiConsumer<WebView, WebViewRenderProcess?>): WebViewRenderProcessClientBuilderContract

    /** @see androidx.webkit.WebViewRenderProcessClient.onRenderProcessUnresponsive */
    fun onRenderProcessUnresponsive(fx: MktBiConsumer<WebView, WebViewRenderProcess?>): WebViewRenderProcessClientBuilderContract
}
