package com.github.tshion.mktools_android.strict_mode;

import static com.github.tshion.mktools_android.TestUtils.pickException;
import static com.github.tshion.mktools_android.TestUtils.showMessageApiVersionUnmatched;
import static com.google.common.truth.Truth.assertThat;

import android.os.Build;
import android.os.StrictMode;

import androidx.test.core.app.ActivityScenario;

import com.google.common.truth.StringSubject;

/**
 * StrictMode.ThreadPolicy の設定方法の違いによる結果差異の検証ケース
 */
public abstract class ThreadPolicyTestCase {

    protected static void cleanup() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
    }

    private static void doTest(Exception exActual, Exception exExpected) {
        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        StringSubject subject = assertThat(exActual).hasMessageThat();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            subject.contains("violation");
        } else {
            subject.isEqualTo("StrictMode ThreadPolicy violation");
        }
    }


    private ActivityScenario<ThreadPolicyMkToolsActivity> getScenarioActual() {
        return ActivityScenario.launch(ThreadPolicyMkToolsActivity.class);
    }

    private ActivityScenario<ThreadPolicyAndroidActivity> getScenarioExpected() {
        return ActivityScenario.launch(ThreadPolicyAndroidActivity.class);
    }


    /**
     * @see ThreadPolicyActivity#runCustomSlowCalls()
     */
    public void test_runCustomSlowCalls() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runCustomSlowCalls);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runCustomSlowCalls);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see ThreadPolicyActivity#runDiskReads()
     */
    public void test_runDiskReads() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runDiskReads);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runDiskReads);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see ThreadPolicyActivity#runDiskWrites()
     */
    public void test_runDiskWrites() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runDiskWrites);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runDiskWrites);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see ThreadPolicyActivity#runNetwork()
     */
    public void test_runNetwork() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runNetwork);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runNetwork);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see ThreadPolicyActivity#runResourceMismatches()
     */
    public void test_runResourceMismatches() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            showMessageApiVersionUnmatched();
            return;
        }

        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runResourceMismatches);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runResourceMismatches);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see ThreadPolicyActivity#runUnbufferedIo()
     */
    public void test_runUnbufferedIo() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            showMessageApiVersionUnmatched();
            return;
        }

        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(ThreadPolicyActivity::runUnbufferedIo);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(ThreadPolicyActivity::runUnbufferedIo);
        });
        doTest(exActual, exExpected);
    }
}
