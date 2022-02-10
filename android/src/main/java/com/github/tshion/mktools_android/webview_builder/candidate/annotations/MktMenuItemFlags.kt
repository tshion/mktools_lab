package com.github.tshion.mktools_android.webview_builder.candidate.annotations

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi

/**
 * Wraps WebSettings.MenuItemFlags annotation.
 *
 * * [WebSettings.MENU_ITEM_NONE]
 * * [WebSettings.MENU_ITEM_PROCESS_TEXT]
 * * [WebSettings.MENU_ITEM_SHARE]
 * * [WebSettings.MENU_ITEM_WEB_SEARCH]
 */
@IntDef(
    MENU_ITEM_NONE,
    MENU_ITEM_PROCESS_TEXT,
    MENU_ITEM_SHARE,
    MENU_ITEM_WEB_SEARCH
)
@RequiresApi(Build.VERSION_CODES.N)
@Retention(AnnotationRetention.SOURCE)
annotation class MktMenuItemFlags
