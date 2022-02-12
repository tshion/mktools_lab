package com.github.tshion.mktools_android.webview_builder.annotations

import android.view.View
import android.view.View.*
import androidx.annotation.IntDef

/**
 * Wraps View.LayerType annotation.
 *
 * * [View.LAYER_TYPE_HARDWARE]
 * * [View.LAYER_TYPE_NONE]
 * * [View.LAYER_TYPE_SOFTWARE]
 */
@IntDef(
    LAYER_TYPE_HARDWARE,
    LAYER_TYPE_NONE,
    LAYER_TYPE_SOFTWARE,
)
@Retention(AnnotationRetention.SOURCE)
annotation class MktLayerType
