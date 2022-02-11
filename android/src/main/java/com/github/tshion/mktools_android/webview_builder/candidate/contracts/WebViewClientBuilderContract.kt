package com.github.tshion.mktools_android.webview_builder.candidate.contracts

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.webkit.WebResourceErrorCompat
import com.github.tshion.mktools_android.webview_builder.candidate.aliases.*

/**
 * Defines [WebViewClient] build rule.
 */
interface WebViewClientBuilderContract {

    /** @see WebViewClient.doUpdateVisitedHistory */
    fun doUpdateVisitedHistory(fx: MktBiObjBooleanConsumer<WebView?, String?>): WebViewClientBuilderContract

    /** @see WebViewClient.onFormResubmission */
    fun onFormResubmission(fx: MktTriConsumer<WebView?, Message?, Message?>): WebViewClientBuilderContract

    /** @see WebViewClient.onLoadResource */
    fun onLoadResource(fx: MktBiConsumer<WebView?, String?>): WebViewClientBuilderContract

    /** @see WebViewClient.onPageCommitVisible */
    @RequiresApi(Build.VERSION_CODES.M)
    fun onPageCommitVisible(fx: MktBiConsumer<WebView?, String?>): WebViewClientBuilderContract

    /** @see WebViewClient.onPageFinished */
    fun onPageFinished(fx: MktBiConsumer<WebView?, String?>): WebViewClientBuilderContract

    /** @see WebViewClient.onPageStarted */
    fun onPageStarted(fx: MktTriConsumer<WebView?, String?, Bitmap?>): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedClientCertRequest */
    fun onReceivedClientCertRequest(fx: MktBiConsumer<WebView?, ClientCertRequest?>): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedError */
    @Deprecated("Deprecated in API level 23")
    fun onReceivedError(fx: MktOnReceivedErrorConsumer): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedError */
    @RequiresApi(Build.VERSION_CODES.M)
    fun onReceivedError(fx: MktTriConsumer<WebView?, WebResourceRequest?, WebResourceErrorCompat?>): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedHttpAuthRequest */
    fun onReceivedHttpAuthRequest(fx: MktOnReceivedHttpAuthRequestConsumer): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedHttpError */
    @RequiresApi(Build.VERSION_CODES.M)
    fun onReceivedHttpError(fx: MktTriConsumer<WebView?, WebResourceRequest?, WebResourceResponse?>): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedLoginRequest */
    fun onReceivedLoginRequest(fx: MktOnReceivedLoginRequestConsumer): WebViewClientBuilderContract

    /** @see WebViewClient.onReceivedSslError */
    fun onReceivedSslError(fx: MktTriConsumer<WebView?, SslErrorHandler?, SslError?>): WebViewClientBuilderContract

    /** @see WebViewClient.onRenderProcessGone */
    @RequiresApi(Build.VERSION_CODES.O)
    fun onRenderProcessGone(fx: MktBiPredicate<WebView?, RenderProcessGoneDetail?>): WebViewClientBuilderContract

    /** @see WebViewClient.onSafeBrowsingHit */
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    fun onSafeBrowsingHit(fx: MktOnSafeBrowsingHitConsumer): WebViewClientBuilderContract

    /** @see WebViewClient.onScaleChanged */
    fun onScaleChanged(fx: MktObjBiFloatConsumer<WebView?>): WebViewClientBuilderContract

    /** @see WebViewClient.onTooManyRedirects */
    @Deprecated("Deprecated in API level 15")
    fun onTooManyRedirects(fx: MktTriConsumer<WebView?, Message?, Message?>): WebViewClientBuilderContract

    /** @see WebViewClient.onUnhandledKeyEvent */
    @Deprecated("Deprecated in API level 21")
    fun onUnhandledKeyEvent(fx: MktBiConsumer<WebView?, KeyEvent?>): WebViewClientBuilderContract

    /** @see WebViewClient.shouldInterceptRequest */
    fun shouldInterceptRequest(fx: MktBiFunction<WebView?, WebResourceRequest?, WebResourceResponse?>): WebViewClientBuilderContract

    /** @see WebViewClient.shouldInterceptRequest */
    @Deprecated("Deprecated in API level 21")
    fun shouldInterceptRequestDeprecated(fx: MktBiFunction<WebView?, String?, WebResourceResponse?>): WebViewClientBuilderContract

    /** @see WebViewClient.shouldOverrideKeyEvent */
    fun shouldOverrideKeyEvent(fx: MktBiPredicate<WebView?, KeyEvent?>): WebViewClientBuilderContract

    /** @see WebViewClient.shouldOverrideUrlLoading */
    @RequiresApi(Build.VERSION_CODES.N)
    fun shouldOverrideUrlLoading(fx: MktBiPredicate<WebView?, WebResourceRequest?>): WebViewClientBuilderContract

    /** @see WebViewClient.shouldOverrideUrlLoading */
    @Deprecated("Deprecated in API level 24")
    fun shouldOverrideUrlLoadingDeprecated(fx: MktBiPredicate<WebView?, String?>): WebViewClientBuilderContract
}
