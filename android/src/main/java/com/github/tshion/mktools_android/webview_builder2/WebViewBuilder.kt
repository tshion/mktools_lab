package com.github.tshion.mktools_android.webview_builder2

import android.webkit.WebView
import androidx.webkit.WebViewClientCompat
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewFeature
import androidx.webkit.WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE
import com.github.tshion.mktools_android.webview_builder2.contracts.*
import com.github.tshion.mktools_android.webview_builder2.proxies.*
import java.util.concurrent.Executor

/**
 * Builder for WebView.
 */
class WebViewBuilder(
    private val webChromeClientProxy: WebChromeClientBuilderContract = WebChromeClientProxy(),
    private val webSettingsProxy: WebSettingsBuilderContract = WebSettingsProxy(),
    private val webViewClientCompatProxy: WebViewClientCompatBuilderContract = WebViewClientCompatProxy(),
    private val webViewProxy: WebViewBuilderContract = WebViewProxy(),
    private val webViewRenderProcessClientProxy: WebViewRenderProcessClientBuilderContract = WebViewRenderProcessClientProxy(),
) : WebChromeClientBuilderContract by webChromeClientProxy,
    WebSettingsBuilderContract by webSettingsProxy,
    WebViewBuilderContract by webViewProxy,
    WebViewClientCompatBuilderContract by webViewClientCompatProxy,
    WebViewRenderProcessClientBuilderContract by webViewRenderProcessClientProxy {

    /**
     * Reflects builder's settings.
     */
    fun into(
        target: WebView,
        executor: Executor? = null,
        shouldHandleHistory: Boolean = true,
    ): WebView {
        if (canBuildWebChromeClientBuilder()) {
            target.webChromeClient = buildWebChromeClientBuilder()
        }

        if (hasWebSettingsBuilder()) {
            applyWebSettingsBuilder(target.settings)
        }

        if (hasWebViewBuilder()) {
            applyWebViewBuilder(target)
        }

        when {
            canBuildWebViewClientCompatBuilder() -> buildWebViewClientCompatBuilder()
            shouldHandleHistory -> WebViewClientCompat()
            else -> null
        }?.also { target.webViewClient = it }

        if (canBuildWebViewRenderProcessClientBuilder()
            && WebViewFeature.isFeatureSupported(WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE)
        ) {
            val client = buildWebViewRenderProcessClientBuilder()
            if (executor != null) {
                WebViewCompat.setWebViewRenderProcessClient(target, executor, client)
            } else {
                WebViewCompat.setWebViewRenderProcessClient(target, client)
            }
        }
        return target
    }
}
