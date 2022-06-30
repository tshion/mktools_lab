package com.github.tshion.mktools_android

/**
 * 数学関連処理
 */
public object MkMath {

    /**
     * 剰余計算
     *
     * @return 余り(正の範囲)
     */
    public fun mod(x: Int, n: Int): Int {
        var candidate = x % n
        if (candidate < 0) {
            candidate += n
        }
        return candidate
    }
}
