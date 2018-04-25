package com.example.vladimirbabenko.android_base_homeworks.lesson8.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.vladimirbabenko.android_base_homeworks.IteaApp;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager;
import com.squareup.otto.Bus;

public abstract class BaseActivity extends AppCompatActivity {// Чтобы не было объектов этого класса

    protected DataManager mDataManager;
    protected String TAG="TAG";
    protected String APP_PREFERENCES = "Itea_2018_base";
    protected Bus bus;
    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        bus = IteaApp.getBus();
        bus.register(this);

        mDataManager = DataManager.getInstance(getApplicationContext());
    }

    @Override protected void onDestroy() {
        bus.unregister(this);

        super.onDestroy();
    }
}
