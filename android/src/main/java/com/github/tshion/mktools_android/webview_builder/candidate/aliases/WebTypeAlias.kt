package com.github.tshion.mktools_android.webview_builder.candidate.aliases

import android.net.Uri
import android.os.Message
import android.webkit.*
import android.webkit.WebChromeClient.FileChooserParams
import androidx.webkit.SafeBrowsingResponseCompat

internal typealias MktOnCreateWindowPredicate = (view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?) -> Boolean
internal typealias MktOnJsPredicate = (view: WebView?, url: String?, message: String?, result: JsResult?) -> Boolean
internal typealias MktOnJsPromptPredicate = (view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?) -> Boolean
internal typealias MktOnShowFileChooserPredicate = (webView: WebView?, filePathCallback: ValueCallback<Array<Uri?>?>?, fileChooserParams: FileChooserParams?) -> Boolean
