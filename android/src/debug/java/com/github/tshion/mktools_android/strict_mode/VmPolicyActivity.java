package com.github.tshion.mktools_android.strict_mode;

import android.os.Build;
import android.os.StrictMode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * StrictMode.VmPolicy に違反するコードの実装
 */
public abstract class VmPolicyActivity extends AppCompatActivity {

    /**
     * @see StrictMode.VmPolicy.Builder#detectActivityLeaks()
     */
    public void runActivityLeaks() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectCleartextNetwork()
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void runCleartextNetwork() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectContentUriWithoutPermission()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runContentUriWithoutPermission() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectCredentialProtectedWhileLocked()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runCredentialProtectedWhileLocked() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectFileUriExposure()
     */
    public void runFileUriExposure() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectImplicitDirectBoot()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runImplicitDirectBoot() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectIncorrectContextUse()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runIncorrectContextUse() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectLeakedClosableObjects()
     */
    public void runLeakedClosableObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectLeakedRegistrationObjects()
     */
    public void runLeakedRegistrationObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectLeakedSqlLiteObjects()
     */
    public void runLeakedSqlLiteObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectNonSdkApiUsage()
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void runNonSdkApiUsage() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectUnsafeIntentLaunch()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runUnsafeIntentLaunch() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see StrictMode.VmPolicy.Builder#detectUntaggedSockets()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runUntaggedSockets() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }
}
