package com.github.tshion.mktools_android.strict_mode;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StrictMode.VmPolicy の設定方法の違いによる結果差異の検証
 */
@RunWith(AndroidJUnit4.class)
public class VmPolicyUnitTest extends VmPolicyTestCase {

    @AfterClass
    public static void afterClass() {
        cleanup();
    }


    @Before
    public void before() {
        cleanup();
    }


    /**
     * @see VmPolicyActivity#runActivityLeaks()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runActivityLeaks() {
        super.runActivityLeaks();
    }

    /**
     * @see VmPolicyActivity#runCleartextNetwork()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runCleartextNetwork() {
        super.runCleartextNetwork();
    }

    /**
     * @see VmPolicyActivity#runContentUriWithoutPermission()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runContentUriWithoutPermission() {
        super.runContentUriWithoutPermission();
    }

    /**
     * @see VmPolicyActivity#runCredentialProtectedWhileLocked()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runCredentialProtectedWhileLocked() {
        super.runCredentialProtectedWhileLocked();
    }

    /**
     * @see VmPolicyActivity#runFileUriExposure()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runFileUriExposure() {
        super.runFileUriExposure();
    }

    /**
     * @see VmPolicyActivity#runImplicitDirectBoot()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runImplicitDirectBoot() {
        super.runImplicitDirectBoot();
    }

    /**
     * @see VmPolicyActivity#runIncorrectContextUse()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runIncorrectContextUse() {
        super.runIncorrectContextUse();
    }

    /**
     * @see VmPolicyActivity#runLeakedClosableObjects()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runLeakedClosableObjects() {
        super.runLeakedClosableObjects();
    }

    /**
     * @see VmPolicyActivity#runLeakedRegistrationObjects()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runLeakedRegistrationObjects() {
        super.runLeakedRegistrationObjects();
    }

    /**
     * @see VmPolicyActivity#runLeakedSqlLiteObjects()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runLeakedSqlLiteObjects() {
        super.runLeakedSqlLiteObjects();
    }

    /**
     * @see VmPolicyActivity#runNonSdkApiUsage()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runNonSdkApiUsage() {
        super.runNonSdkApiUsage();
    }

    /**
     * @see VmPolicyActivity#runUnsafeIntentLaunch()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runUnsafeIntentLaunch() {
        super.runUnsafeIntentLaunch();
    }

    /**
     * @see VmPolicyActivity#runUntaggedSockets()
     */
    @Ignore("検証コードが未実装のため")
    @Override
    @Test
    public void runUntaggedSockets() {
        super.runUntaggedSockets();
    }
}
