@file:JvmName("OkHttpExtensions")
@file:JvmMultifileClass

package com.github.tshion.mktools_android.okhttp

import com.github.tshion.mktools_android.constants.HttpResponseHeader
import okhttp3.Response

@JvmOverloads
fun Response.header(
    type: HttpResponseHeader,
    defaultValue: String? = null,
) = header(type.name, defaultValue)

fun Response.headers(
    type: HttpResponseHeader,
) = headers(type.name)
