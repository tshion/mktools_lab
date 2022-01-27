package com.github.tshion.mktools_android.okhttp

import com.google.common.net.HttpHeaders

/**
 * HTTP リクエスト時の複数設定できるヘッダー項目
 * @property value ヘッダー項目名
 */
enum class HttpRequestMultipleHeaders(val value: String) {
    Accept(HttpHeaders.ACCEPT),
    ;
}
