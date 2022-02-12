@file:JvmName("WebViewExtensions")

package com.github.tshion.mktools_android

import android.view.ViewGroup
import android.webkit.WebView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

/**
 * Handles [WebView]'s lifecycle events.
 *
 * * To avoid [Device and Network Abuse - Play Console Help](https://support.google.com/googleplay/android-developer/answer/9888379).
 *     * When "onResume", calls [WebView.onResume]
 *     * When "onPause", calls [WebView.onPause]
 * * To destroys the internal state of [WebView].
 *     * When "onDestroy", calls [WebView.destroy]
 *
 * @receiver WebView instance.
 * @param lifecycleOwner
 * @see [android.webkit.WebViewFragment]
 */
fun WebView?.handleLifecycleEvents(lifecycleOwner: LifecycleOwner) {
    val ref = this?.let { WeakReference(it) } ?: return
    lifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onResume(owner: LifecycleOwner) {
            ref.get()?.onResume()
            super.onResume(owner)
        }

        override fun onPause(owner: LifecycleOwner) {
            super.onPause(owner)
            ref.get()?.onPause()
        }

        override fun onDestroy(owner: LifecycleOwner) {
            ref.get()?.throwAway()
            super.onDestroy(owner)
        }
    })
}

/**
 * Destroys WebView.
 *
 * * [Managing WebView objects | Android Developers](https://developer.android.com/guide/webapps/managing-webview#termination-handle)
 * * [WebView | Android Developers](https://developer.android.com/reference/android/webkit/WebView#destroy())
 *
 * @receiver WebView instance.
 * @see [android.webkit.WebViewFragment.onDestroy]
 */
fun WebView?.throwAway() {
    this ?: return
    stopLoading()
    (parent as? ViewGroup)?.removeView(this)
    destroy()
}
