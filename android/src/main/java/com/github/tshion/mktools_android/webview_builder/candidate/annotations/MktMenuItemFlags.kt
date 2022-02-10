package com.github.tshion.mktools_android.webview_builder.candidate.annotations

import android.annotation.TargetApi
import android.webkit.WebSettings
import android.webkit.WebSettings.*
import androidx.annotation.IntDef

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
@Retention(AnnotationRetention.SOURCE)
@TargetApi(24)
annotation class MktMenuItemFlags
