package com.github.tshion.mktools_android.strict_mode;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.Nullable;

/**
 * StrictMode.VmPolicy を標準機能を使って有効化
 */
public class VmPolicyAndroidActivity extends VmPolicyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(ThreadPolicy.LAX);

        VmPolicy vmPolicy = new VmPolicy.Builder()
            .detectAll()
            .penaltyDeath()
            .build();
        StrictMode.setVmPolicy(vmPolicy);

        super.onCreate(savedInstanceState);
    }
}
