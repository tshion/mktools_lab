package com.github.tshion.mktools_android

import android.app.Application
import java.util.function.BiConsumer

/**
 * 未処理例外ハンドラーのセットアップ
 *
 * https://www.fnn.jp/articles/-/352996
 */
class CustomUncaughtExceptionHandler(
    private val onCatchException: BiConsumer<Thread, Throwable>,
) : Thread.UncaughtExceptionHandler {

    internal val handlers = arrayListOf<Thread.UncaughtExceptionHandler>()

    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     *
     * Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     * @param t the thread
     * @param e the exception
     */
    override fun uncaughtException(t: Thread, e: Throwable) {
        onCatchException.accept(t, e)
        handlers.forEach { it.uncaughtException(t, e) }
    }
}

fun Application.setup(onCatchException: BiConsumer<Thread, Throwable>) {
    val target = CustomUncaughtExceptionHandler(onCatchException)
    Thread.getDefaultUncaughtExceptionHandler()?.also { target.handlers.add(it) }
    Thread.setDefaultUncaughtExceptionHandler(target)
}
