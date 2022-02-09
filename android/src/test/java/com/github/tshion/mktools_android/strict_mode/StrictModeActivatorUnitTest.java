package com.github.tshion.mktools_android.strict_mode;

import static com.google.common.truth.Truth.assertThat;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.github.tshion.mktools_android.StrictModeActivator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 適用前後のインスタンス変化の検証
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 */
@RunWith(AndroidJUnit4.class)
public class StrictModeActivatorUnitTest {

    @AfterClass
    public static void afterClass() {
        cleanup();
    }

    private static void cleanup() {
        StrictMode.setThreadPolicy(ThreadPolicy.LAX);
        StrictMode.setVmPolicy(VmPolicy.LAX);
    }


    @Before
    public void before() {
        cleanup();
    }


    @Test
    public void test_Activate() {
        ThreadPolicy threadPolicyBefore = StrictMode.getThreadPolicy();
        VmPolicy vmPolicyBefore = StrictMode.getVmPolicy();

        StrictModeActivator target = new StrictModeActivator() {
            @NonNull
            @Override
            public VmPolicy getVmPolicy() {
                return StrictModeActivator.DefaultImpls.getVmPolicy(this);
            }

            @NonNull
            @Override
            public ThreadPolicy getThreadPolicy() {
                return StrictModeActivator.DefaultImpls.getThreadPolicy(this);
            }

            @Override
            public void activateStrictMode() {
                StrictModeActivator.DefaultImpls.activateStrictMode(this);
            }
        };
        target.activateStrictMode();

        assertThat(StrictMode.getThreadPolicy()).isNotEqualTo(threadPolicyBefore);
        assertThat(StrictMode.getVmPolicy()).isNotEqualTo(vmPolicyBefore);
    }

    @Test
    public void test_tryRobolectric_ThreadPolicy() {
        ThreadPolicy before = StrictMode.getThreadPolicy();
        assertThat(before).isEqualTo(before);

        ThreadPolicy after = StrictMode.getThreadPolicy();
        assertThat(before).isNotEqualTo(after);

        assertThat(after.toString()).isEqualTo(before.toString());
    }

    @Test
    public void test_tryRobolectric_VmPolicy() {
        VmPolicy before = StrictMode.getVmPolicy();
        assertThat(before).isEqualTo(before);

        assertThat(StrictMode.getVmPolicy()).isEqualTo(before);
    }
}
