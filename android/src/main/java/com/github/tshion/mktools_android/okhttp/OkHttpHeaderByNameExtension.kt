package com.github.tshion.mktools_android.okhttp

import com.google.common.net.HttpHeaders
import okhttp3.Request

/**
 * Accept の追加
 * @receiver OkHttp のリクエストビルダー
 * @param value 設定値
 */
fun Request.Builder.addAccept(value: String) {
    addHeader(HttpHeaders.ACCEPT, value)
}

/**
 * Accept の全削除
 * @receiver OkHttp のリクエストビルダー
 */
fun Request.Builder.removeAllAccept() {
    removeHeader(HttpHeaders.ACCEPT)
}

/**
 * User-Agent の削除
 * @receiver OkHttp のリクエストビルダー
 */
fun Request.Builder.removeUserAgent() {
    removeHeader(HttpHeaders.USER_AGENT)
}

/**
 * User-Agent の設定
 * @receiver OkHttp のリクエストビルダー
 * @param value 設定値
 */
fun Request.Builder.setUserAgent(value: String) {
    header(HttpHeaders.USER_AGENT, value)
}
