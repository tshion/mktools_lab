package com.github.tshion.mktools_android.strict_mode;

import static com.google.common.truth.Truth.assertThat;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.common.truth.ThrowableSubject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ThreadPolicyUnitTest {

    @Rule
    public ActivityScenarioRule<ThreadPolicyBaseActivity> ruleBase = new ActivityScenarioRule<>(ThreadPolicyBaseActivity.class);

    @Rule
    public ActivityScenarioRule<ThreadPolicyCustomActivity> ruleCustom = new ActivityScenarioRule<>(ThreadPolicyCustomActivity.class);


    /**
     * @see ThreadPolicyBaseActivity#runDiskReads()
     */
    @Test
    public void test_runDiskReads() {
        final Exception exBase;
        try {
            ruleBase.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskReads);
            return;
        } catch (RuntimeException ex) {
            exBase = ex;
        }

        final Exception exCustom;
        try {
            ruleCustom.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskReads);
            return;
        } catch (RuntimeException ex) {
            exCustom = ex;
        }

        assertThat(exCustom.toString()).isEqualTo(exBase.toString());
    }
}
