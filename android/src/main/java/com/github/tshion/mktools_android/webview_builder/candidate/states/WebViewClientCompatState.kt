package com.github.tshion.mktools_android.webview_builder.candidate.states

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebViewClientCompat
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*

/**
 * State of [androidx.webkit.WebViewClientCompat].
 */
internal class WebViewClientCompatState {
    var doUpdateVisitedHistory: MktBiObjBooleanConsumer<WebView, String>? = null

    var onFormResubmission: MktTriConsumer<WebView, Message, Message>? = null

    var onLoadResource: MktBiConsumer<WebView, String>? = null

    var onPageCommitVisible: MktBiConsumer<WebView, String>? = null

    var onPageFinished: MktBiConsumer<WebView, String>? = null

    var onPageStarted: MktTriConsumer<WebView, String, Bitmap>? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var onReceivedClientCertRequest: MktBiConsumer<WebView, ClientCertRequest>? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var onReceivedError: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>? = null

    var onReceivedHttpAuthRequest: MktOnReceivedHttpAuthRequestConsumer? = null

    var onReceivedHttpError: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>? =
        null

    var onReceivedLoginRequest: MktOnReceivedLoginRequestConsumer? = null

    var onReceivedSslError: MktTriConsumer<WebView, SslErrorHandler, SslError>? = null

    @RequiresApi(Build.VERSION_CODES.O)
    var onRenderProcessGone: MktBiPredicate<WebView, RenderProcessGoneDetail>? = null

    var onSafeBrowsingHit: MktOnSafeBrowsingHitConsumer? = null

    var onScaleChanged: MktObjBiFloatConsumer<WebView>? = null

    var shouldInterceptRequest: MktBiFunction<WebView, WebResourceRequest, WebResourceResponse?>? =
        null

    var shouldOverrideKeyEvent: MktBiPredicate<WebView, KeyEvent>? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var shouldOverrideUrlLoading: MktBiPredicate<WebView, WebResourceRequest>? = null


    fun create() = object : WebViewClientCompat() {
        override fun doUpdateVisitedHistory(
            view: WebView?,
            url: String?,
            isReload: Boolean
        ) = doUpdateVisitedHistory?.invoke(view!!, url!!, isReload)
            ?: super.doUpdateVisitedHistory(view, url, isReload)

        override fun onFormResubmission(
            view: WebView?,
            dontResend: Message?,
            resend: Message?
        ) = onFormResubmission?.invoke(view!!, dontResend!!, resend!!)
            ?: super.onFormResubmission(view, dontResend, resend)

        override fun onLoadResource(
            view: WebView?,
            url: String?
        ) = onLoadResource?.invoke(view!!, url!!)
            ?: super.onLoadResource(view, url)

        override fun onPageCommitVisible(
            view: WebView,
            url: String
        ) = onPageCommitVisible?.invoke(view, url)
            ?: super.onPageCommitVisible(view, url)

        override fun onPageFinished(
            view: WebView?,
            url: String?
        ) = onPageFinished?.invoke(view!!, url!!)
            ?: super.onPageFinished(view, url)

        override fun onPageStarted(
            view: WebView?,
            url: String?,
            favicon: Bitmap?
        ) = onPageStarted?.invoke(view!!, url!!, favicon!!)
            ?: super.onPageStarted(view, url, favicon)

        override fun onReceivedClientCertRequest(
            view: WebView?,
            request: ClientCertRequest?
        ) = onReceivedClientCertRequest?.invoke(view!!, request!!)
            ?: super.onReceivedClientCertRequest(view, request)

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceErrorCompat
        ) = onReceivedError?.invoke(view, request, error)
            ?: super.onReceivedError(view, request, error)

        override fun onReceivedHttpAuthRequest(
            view: WebView?,
            handler: HttpAuthHandler?,
            host: String?,
            realm: String?
        ) = onReceivedHttpAuthRequest?.invoke(view!!, handler!!, host!!, realm!!)
            ?: super.onReceivedHttpAuthRequest(view, handler, host, realm)

        override fun onReceivedHttpError(
            view: WebView,
            request: WebResourceRequest,
            errorResponse: WebResourceResponse
        ) = onReceivedHttpError?.invoke(view, request, errorResponse)
            ?: super.onReceivedHttpError(view, request, errorResponse)

        override fun onReceivedLoginRequest(
            view: WebView?,
            realm: String?,
            account: String?,
            args: String?
        ) = onReceivedLoginRequest?.invoke(view!!, realm!!, account, args!!)
            ?: super.onReceivedLoginRequest(view, realm, account, args)

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) = onReceivedSslError?.invoke(view!!, handler!!, error!!)
            ?: super.onReceivedSslError(view, handler, error)

        override fun onRenderProcessGone(
            view: WebView?,
            detail: RenderProcessGoneDetail?
        ) = onRenderProcessGone?.invoke(view!!, detail!!)
            ?: super.onRenderProcessGone(view, detail)

        override fun onSafeBrowsingHit(
            view: WebView,
            request: WebResourceRequest,
            threatType: Int,
            callback: SafeBrowsingResponseCompat
        ) = onSafeBrowsingHit?.invoke(view, request, threatType, callback)
            ?: super.onSafeBrowsingHit(view, request, threatType, callback)

        override fun onScaleChanged(
            view: WebView?,
            oldScale: Float,
            newScale: Float
        ) = onScaleChanged?.invoke(view!!, oldScale, newScale)
            ?: super.onScaleChanged(view, oldScale, newScale)

        override fun shouldInterceptRequest(
            view: WebView?,
            request: WebResourceRequest?
        ) = shouldInterceptRequest?.invoke(view!!, request!!)
            ?: super.shouldInterceptRequest(view, request)

        override fun shouldOverrideKeyEvent(
            view: WebView?,
            event: KeyEvent?
        ) = shouldOverrideKeyEvent?.invoke(view!!, event!!)
            ?: super.shouldOverrideKeyEvent(view, event)

        override fun shouldOverrideUrlLoading(
            view: WebView,
            request: WebResourceRequest
        ) = shouldOverrideUrlLoading?.invoke(view, request)
            ?: super.shouldOverrideUrlLoading(view, request)
    }
}
