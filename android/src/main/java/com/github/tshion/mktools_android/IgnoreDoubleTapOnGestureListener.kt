package com.github.tshion.mktools_android

import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent

/**
 * Ignores double tap event.
 *
 * @see [android.view.GestureDetector.OnDoubleTapListener.onDoubleTap]
 */
class IgnoreDoubleTapOnGestureListener : SimpleOnGestureListener() {
    override fun onDoubleTap(e: MotionEvent?): Boolean {
        // Ignore always.
        return true
    }
}
