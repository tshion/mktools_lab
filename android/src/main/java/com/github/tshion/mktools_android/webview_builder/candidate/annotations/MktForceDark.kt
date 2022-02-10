package com.github.tshion.mktools_android.webview_builder.candidate.annotations

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi

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
@RequiresApi(Build.VERSION_CODES.Q)
@Retention(AnnotationRetention.SOURCE)
annotation class MktForceDark
