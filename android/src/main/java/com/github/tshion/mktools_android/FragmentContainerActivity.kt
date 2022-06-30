package com.github.tshion.mktools_android

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

/**
 * Hosts [Fragment].
 */
public abstract class FragmentContainerActivity : AppCompatActivity() {

    private var _fragmentContainerView: FragmentContainerView? = null
    protected val fragmentContainerView: FragmentContainerView
        get() = _fragmentContainerView!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val containerId = ViewCompat.generateViewId()
        _fragmentContainerView = FragmentContainerView(this@FragmentContainerActivity).apply {
            id = containerId
            layoutParams = LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }

        setContentView(fragmentContainerView)
        setupFragment(containerId, supportFragmentManager)
    }


    /**
     * Sets [Fragment].
     *
     * @param id Id of [FragmentContainerView].
     * @param fragmentManager [FragmentManager].
     */
    protected abstract fun setupFragment(
        @IdRes id: Int,
        fragmentManager: FragmentManager,
    )
}
