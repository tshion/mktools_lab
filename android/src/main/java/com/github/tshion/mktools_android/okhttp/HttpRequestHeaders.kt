package com.github.tshion.mktools_android.okhttp

import com.google.common.net.HttpHeaders

/**
 * HTTP リクエスト時のヘッダー項目
 * @property value ヘッダー項目名
 */
enum class HttpRequestHeaders(val value: String) {
    UserAgent(HttpHeaders.USER_AGENT),
    ;
}
