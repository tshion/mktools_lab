package com.github.tshion.mktools_android.webview_builder.annotations

import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

/**
 * Wraps WebSettings.CacheMode annotation.
 *
 * * [WebSettings.LOAD_CACHE_ELSE_NETWORK]
 * * [WebSettings.LOAD_CACHE_ONLY]
 * * [WebSettings.LOAD_DEFAULT]
 * * [WebSettings.LOAD_NO_CACHE]
 * * [WebSettings.LOAD_NORMAL]
 */
@IntDef(
    LOAD_CACHE_ELSE_NETWORK,
    LOAD_CACHE_ONLY,
    LOAD_DEFAULT,
    LOAD_NO_CACHE,
    LOAD_NORMAL,
)
@Retention(AnnotationRetention.SOURCE)
annotation class MktCacheMode
