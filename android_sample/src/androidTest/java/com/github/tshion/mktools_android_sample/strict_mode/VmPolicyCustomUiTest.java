package com.github.tshion.mktools_android_sample.strict_mode;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * StrictModeActivator を使ってデフォルト挙動の上書き検証
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 * @see com.github.tshion.mktools_android_sample.strict_mode.VmPolicyCustomActivity
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class VmPolicyCustomUiTest {

    @Rule
    public ActivityScenarioRule<VmPolicyCustomActivity> rule = new ActivityScenarioRule<>(VmPolicyCustomActivity.class);
}
