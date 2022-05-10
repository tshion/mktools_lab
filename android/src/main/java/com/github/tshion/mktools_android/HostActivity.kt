package com.github.tshion.mktools_android

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

abstract class HostActivity(
    packageName: String,
    idName: String = "container",
) : AppCompatActivity() {

    protected val idContainer = resources.getIdentifier(
        idName,
        "id",
        packageName
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FragmentContainerView(this@HostActivity).apply {
            id = idContainer
            layoutParams = LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }.also { setContentView(it) }
        setupFragment(idContainer, supportFragmentManager)
    }


    protected abstract fun setupFragment(
        id: Int,
        fragmentManager: FragmentManager,
    )
}
