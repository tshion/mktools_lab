package com.github.tshion.mktools_android.webview_builder.annotations

import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

/**
 * Defines MixedContentMode.
 *
 * * [WebSettings.MIXED_CONTENT_ALWAYS_ALLOW]
 * * [WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE]
 * * [WebSettings.MIXED_CONTENT_NEVER_ALLOW]
 */
@IntDef(
    MIXED_CONTENT_ALWAYS_ALLOW,
    MIXED_CONTENT_COMPATIBILITY_MODE,
    MIXED_CONTENT_NEVER_ALLOW
)
@Retention(AnnotationRetention.SOURCE)
annotation class MktMixedContentMode
