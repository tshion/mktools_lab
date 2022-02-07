package com.github.tshion.mktools_android_sample.strict_mode;

import android.os.NetworkOnMainThreadException;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StrictMode.ThreadPolicy のデフォルト挙動の検証
 *
 * @see com.github.tshion.mktools_android_sample.strict_mode.ThreadPolicyBaseActivity
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class ThreadPolicyBaseUiTest {

    @Rule
    public ActivityScenarioRule<ThreadPolicyBaseActivity> rule = new ActivityScenarioRule<>(ThreadPolicyBaseActivity.class);


    @Test
    public void test_ThreadPolicy_runDiskReads() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskReads);
    }

    @Test
    public void test_ThreadPolicy_runDiskWrites() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runDiskWrites);
    }

    @Test(expected = NetworkOnMainThreadException.class)
    public void test_ThreadPolicy_runNetwork() {
        rule.getScenario().onActivity(ThreadPolicyBaseActivity::runNetwork);
    }
}
