package com.github.tshion.mktools_android.webview_builder.candidate.contracts

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.annotation.UiThread
import androidx.webkit.WebResourceErrorCompat
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*

/**
 * Defines [androidx.webkit.WebViewClientCompat] build rule.
 */
interface WebViewClientCompatBuilderContract {

    /** @see WebViewClient.doUpdateVisitedHistory */
    fun doUpdateVisitedHistory(fx: MktBiObjBooleanConsumer<WebView, String>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onFormResubmission */
    fun onFormResubmission(fx: MktTriConsumer<WebView, Message, Message>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onLoadResource */
    fun onLoadResource(fx: MktBiConsumer<WebView, String>): WebViewClientCompatBuilderContract

    /** @see androidx.webkit.WebViewClientCompat.onPageCommitVisible */
    fun onPageCommitVisible(@UiThread fx: MktBiConsumer<WebView, String>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onPageFinished */
    fun onPageFinished(fx: MktBiConsumer<WebView, String>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onPageStarted */
    fun onPageStarted(fx: MktTriConsumer<WebView, String, Bitmap>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onReceivedClientCertRequest */
    fun onReceivedClientCertRequest(fx: MktBiConsumer<WebView, ClientCertRequest>): WebViewClientCompatBuilderContract

    /** @see androidx.webkit.WebViewClientCompat.onReceivedError */
    fun onReceivedError(@UiThread fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceErrorCompat>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    fun onReceivedHttpAuthRequest(fx: MktOnReceivedHttpAuthRequestConsumer): WebViewClientCompatBuilderContract

    /** @see androidx.webkit.WebViewClientCompat.onReceivedHttpError */
    fun onReceivedHttpError(@UiThread fx: MktTriConsumer<WebView, WebResourceRequest, WebResourceResponse>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onReceivedLoginRequest */
    fun onReceivedLoginRequest(fx: MktOnReceivedLoginRequestConsumer): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onReceivedSslError */
    fun onReceivedSslError(fx: MktTriConsumer<WebView, SslErrorHandler, SslError>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onRenderProcessGone */
    @RequiresApi(Build.VERSION_CODES.O)
    fun onRenderProcessGone(fx: MktBiPredicate<WebView, RenderProcessGoneDetail>): WebViewClientCompatBuilderContract

    /** @see androidx.webkit.WebViewClientCompat.onSafeBrowsingHit */
    fun onSafeBrowsingHit(@UiThread fx: MktOnSafeBrowsingHitConsumer): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onScaleChanged */
    fun onScaleChanged(fx: MktObjBiFloatConsumer<WebView>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onTooManyRedirects */
    @Deprecated("Deprecated in API level 15")
    fun onTooManyRedirects(fx: MktTriConsumer<WebView, Message, Message>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.onUnhandledKeyEvent */
    @Deprecated("Deprecated in API level 21")
    fun onUnhandledKeyEvent(fx: MktBiConsumer<WebView, KeyEvent>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.shouldInterceptRequest */
    @Deprecated("Deprecated in API level 21", ReplaceWith("shouldInterceptRequest"))
    fun shouldInterceptRequestUntil21(fx: MktBiFunction<WebView, String, WebResourceResponse?>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.shouldInterceptRequest */
    fun shouldInterceptRequest(fx: MktBiFunction<WebView, WebResourceRequest, WebResourceResponse?>): WebViewClientCompatBuilderContract

    /** @see WebViewClient.shouldOverrideKeyEvent */
    fun shouldOverrideKeyEvent(fx: MktBiPredicate<WebView, KeyEvent>): WebViewClientCompatBuilderContract

    /** @see androidx.webkit.WebViewClientCompat.shouldOverrideUrlLoading */
    fun shouldOverrideUrlLoading(@UiThread fx: MktBiPredicate<WebView, WebResourceRequest>): WebViewClientCompatBuilderContract
}
