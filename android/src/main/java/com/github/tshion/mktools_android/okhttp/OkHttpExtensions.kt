package com.github.tshion.mktools_android.okhttp

import com.github.tshion.mktools_android.constants.HttpRequestHeader
import com.github.tshion.mktools_android.constants.HttpResponseHeader
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Executes [Call] asynchronously.
 */
suspend fun Call.await() = suspendCancellableCoroutine<Response> { continuation ->
    continuation.invokeOnCancellation {
        cancel()
    }

    enqueue(object : Callback {
        override fun onResponse(call: Call, response: Response) {
            continuation.resume(response)
        }

        override fun onFailure(call: Call, e: IOException) {
            continuation.resumeWithException(e)
        }
    })
}

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

fun Response.header(
    type: HttpResponseHeader,
    defaultValue: String? = null,
) = header(type.name, defaultValue)

fun Response.headers(
    type: HttpResponseHeader,
) = headers(type.name)
