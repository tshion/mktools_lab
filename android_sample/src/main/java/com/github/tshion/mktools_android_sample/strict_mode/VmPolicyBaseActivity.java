package com.github.tshion.mktools_android_sample.strict_mode;

import android.os.Build;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * StrictMode.VmPolicy のデフォルト挙動の確認用
 */
public class VmPolicyBaseActivity extends AppCompatActivity {

    /**
     * @see VmPolicy.Builder#detectActivityLeaks()
     */
    public void runActivityLeaks() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectCleartextNetwork()
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void runCleartextNetwork() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectContentUriWithoutPermission()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runContentUriWithoutPermission() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectCredentialProtectedWhileLocked()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runCredentialProtectedWhileLocked() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectFileUriExposure()
     */
    public void runFileUriExposure() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectImplicitDirectBoot()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runImplicitDirectBoot() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectIncorrectContextUse()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runIncorrectContextUse() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectLeakedClosableObjects()
     */
    public void runLeakedClosableObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectLeakedRegistrationObjects()
     */
    public void runLeakedRegistrationObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectLeakedSqlLiteObjects()
     */
    public void runLeakedSqlLiteObjects() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectNonSdkApiUsage()
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void runNonSdkApiUsage() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectUnsafeIntentLaunch()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runUnsafeIntentLaunch() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see VmPolicy.Builder#detectUntaggedSockets()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runUntaggedSockets() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }
}
