package com.github.tshion.mktools_android.webview_builder.annotations

import android.os.Build
import android.webkit.WebView
import android.webkit.WebView.*
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi

/**
 * Defines Renderer Priority.
 *
 * * [WebView.RENDERER_PRIORITY_BOUND]
 * * [WebView.RENDERER_PRIORITY_IMPORTANT]
 * * [WebView.RENDERER_PRIORITY_WAIVED]
 */
@IntDef(
    RENDERER_PRIORITY_BOUND,
    RENDERER_PRIORITY_IMPORTANT,
    RENDERER_PRIORITY_WAIVED
)
@RequiresApi(Build.VERSION_CODES.O)
@Retention(AnnotationRetention.SOURCE)
annotation class MktRendererPriority
