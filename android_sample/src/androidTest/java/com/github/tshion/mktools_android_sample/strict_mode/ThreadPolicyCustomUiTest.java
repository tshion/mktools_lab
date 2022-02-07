package com.github.tshion.mktools_android_sample.strict_mode;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StrictModeActivator を使ってデフォルト挙動の上書き検証
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 * @see com.github.tshion.mktools_android_sample.strict_mode.ThreadPolicyCustomActivity
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class ThreadPolicyCustomUiTest {

    @Rule
    public ActivityScenarioRule<ThreadPolicyCustomActivity> rule = new ActivityScenarioRule<>(ThreadPolicyCustomActivity.class);


    @Test(expected = RuntimeException.class)
    public void test_ThreadPolicy_runDiskReads() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskReads);
    }

    @Test(expected = RuntimeException.class)
    public void test_ThreadPolicy_runDiskWrites() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskWrites);
    }

    @Test()
    public void test_ThreadPolicy_runNetwork() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runNetwork);
    }
}
