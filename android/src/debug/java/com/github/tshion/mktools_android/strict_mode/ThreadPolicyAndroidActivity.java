package com.github.tshion.mktools_android.strict_mode;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;

import androidx.annotation.Nullable;

/**
 * StrictMode.ThreadPolicy を標準機能を使って有効化
 */
public class ThreadPolicyAndroidActivity extends ThreadPolicyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ThreadPolicy threadPolicy = new ThreadPolicy.Builder()
            .detectAll()
            .penaltyDeath()
            .build();
        StrictMode.setThreadPolicy(threadPolicy);

        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);

        super.onCreate(savedInstanceState);
    }
}
