package com.github.tshion.mktools_android

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

/**
 * Hosts [FragmentContainerView].
 */
abstract class FragmentContainerActivity : AppCompatActivity() {

    /**
     * Id of [FragmentContainerView].
     */
    @IdRes
    protected val idContainer: Int = resources.getIdentifier(
        "container",
        "id",
        packageName
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FragmentContainerView(this@FragmentContainerActivity).apply {
            id = idContainer
            layoutParams = LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }.also { setContentView(it) }
        setupFragment(idContainer, supportFragmentManager)
    }


    /**
     * Sets [Fragment].
     *
     * @param id Id of [FragmentContainerView].
     * @param fragmentManager [FragmentManager].
     */
    protected abstract fun setupFragment(
        id: Int,
        fragmentManager: FragmentManager,
    )
}
