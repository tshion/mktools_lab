@file:JvmName("OkHttpExtensions")
@file:JvmMultifileClass

package com.github.tshion.mktools_android.okhttp

import com.github.tshion.mktools_android.constants.HttpRequestHeader
import okhttp3.Request

fun Request.Builder.addHeader(
    type: HttpRequestHeader,
    value: String,
) = addHeader(type.name, value)

fun Request.Builder.header(
    type: HttpRequestHeader,
    value: String,
) = header(type.name, value)

fun Request.Builder.removeHeader(
    type: HttpRequestHeader,
) = removeHeader(type.name)
