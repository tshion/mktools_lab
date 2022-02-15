package com.github.tshion.mktools_android.okhttp

import com.github.tshion.mktools_android.constants.HttpRequestHeader

/**
 * HTTP リクエスト時のヘッダー項目
 * @property value ヘッダー項目名
 */
enum class HttpRequestHeaders(val value: String) {
    UserAgent(HttpRequestHeader.USER_AGENT.value),
    ;
}
