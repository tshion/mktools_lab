package com.github.tshion.mktools_android

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy

/**
 * Activates "StrictMode".
 *
 * ## Example
 * ``` kotlin
 * class DebugApplication : Application(), StrictModeActivator {
 *     override val threadPolicy: StrictMode.ThreadPolicy
 *         get() = StrictMode.ThreadPolicy.Builder()
 *             .detectAll()
 *             .penaltyLog()
 *             .penaltyDeath()
 *             .build()
 *
 *     override val vmPolicy: StrictMode.VmPolicy
 *         get() = StrictMode.VmPolicy.Builder()
 *             .detectAll()
 *             .penaltyLog()
 *             .build()
 *
 *
 *     override fun onCreate() {
 *         super.onCreate()
 *         activateStrictMode()
 *     }
 * }
 * ```
 *
 * ## References
 * * [StrictMode | Android Developers](https://developer.android.com/reference/android/os/StrictMode)
 *
 * @see [android.os.StrictMode]
 */
public interface StrictModeActivator {

    /**
     * Configures ThreadPolicy.
     *
     * @see [android.os.StrictMode.ThreadPolicy]
     */
    public val threadPolicy: ThreadPolicy
        get() = ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .penaltyFlashScreen()
            .build()

    /**
     * Configures VmPolicy.
     *
     * @see [android.os.StrictMode.VmPolicy]
     */
    public val vmPolicy: VmPolicy
        get() = VmPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build()


    /**
     * Activates StrictMode.
     *
     * **Don't use in production.**
     *
     * ## Example
     * ``` kotlin
     * class DebugApplication : Application(), StrictModeActivator {
     *     override fun onCreate() {
     *         super.onCreate()
     *         activateStrictMode()
     *     }
     * }
     * ```
     *
     * @see [android.os.StrictMode.setThreadPolicy]
     * @see [android.os.StrictMode.setVmPolicy]
     */
    public fun activateStrictMode() {
        StrictMode.setThreadPolicy(threadPolicy)
        StrictMode.setVmPolicy(vmPolicy)
    }
}
