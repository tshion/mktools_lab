package com.github.tshion.mktools_android;

import android.os.StrictMode;

import androidx.annotation.NonNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 適用前後の変化の検証
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 */
@RunWith(AndroidJUnit4.class)
public class StrictModeActivatorPlayground {

    @Test
    public void test_Activate() {
        StrictMode.ThreadPolicy threadPolicyBefore = StrictMode.getThreadPolicy();
        StrictMode.VmPolicy vmPolicyBefore = StrictMode.getVmPolicy();

        StrictModeActivator target = new StrictModeActivator() {
            @NonNull
            @Override
            public StrictMode.VmPolicy getVmPolicy() {
                return StrictModeActivator.DefaultImpls.getVmPolicy(this);
            }

            @NonNull
            @Override
            public StrictMode.ThreadPolicy getThreadPolicy() {
                return StrictModeActivator.DefaultImpls.getThreadPolicy(this);
            }

            @Override
            public void activateStrictMode() {
                StrictModeActivator.DefaultImpls.activateStrictMode(this);
            }
        };
        target.activateStrictMode();

        StrictMode.ThreadPolicy threadPolicyAfter = StrictMode.getThreadPolicy();
        StrictMode.VmPolicy vmPolicyAfter = StrictMode.getVmPolicy();

        Assert.assertNotEquals(threadPolicyBefore, threadPolicyAfter);
        Assert.assertNotEquals(vmPolicyBefore, vmPolicyAfter);
    }

    @Test
    public void test_tryRobolectric_ThreadPolicy() {
        StrictMode.ThreadPolicy before = StrictMode.getThreadPolicy();
        Assert.assertEquals(before, before);

        StrictMode.ThreadPolicy after = StrictMode.getThreadPolicy();
        Assert.assertNotEquals(before, after);

        String textBefore = before.toString();
        String textAfter = after.toString();
        Assert.assertEquals(textBefore, textAfter);
    }

    @Test
    public void test_tryRobolectric_VmPolicy() {
        StrictMode.VmPolicy before = StrictMode.getVmPolicy();
        Assert.assertEquals(before, before);

        StrictMode.VmPolicy after = StrictMode.getVmPolicy();
        Assert.assertEquals(before, after);
    }
}
