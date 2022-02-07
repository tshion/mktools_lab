package com.github.tshion.mktools_android_sample.strict_mode;

import android.content.SharedPreferences;
import android.os.StrictMode.ThreadPolicy;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * StrictMode.ThreadPolicy のデフォルト挙動の確認用
 *
 * @see com.github.tshion.mktools_android_sample.strict_mode.ThreadPolicyBaseActivity
 */
public class ThreadPolicyBaseActivity extends AppCompatActivity {

    private static final String KEY = ThreadPolicyBaseActivity.class.getSimpleName() + "_KEY";


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
}
