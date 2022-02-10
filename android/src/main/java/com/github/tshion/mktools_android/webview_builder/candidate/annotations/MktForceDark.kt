package com.github.tshion.mktools_android.webview_builder.candidate.annotations

import android.annotation.TargetApi
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

/**
 * Wraps WebSettings.ForceDark annotation.
 *
 * * [WebSettings.FORCE_DARK_AUTO]
 * * [WebSettings.FORCE_DARK_OFF]
 * * [WebSettings.FORCE_DARK_ON]
 */
@IntDef(
    FORCE_DARK_AUTO,
    FORCE_DARK_OFF,
    FORCE_DARK_ON
)
@Retention(AnnotationRetention.SOURCE)
@TargetApi(29)
annotation class MktForceDark
