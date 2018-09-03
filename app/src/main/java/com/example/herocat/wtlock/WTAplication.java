package com.example.herocat.wtlock;

import android.app.Application;
import android.content.Context;

import com.accloud.cloudservice.AC;

public class WTAplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        AC.init(this, "15657128063", 6587, AC.TEST_MODE);
    }

    public static Context getContext() {
        return context;
    }

}
