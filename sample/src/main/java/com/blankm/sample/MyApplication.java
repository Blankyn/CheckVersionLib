package com.blankm.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by admin on 2018/1/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
