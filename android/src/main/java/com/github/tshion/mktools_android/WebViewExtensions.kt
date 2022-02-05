@file:JvmName("WebViewExtensions")

package com.github.tshion.mktools_android

import android.view.ViewGroup
import android.webkit.WebView

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
