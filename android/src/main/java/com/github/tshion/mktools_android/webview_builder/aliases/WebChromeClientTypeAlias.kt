package com.github.tshion.mktools_android.webview_builder.aliases

import android.os.Message
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebStorage.QuotaUpdater
import android.webkit.WebView

internal typealias MktOnCreateWindowPredicate = (view: WebView, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message) -> Boolean
internal typealias MktOnExceededDatabaseQuotaConsumer = (String, String, Long, Long, Long, QuotaUpdater) -> Unit
internal typealias MktOnJsPredicate = (view: WebView, url: String, message: String, result: JsResult) -> Boolean
internal typealias MktOnJsPromptPredicate = (view: WebView, url: String, message: String, defaultValue: String, result: JsPromptResult) -> Boolean
