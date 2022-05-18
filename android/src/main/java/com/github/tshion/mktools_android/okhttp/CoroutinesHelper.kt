@file:JvmName("OkHttpExtensions")
@file:JvmMultifileClass

package com.github.tshion.mktools_android.okhttp

import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Executes [Call] asynchronously.
 */
@JvmName("-await") // Prefix with '-' to hide from Java.
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
