package com.github.tshion.mktools_android.strict_mode;

import android.os.Bundle;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.tshion.mktools_android.StrictModeActivator;

/**
 * StrictMode.VmPolicy を自作ライブラリを使って有効化
 *
 * @see StrictModeActivator
 */
public class VmPolicyMkToolsActivity extends VmPolicyActivity implements StrictModeActivator {

    @NonNull
    @Override
    public ThreadPolicy getThreadPolicy() {
        return ThreadPolicy.LAX;
    }

    @NonNull
    @Override
    public VmPolicy getVmPolicy() {
        return new VmPolicy.Builder()
            .detectAll()
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
        DefaultImpls.activateStrictMode(this);
    }
}
