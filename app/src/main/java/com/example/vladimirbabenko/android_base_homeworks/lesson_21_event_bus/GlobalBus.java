package com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus;

import com.squareup.otto.Bus;

public class GlobalBus extends Bus {

    private static GlobalBus Instance;

    public static synchronized GlobalBus getInstance() {
        if (Instance == null) {
            Instance = new GlobalBus();
            return Instance;
        } else {
            return Instance;
        }
    }
}
