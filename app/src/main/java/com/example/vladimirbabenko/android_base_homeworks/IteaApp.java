package com.example.vladimirbabenko.android_base_homeworks;

import android.app.Application;
import android.util.Log;
import com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus.GlobalBus;
import com.squareup.otto.Bus;

public class IteaApp extends Application {

    @Override public void onCreate() {
        super.onCreate();
    }

    public static GlobalBus getBus() {
        return GlobalBus.getInstance();
    }
}
