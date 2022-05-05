package com.github.tshion.mktools_android

import android.app.Application
import java.util.function.BiConsumer

/**
 * 未処理例外の検知時に実行する処理のセットアップ
 *
 * * [Android アプリのコード品質とビルド設定 - owasp-mstg-ja](https://coky-t.gitbook.io/owasp-mstg-ja/android-tesutogaido/0x05i-testing-code-quality-and-build-settings#notesuto-mstg-code-6-oyobi-mstg-code-7)
 */
fun Application.setOnDetectUncaughtException(action: BiConsumer<Thread, Throwable>) {
    val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler { t, e ->
        action.accept(t, e)
        defaultHandler?.uncaughtException(t, e)
    }
}
