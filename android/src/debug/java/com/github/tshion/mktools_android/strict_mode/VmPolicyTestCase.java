package com.github.tshion.mktools_android.strict_mode;

import static com.github.tshion.mktools_android.TestUtils.pickException;
import static com.google.common.truth.Truth.assertThat;

import android.os.Build;
import android.os.StrictMode;

import androidx.annotation.RequiresApi;
import androidx.test.core.app.ActivityScenario;

/**
 * StrictMode.VmPolicy の設定方法の違いによる結果差異の検証ケース
 */
public abstract class VmPolicyTestCase {

    protected static void cleanup() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
    }

    private static void doTest(Exception exActual, Exception exExpected) {
        assertThat(exActual.toString()).isEqualTo(exExpected.toString());
        assertThat(exActual).isInstanceOf(RuntimeException.class);
        assertThat(exActual).hasMessageThat().isEqualTo("StrictMode VmPolicy violation");
    }


    private ActivityScenario<VmPolicyMkToolsActivity> getScenarioActual() {
        return ActivityScenario.launch(VmPolicyMkToolsActivity.class);
    }

    private ActivityScenario<VmPolicyAndroidActivity> getScenarioExpected() {
        return ActivityScenario.launch(VmPolicyAndroidActivity.class);
    }


    /**
     * @see VmPolicyActivity#runActivityLeaks()
     */
    public void runActivityLeaks() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runActivityLeaks);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runActivityLeaks);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runCleartextNetwork()
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void runCleartextNetwork() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runCleartextNetwork);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runCleartextNetwork);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runContentUriWithoutPermission()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runContentUriWithoutPermission() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runContentUriWithoutPermission);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runContentUriWithoutPermission);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runCredentialProtectedWhileLocked()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runCredentialProtectedWhileLocked() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runCredentialProtectedWhileLocked);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runCredentialProtectedWhileLocked);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runFileUriExposure()
     */
    public void runFileUriExposure() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runFileUriExposure);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runFileUriExposure);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runImplicitDirectBoot()
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void runImplicitDirectBoot() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runImplicitDirectBoot);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runImplicitDirectBoot);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runIncorrectContextUse()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runIncorrectContextUse() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runIncorrectContextUse);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runIncorrectContextUse);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runLeakedClosableObjects()
     */
    public void runLeakedClosableObjects() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runLeakedClosableObjects);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runLeakedClosableObjects);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runLeakedRegistrationObjects()
     */
    public void runLeakedRegistrationObjects() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runLeakedRegistrationObjects);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runLeakedRegistrationObjects);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runLeakedSqlLiteObjects()
     */
    public void runLeakedSqlLiteObjects() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runLeakedSqlLiteObjects);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runLeakedSqlLiteObjects);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runNonSdkApiUsage()
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void runNonSdkApiUsage() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runNonSdkApiUsage);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runNonSdkApiUsage);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runUnsafeIntentLaunch()
     */
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void runUnsafeIntentLaunch() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runUnsafeIntentLaunch);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runUnsafeIntentLaunch);
        });
        doTest(exActual, exExpected);
    }

    /**
     * @see VmPolicyActivity#runUntaggedSockets()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runUntaggedSockets() {
        final Exception exExpected = pickException(() -> {
            ActivityScenario<VmPolicyAndroidActivity> scenario = getScenarioExpected();
            scenario.onActivity(VmPolicyActivity::runUntaggedSockets);
        });
        final Exception exActual = pickException(() -> {
            ActivityScenario<VmPolicyMkToolsActivity> scenario = getScenarioActual();
            scenario.onActivity(VmPolicyActivity::runUntaggedSockets);
        });
        doTest(exActual, exExpected);
    }
}
