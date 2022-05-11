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
 * Hosts [Fragment].
 */
abstract class FragmentContainerActivity : AppCompatActivity() {

    @IdRes
    private var _fragmentContainerId: Int? = null

    protected val fragmentContainerId: Int
        get() = _fragmentContainerId!!


    private var _fragmentContainerView: FragmentContainerView? = null

    protected val fragmentContainerView: FragmentContainerView
        get() = _fragmentContainerView!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _fragmentContainerId = resources.getIdentifier(
            "fragment_container_activity_root",
            "id",
            packageName
        )
        _fragmentContainerView = FragmentContainerView(this@FragmentContainerActivity).apply {
            id = fragmentContainerId
            layoutParams = LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }

        setContentView(fragmentContainerView)
        setupFragment(fragmentContainerId, supportFragmentManager)
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
