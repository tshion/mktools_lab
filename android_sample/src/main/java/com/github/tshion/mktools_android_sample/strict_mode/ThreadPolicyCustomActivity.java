package com.github.tshion.mktools_android_sample.strict_mode;

import android.os.Bundle;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.tshion.mktools_android.StrictModeActivator;

/**
 * StrictMode.ThreadPolicy のデフォルト挙動の上書きの確認用
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 */
public class ThreadPolicyCustomActivity extends ThreadPolicyBaseActivity implements StrictModeActivator {

    @NonNull
    @Override
    public ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy.Builder()
            .detectDiskReads()
            .detectDiskWrites()
            .penaltyDeath()
            .build();
    }

    @NonNull
    @Override
    public VmPolicy getVmPolicy() {
        return StrictModeActivator.DefaultImpls.getVmPolicy(this);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activateStrictMode();
        super.onCreate(savedInstanceState);
    }


    @Override
    public void activateStrictMode() {
        StrictModeActivator.DefaultImpls.activateStrictMode(this);
    }
}