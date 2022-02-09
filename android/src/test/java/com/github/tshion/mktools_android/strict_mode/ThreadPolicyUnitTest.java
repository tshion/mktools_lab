package com.github.tshion.mktools_android.strict_mode;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StrictMode.ThreadPolicy の設定方法の違いによる結果差異の検証
 */
@RunWith(AndroidJUnit4.class)
public class ThreadPolicyUnitTest extends ThreadPolicyTestCase {

    @AfterClass
    public static void afterClass() {
        cleanup();
    }


    @Before
    public void before() {
        cleanup();
    }


    /**
     * @see ThreadPolicyActivity#runCustomSlowCalls()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void test_runCustomSlowCalls() {
        super.test_runCustomSlowCalls();
    }

    /**
     * @see ThreadPolicyActivity#runDiskReads()
     */
    @Override
    @Test
    public void test_runDiskReads() {
        super.test_runDiskReads();
    }

    /**
     * @see ThreadPolicyActivity#runDiskWrites()
     */
    @Override
    @Test
    public void test_runDiskWrites() {
        super.test_runDiskWrites();
    }

    /**
     * @see ThreadPolicyActivity#runNetwork()
     */
    @Ignore("Robolectric で検出できなかったため")
    @Override
    @Test
    public void test_runNetwork() {
        super.test_runNetwork();
    }

    /**
     * @see ThreadPolicyActivity#runResourceMismatches()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void test_runResourceMismatches() {
        super.test_runResourceMismatches();
    }

    /**
     * @see ThreadPolicyActivity#runUnbufferedIo()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void test_runUnbufferedIo() {
        super.test_runUnbufferedIo();
    }
}
