package com.github.tshion.mktools_android.strict_mode;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.StrictMode.ThreadPolicy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * StrictMode.ThreadPolicy に違反するコードの実装
 */
public abstract class ThreadPolicyActivity extends AppCompatActivity {

    private static final String KEY = ThreadPolicyActivity.class.getSimpleName() + "_KEY";


    /**
     * @see ThreadPolicy.Builder#detectCustomSlowCalls()
     */
    public void runCustomSlowCalls() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see ThreadPolicy.Builder#allowThreadDiskReads()
     */
    public void runDiskReads() {
        final SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String stored = preferences.getString(KEY, "");
    }

    /**
     * @see ThreadPolicy.Builder#detectDiskWrites()
     */
    public void runDiskWrites() {
        final SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY, "test");
        editor.apply();
    }

    /**
     * @see ThreadPolicy.Builder#detectNetwork()
     */
    public void runNetwork() {
        HttpsURLConnection connection = null;
        final String url = "https://developer.android.com/reference/javax/net/ssl/HttpsURLConnection";
        try {
            connection = (HttpsURLConnection) (new URL(url).openConnection());
            connection.setRequestMethod("GET");
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            connection = null;
        }
    }

    /**
     * @see ThreadPolicy.Builder#detectResourceMismatches()
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void runResourceMismatches() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }

    /**
     * @see ThreadPolicy.Builder#detectUnbufferedIo()
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void runUnbufferedIo() {
        // FIXME: 検知に引っ掛かる実行コードの実装
        throw new UnsupportedOperationException();
    }
}
