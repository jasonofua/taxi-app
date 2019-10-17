package com.innomalist.taxi.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.google.firebase.FirebaseApp;

public class MyTaxiApplication extends Application {
    @Override
    public void onCreate() {
        FirebaseApp.initializeApp(getApplicationContext());
        int nightMode = AppCompatDelegate.MODE_NIGHT_NO;
        AppCompatDelegate.setDefaultNightMode(nightMode);
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
