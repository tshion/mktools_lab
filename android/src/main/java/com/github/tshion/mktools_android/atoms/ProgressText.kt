package com.github.tshion.mktools_android.atoms

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.IntRange
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.getDrawableOrThrow
import androidx.core.content.res.getIntOrThrow
import androidx.core.content.withStyledAttributes
import com.github.tshion.mktools_android.R

class ProgressText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = R.style.MkToolsAtomProgressText,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    @IntRange(from = 0, to = 100)
    var progress: Int = 0
        set(value) {
            "$value%".also { text = it }
            field = value
        }


    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.MkToolsAtomProgressText,
            defStyleAttr,
            defStyleRes,
        ) {
            background = getDrawableOrThrow(R.styleable.MkToolsAtomProgressText_android_background)
            gravity = getIntOrThrow(R.styleable.MkToolsAtomProgressText_android_gravity)
        }
    }
}
