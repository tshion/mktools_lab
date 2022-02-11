package com.github.tshion.mktools_android.webview_builder.candidate

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.webkit.WebResourceErrorCompat
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*
import com.github.tshion.mktools_android.webview_builder.candidate.contracts.WebViewClientCompatBuilderContract
import com.github.tshion.mktools_android.webview_builder.candidate.states.WebViewClientCompatState

/**
 * Builder for WebView.
 */
class WebViewBuilder : WebViewClientCompatBuilderContract {

    private var _stateWebViewClientCompat: WebViewClientCompatState? = null
    private val stateWebViewClientCompat: WebViewClientCompatState
        get() {
            // FIXME: スレッド防御
            if (_stateWebViewClientCompat == null) {
                _stateWebViewClientCompat = WebViewClientCompatState()
            }
            return _stateWebViewClientCompat!!
        }


    // Start overrides [WebViewClientCompatBuilderContract].

    override fun doUpdateVisitedHistory(
        fx: MktBiObjBooleanConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.doUpdateVisitedHistory = fx }

    override fun onFormResubmission(
        fx: MktTriConsumer<WebView, Message, Message>
    ) = apply { stateWebViewClientCompat.onFormResubmission = fx }

    override fun onLoadResource(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onLoadResource = fx }

    override fun onPageCommitVisible(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onPageCommitVisible = fx }

    override fun onPageFinished(
        fx: MktBiConsumer<WebView, String>
    ) = apply { stateWebViewClientCompat.onPageFinished = fx }

    override fun onPageStarted(
        fx: MktTriConsumer<WebView, String, Bitmap>
    ) = apply { stateWebViewClientCompat.onPageStarted = fx }

    override fun onReceivedClientCertRequest(
        fx: MktBiConsumer<WebView, ClientCertRequest>
    ) = apply { stateWebViewClientCompat.onReceivedClientCertRequest = fx }

    override fun onReceivedError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>
    ) = apply { stateWebViewClientCompat.onReceivedError = fx }

    override fun onReceivedHttpAuthRequest(
        fx: MktOnReceivedHttpAuthRequestConsumer
    ) = apply { stateWebViewClientCompat.onReceivedHttpAuthRequest = fx }

    override fun onReceivedHttpError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>
    ) = apply { stateWebViewClientCompat.onReceivedHttpError = fx }

    override fun onReceivedLoginRequest(
        fx: MktOnReceivedLoginRequestConsumer
    ) = apply { stateWebViewClientCompat.onReceivedLoginRequest = fx }

    override fun onReceivedSslError(
        fx: MktTriConsumer<WebView, SslErrorHandler, SslError>
    ) = apply { stateWebViewClientCompat.onReceivedSslError = fx }

    override fun onRenderProcessGone(
        fx: MktBiPredicate<WebView, RenderProcessGoneDetail>
    ) = apply { stateWebViewClientCompat.onRenderProcessGone = fx }

    override fun onSafeBrowsingHit(
        fx: MktOnSafeBrowsingHitConsumer
    ) = apply { stateWebViewClientCompat.onSafeBrowsingHit = fx }

    override fun onScaleChanged(
        fx: MktObjBiFloatConsumer<WebView>
    ) = apply { stateWebViewClientCompat.onScaleChanged = fx }

    override fun onTooManyRedirects(
        fx: MktTriConsumer<WebView, Message, Message>
    ) = this

    override fun onUnhandledKeyEvent(
        fx: MktBiConsumer<WebView, KeyEvent>
    ) = this

    override fun shouldInterceptRequestUntil21(
        fx: MktBiFunction<WebView, String, WebResourceResponse?>
    ) = this

    override fun shouldInterceptRequest(
        fx: MktBiFunction<WebView, WebResourceRequest, WebResourceResponse?>
    ) = apply { stateWebViewClientCompat.shouldInterceptRequest = fx }

    override fun shouldOverrideKeyEvent(
        fx: MktBiPredicate<WebView, KeyEvent>
    ) = apply { stateWebViewClientCompat.shouldOverrideKeyEvent = fx }

    override fun shouldOverrideUrlLoading(
        fx: MktBiPredicate<WebView, WebResourceRequest>
    ) = apply { stateWebViewClientCompat.shouldOverrideUrlLoading = fx }

    // Finish overrides [WebViewClientCompatBuilderContract].
}
