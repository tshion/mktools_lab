package com.github.tshion.mktools_android.strict_mode;

import android.os.Bundle;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.tshion.mktools_android.StrictModeActivator;

/**
 * StrictMode.ThreadPolicy を自作ライブラリを使って有効化
 *
 * @see StrictModeActivator
 */
public class ThreadPolicyMkToolsActivity extends ThreadPolicyActivity implements StrictModeActivator {

    @NonNull
    @Override
    public ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy.Builder()
            .detectAll()
            .penaltyDeath()
            .build();
    }

    @NonNull
    @Override
    public VmPolicy getVmPolicy() {
        return VmPolicy.LAX;
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
