package com.github.tshion.mktools_android.okhttp

import okhttp3.Request


/**
 * ヘッダー項目の追加
 * @receiver OkHttp のリクエストビルダー
 * @param type ヘッダー項目
 * @param value 設定値
 */
fun Request.Builder.addHeader(type: HttpRequestMultipleHeaders, value: String) {
    addHeader(type.value, value)
}

/**
 * ヘッダー項目の全削除
 * @receiver OkHttp のリクエストビルダー
 * @param type ヘッダー項目
 */
fun Request.Builder.removeAllHeader(type: HttpRequestMultipleHeaders) {
    removeHeader(type.value)
}

/**
 * ヘッダー項目の削除
 * @receiver OkHttp のリクエストビルダー
 * @param type ヘッダー項目
 */
fun Request.Builder.removeHeader(type: HttpRequestHeaders) {
    removeHeader(type.value)
}

/**
 * ヘッダー項目の設定
 * @receiver OkHttp のリクエストビルダー
 * @param type ヘッダー項目
 * @param value 設定値
 */
fun Request.Builder.setHeader(type: HttpRequestHeaders, value: String) {
    header(type.value, value)
}
