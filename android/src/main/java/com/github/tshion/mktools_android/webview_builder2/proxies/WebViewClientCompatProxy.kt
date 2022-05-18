package com.github.tshion.mktools_android.webview_builder2.proxies

import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat
import androidx.webkit.WebViewClientCompat
import androidx.webkit.WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS
import androidx.webkit.WebViewFeature.isFeatureSupported
import com.github.tshion.mktools_android.webview_builder.aliases.*
import com.github.tshion.mktools_android.webview_builder2.contracts.WebViewClientCompatBuilderContract

/**
 * Proxy of [androidx.webkit.WebViewClientCompat].
 */
internal class WebViewClientCompatProxy : WebViewClientCompatBuilderContract {

    private var doUpdateVisitedHistory: MktBiObjBooleanConsumer<WebView, String>? = null

    private var onFormResubmission: MktTriConsumer<WebView, Message, Message>? = null

    private var onLoadResource: MktBiConsumer<WebView, String>? = null

    private var onPageCommitVisible: MktBiConsumer<WebView, String>? = null

    private var onPageFinished: MktBiConsumer<WebView, String>? = null

    private var onPageStarted: MktTriConsumer<WebView, String, Bitmap>? = null

    private var onReceivedClientCertRequest: MktBiConsumer<WebView, ClientCertRequest>? = null

    private var onReceivedError: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>? =
        null

    private var onReceivedHttpAuthRequest: MktOnReceivedHttpAuthRequestConsumer? = null

    private var onReceivedHttpError: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>? =
        null

    private var onReceivedLoginRequest: MktOnReceivedLoginRequestConsumer? = null

    private var onReceivedSslError: MktTriConsumer<WebView, SslErrorHandler, SslError>? = null

    private var onRenderProcessGone: MktBiPredicate<WebView, RenderProcessGoneDetail>? = null

    private var onSafeBrowsingHit: MktOnSafeBrowsingHitConsumer? = null

    private var onScaleChanged: MktObjBiFloatConsumer<WebView>? = null

    private var shouldInterceptRequest: MktBiFunction<WebView, WebResourceRequest, WebResourceResponse?>? =
        null

    private var shouldOverrideKeyEvent: MktBiPredicate<WebView, KeyEvent>? = null

    private var shouldOverrideUrlLoading: MktBiPredicate<WebView, WebResourceRequest>? = null


    override fun doUpdateVisitedHistory(
        fx: MktBiObjBooleanConsumer<WebView, String>
    ) = apply { doUpdateVisitedHistory = fx }

    override fun onFormResubmission(
        fx: MktTriConsumer<WebView, Message, Message>
    ) = apply { onFormResubmission = fx }

    override fun onLoadResource(
        fx: MktBiConsumer<WebView, String>
    ) = apply { onLoadResource = fx }

    override fun onPageCommitVisible(
        fx: MktBiConsumer<WebView, String>
    ) = apply { onPageCommitVisible = fx }

    override fun onPageFinished(
        fx: MktBiConsumer<WebView, String>
    ) = apply { onPageFinished = fx }

    override fun onPageStarted(
        fx: MktTriConsumer<WebView, String, Bitmap>
    ) = apply { onPageStarted = fx }

    override fun onReceivedClientCertRequest(
        fx: MktBiConsumer<WebView, ClientCertRequest>
    ) = apply { onReceivedClientCertRequest = fx }

    override fun onReceivedError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>
    ) = apply { onReceivedError = fx }

    override fun onReceivedHttpAuthRequest(
        fx: MktOnReceivedHttpAuthRequestConsumer
    ) = apply { onReceivedHttpAuthRequest = fx }

    override fun onReceivedHttpError(
        fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>
    ) = apply { onReceivedHttpError = fx }

    override fun onReceivedLoginRequest(
        fx: MktOnReceivedLoginRequestConsumer
    ) = apply { onReceivedLoginRequest = fx }

    override fun onReceivedSslError(
        fx: MktTriConsumer<WebView, SslErrorHandler, SslError>
    ) = apply { onReceivedSslError = fx }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRenderProcessGone(
        fx: MktBiPredicate<WebView, RenderProcessGoneDetail>
    ) = apply { onRenderProcessGone = fx }

    override fun onSafeBrowsingHit(
        fx: MktOnSafeBrowsingHitConsumer
    ) = apply { onSafeBrowsingHit = fx }

    override fun onScaleChanged(
        fx: MktObjBiFloatConsumer<WebView>
    ) = apply { onScaleChanged = fx }

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
    ) = apply { shouldInterceptRequest = fx }

    override fun shouldOverrideKeyEvent(
        fx: MktBiPredicate<WebView, KeyEvent>
    ) = apply { shouldOverrideKeyEvent = fx }

    override fun shouldOverrideUrlLoading(
        fx: MktBiPredicate<WebView, WebResourceRequest>
    ) = apply { shouldOverrideUrlLoading = fx }


    override fun buildWebViewClientCompatBuilder() = object : WebViewClientCompat() {
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

        /**
         * [WebViewClientCompat.shouldOverrideUrlLoading] で取り扱えない場合
         */
        @Suppress("deprecation") // for invoking the old shouldOverrideUrlLoading.
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            val action = shouldOverrideUrlLoading
            return if (!isFeatureSupported(SHOULD_OVERRIDE_WITH_REDIRECTS) && action != null) {
                action.invoke(
                    view,
                    object : WebResourceRequest {
                        override fun getUrl() = Uri.parse(url)

                        override fun isForMainFrame(): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun isRedirect(): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun hasGesture(): Boolean {
                            TODO("Not yet implemented")
                        }

                        override fun getMethod(): String {
                            TODO("Not yet implemented")
                        }

                        override fun getRequestHeaders(): MutableMap<String, String> {
                            TODO("Not yet implemented")
                        }
                    }
                )
            } else {
                super.shouldOverrideUrlLoading(view, url)
            }
        }

        override fun shouldOverrideUrlLoading(
            view: WebView,
            request: WebResourceRequest
        ) = shouldOverrideUrlLoading?.invoke(view, request)
            ?: super.shouldOverrideUrlLoading(view, request)
    }

    override fun canBuildWebViewClientCompatBuilder() = (
        doUpdateVisitedHistory
            ?: onFormResubmission
            ?: onLoadResource
            ?: onPageCommitVisible
            ?: onPageFinished
            ?: onPageStarted
            ?: onReceivedClientCertRequest
            ?: onReceivedError
            ?: onReceivedHttpAuthRequest
            ?: onReceivedHttpError
            ?: onReceivedLoginRequest
            ?: onReceivedSslError
            ?: onRenderProcessGone
            ?: onSafeBrowsingHit
            ?: onScaleChanged
            ?: shouldInterceptRequest
            ?: shouldOverrideKeyEvent
            ?: shouldOverrideUrlLoading
        ).let { it != null }
}
