package com.github.tshion.mktools_android

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

/**
 * Hosts [Fragment].
 */
abstract class FragmentContainerActivity : AppCompatActivity() {

    protected lateinit var fragmentContainerView: FragmentContainerView

    /**
     * Id of [FragmentContainerView].
     */
    protected val idContainer: Int by lazy {
        resources.getIdentifier(
            "mktools_fragment_container_activity_root",
            "id",
            packageName
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentContainerView = FragmentContainerView(this@FragmentContainerActivity).apply {
            id = idContainer
            layoutParams = LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }
        setContentView(fragmentContainerView)
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
