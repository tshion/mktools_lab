package com.github.tshion.mktools_android.okhttp

import com.github.tshion.mktools_android.constants.HttpRequestHeader
import okhttp3.Request

/**
 * Accept の追加
 * @receiver OkHttp のリクエストビルダー
 * @param value 設定値
 */
fun Request.Builder.addAccept(value: String) {
    addHeader(HttpRequestHeader.ACCEPT.value, value)
}

/**
 * Accept の全削除
 * @receiver OkHttp のリクエストビルダー
 */
fun Request.Builder.removeAllAccept() {
    removeHeader(HttpRequestHeader.ACCEPT.value)
}

/**
 * User-Agent の削除
 * @receiver OkHttp のリクエストビルダー
 */
fun Request.Builder.removeUserAgent() {
    removeHeader(HttpRequestHeader.USER_AGENT.value)
}

/**
 * User-Agent の設定
 * @receiver OkHttp のリクエストビルダー
 * @param value 設定値
 */
fun Request.Builder.setUserAgent(value: String) {
    header(HttpRequestHeader.USER_AGENT.value, value)
}
