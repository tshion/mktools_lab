package com.github.tshion.mktools_android

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.GestureDetectorCompat

/**
 * Sets the listener to ignore double tap event.
 *
 * @receiver View instance.
 */
@SuppressLint("ClickableViewAccessibility")
public fun View?.setOnSingleTapTouchListener() {
    this ?: return

    val detector = GestureDetectorCompat(this.context, IgnoreDoubleTapOnGestureListener())
    this.setOnTouchListener { _, event ->
        detector.onTouchEvent(event)
    }
}
