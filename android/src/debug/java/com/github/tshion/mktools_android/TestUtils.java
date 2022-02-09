package com.github.tshion.mktools_android;

import java.util.Objects;

/**
 * テスト用のユーティリティー
 */
public final class TestUtils {

    private static final String MSG_UNREACHABLE = "意図しないコードが実行されました。";


    /**
     * 発生したエラーの抜き出し
     *
     * @param exceptionSource 例外の発生源
     * @return 発生した例外
     * @throws IllegalStateException 意図した例外が発生しなかった
     */
    public static Exception pickException(Runnable exceptionSource) {
        try {
            exceptionSource.run();
            throw new IllegalStateException(MSG_UNREACHABLE);
        } catch (Exception ex) {
            if (ex instanceof IllegalStateException && Objects.equals(ex.getMessage(), MSG_UNREACHABLE)) {
                throw ex;
            }
            return ex;
        }
    }
}
