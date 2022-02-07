package com.github.tshion.mktools_android_sample.strict_mode;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * StrictMode.VmPolicy のデフォルト挙動の検証
 *
 * @see com.github.tshion.mktools_android_sample.strict_mode.VmPolicyBaseActivity
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class VmPolicyBaseUiTest {

    @Rule
    public ActivityScenarioRule<VmPolicyBaseActivity> rule = new ActivityScenarioRule<>(VmPolicyBaseActivity.class);
}
