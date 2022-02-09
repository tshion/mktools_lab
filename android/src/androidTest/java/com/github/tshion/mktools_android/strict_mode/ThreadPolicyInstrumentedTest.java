package com.github.tshion.mktools_android.strict_mode;

import static com.github.tshion.mktools_android.TestUtils.pickException;
import static com.google.common.truth.Truth.assertThat;

import android.os.StrictMode;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StrictMode.ThreadPolicy の設定方法の違いによる結果差異の検証
 */
@RunWith(AndroidJUnit4.class)
public class ThreadPolicyInstrumentedTest {

    @Rule
    public ActivityScenarioRule<ThreadPolicyMkToolsActivity> ruleActual = new ActivityScenarioRule<>(ThreadPolicyMkToolsActivity.class);

    @Rule
    public ActivityScenarioRule<ThreadPolicyAndroidActivity> ruleExpected = new ActivityScenarioRule<>(ThreadPolicyAndroidActivity.class);


    @After
    public void tearDown() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
    }


    /**
     * @see ThreadPolicyActivity#runCustomSlowCalls()
     */
    @Ignore("検証コードが未実装のため")
    @Test
    public void test_runCustomSlowCalls() {
        final Exception exExpected = pickException(() -> ruleExpected.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runCustomSlowCalls)
        );
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> ruleActual.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runCustomSlowCalls)
        );
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }

    /**
     * @see ThreadPolicyActivity#runDiskReads()
     */
    @Test
    public void test_runDiskReads() {
        final Exception exExpected = pickException(() -> ruleExpected.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runDiskReads)
        );
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> ruleActual.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runDiskReads)
        );
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }

    /**
     * @see ThreadPolicyActivity#runDiskWrites()
     */
    @Test
    public void test_runDiskWrites() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<ThreadPolicyAndroidActivity> target = ruleExpected.getScenario();
            target.moveToState(Lifecycle.State.RESUMED);
            target.onActivity(ThreadPolicyActivity::runDiskWrites);
        });
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> {
            ActivityScenario<ThreadPolicyMkToolsActivity> target = ruleActual.getScenario().recreate();
            target.moveToState(Lifecycle.State.RESUMED);
            target.onActivity(ThreadPolicyActivity::runDiskWrites);
        });
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }

    /**
     * @see ThreadPolicyActivity#runNetwork()
     */
    @Test
    public void test_runNetwork() {
        final Exception exExpected = pickException(() -> ruleExpected.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runNetwork)
        );
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> ruleActual.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runNetwork)
        );

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }

    /**
     * @see ThreadPolicyActivity#runResourceMismatches()
     */
    @Ignore("検証コードが未実装のため")
    @Test
    public void test_runResourceMismatches() {
        final Exception exExpected = pickException(() -> ruleExpected.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runResourceMismatches)
        );
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> ruleActual.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runResourceMismatches)
        );
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }

    /**
     * @see ThreadPolicyActivity#runUnbufferedIo()
     */
    @Ignore("検証コードが未実装のため")
    @Test
    public void test_runUnbufferedIo() {
        final Exception exExpected = pickException(() -> ruleExpected.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runUnbufferedIo)
        );
        assertThat(exExpected).isInstanceOf(RuntimeException.class);

        final Exception exActual = pickException(() -> ruleActual.getScenario()
            .recreate()
            .onActivity(ThreadPolicyActivity::runUnbufferedIo)
        );
        assertThat(exActual).isInstanceOf(RuntimeException.class);

        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
    }
}
