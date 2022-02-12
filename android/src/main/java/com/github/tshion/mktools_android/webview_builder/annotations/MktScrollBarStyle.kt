package com.github.tshion.mktools_android.webview_builder.annotations

import android.view.View
import android.view.View.*
import androidx.annotation.IntDef

/**
 * Wraps View.ScrollBarStyle annotation.
 *
 * * [View.SCROLLBARS_INSIDE_INSET]
 * * [View.SCROLLBARS_INSIDE_OVERLAY]
 * * [View.SCROLLBARS_OUTSIDE_INSET]
 * * [View.SCROLLBARS_OUTSIDE_OVERLAY]
 */
@IntDef(
    SCROLLBARS_INSIDE_INSET,
    SCROLLBARS_INSIDE_OVERLAY,
    SCROLLBARS_OUTSIDE_INSET,
    SCROLLBARS_OUTSIDE_OVERLAY
)
@Retention(AnnotationRetention.SOURCE)
annotation class MktScrollBarStyle
