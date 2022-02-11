package com.github.tshion.mktools_android.webview_builder.candidate.aliases

import android.webkit.HttpAuthHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.webkit.SafeBrowsingResponseCompat

internal typealias MktOnReceivedHttpAuthRequestConsumer = (view: WebView, handler: HttpAuthHandler, host: String, realm: String) -> Unit
internal typealias MktOnReceivedLoginRequestConsumer = (view: WebView, realm: String, account: String?, args: String) -> Unit
internal typealias MktOnSafeBrowsingHitConsumer = (view: WebView, request: WebResourceRequest, threatType: Int, callback: SafeBrowsingResponseCompat) -> Unit
