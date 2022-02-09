package com.github.tshion.mktools_android.webview_builder.inner

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.webkit.SafeBrowsingResponseCompat
import androidx.webkit.WebResourceErrorCompat

interface WebViewClientContract {

    /** @see WebViewClient.doUpdateVisitedHistory */
    fun doUpdateVisitedHistory(callback: ((view: WebView?, url: String?, isReload: Boolean) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onFormResubmission */
    fun onFormResubmission(callback: ((view: WebView?, dontResend: Message?, resend: Message?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onLoadResource */
    fun onLoadResource(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageCommitVisible */
    fun onPageCommitVisible(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageFinished */
    fun onPageFinished(callback: ((view: WebView?, url: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onPageStarted */
    fun onPageStarted(callback: ((view: WebView?, url: String?, favicon: Bitmap?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedClientCertRequest */
    fun onReceivedClientCertRequest(callback: ((view: WebView?, request: ClientCertRequest?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedError */
    fun onReceivedError(callback: ((view: WebView, request: WebResourceRequest, error: WebResourceErrorCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    fun onReceivedHttpAuthRequest(callback: ((view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedHttpError */
    fun onReceivedHttpError(callback: ((view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedLoginRequest */
    fun onReceivedLoginRequest(callback: ((view: WebView?, realm: String?, account: String?, args: String?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onReceivedSslError */
    fun onReceivedSslError(callback: ((view: WebView?, handler: SslErrorHandler?, error: SslError?) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onRenderProcessGone */
    fun onRenderProcessGone(callback: ((view: WebView?, detail: RenderProcessGoneDetail?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.onSafeBrowsingHit */
    fun onSafeBrowsingHit(callback: ((view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.onScaleChanged */
    fun onScaleChanged(callback: ((view: WebView?, oldScale: Float, newScale: Float) -> Unit)?): WebViewClientContract

    /** @see WebViewClient.shouldInterceptRequest */
    fun shouldInterceptRequest(callback: ((view: WebView?, request: WebResourceRequest?) -> WebResourceResponse?)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideKeyEvent */
    fun shouldOverrideKeyEvent(callback: ((view: WebView?, event: KeyEvent?) -> Boolean)?): WebViewClientContract

    /** @see WebViewClient.shouldOverrideUrlLoading */
    fun shouldOverrideUrlLoading(callback: ((view: WebView?, request: WebResourceRequest?) -> Boolean)?): WebViewClientContract
}
