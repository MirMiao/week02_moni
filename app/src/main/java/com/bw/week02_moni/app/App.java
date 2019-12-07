package com.bw.week02_moni.app;

import android.app.Application;
import android.content.Context;

/**
 * 时间 :2019/12/7  8:44
 * 作者 :苗恒
 * 功能 :
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
