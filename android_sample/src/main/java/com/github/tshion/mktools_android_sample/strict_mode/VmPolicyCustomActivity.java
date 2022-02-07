package com.github.tshion.mktools_android_sample.strict_mode;

import android.os.Bundle;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.tshion.mktools_android.StrictModeActivator;

/**
 * StrictMode.VmPolicy のデフォルト挙動の上書きの確認用
 *
 * @see com.github.tshion.mktools_android.StrictModeActivator
 */
public class VmPolicyCustomActivity extends VmPolicyBaseActivity implements StrictModeActivator {
    @NonNull
    @Override
    public ThreadPolicy getThreadPolicy() {
        return StrictModeActivator.DefaultImpls.getThreadPolicy(this);
    }

    @NonNull
    @Override
    public VmPolicy getVmPolicy() {
        return new VmPolicy.Builder()
            // TODO: 変更点の追加
            .penaltyDeath()
            .build();
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
