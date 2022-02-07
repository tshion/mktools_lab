package com.github.tshion.mktools_android_sample;

import android.os.Bundle;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.tshion.mktools_android.StrictModeActivator;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class StrictModeThreadPolicyActivity extends AppCompatActivity implements StrictModeActivator {

    @NonNull
    @Override
    public ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build();
    }

    @NonNull
    @Override
    public VmPolicy getVmPolicy() {
        return StrictModeActivator.DefaultImpls.getVmPolicy(this);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activateStrictMode();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

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
        }
    }


    @Override
    public void activateStrictMode() {
        StrictModeActivator.DefaultImpls.activateStrictMode(this);
    }
}
