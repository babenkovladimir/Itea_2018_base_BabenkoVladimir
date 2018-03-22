package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

class BasePreferencesHelper {

    private SharedPreferences mPreferences;

    BasePreferencesHelper(Context context) {
        mPreferences = context.getSharedPreferences(BooksConstants.PrefsConstants.APP_PREFERENCES,
            Context.MODE_PRIVATE);
    }

    private SharedPreferences getPreferences() {
        return mPreferences;
    }

    void setInt(String key, int value) {
        getPreferences().edit().putInt(key, value).apply();
    }

    int getInt(String key) {
        return getPreferences().getInt(key, -1);
    }

    void setString(String key, String value) {
        getPreferences().edit().putString(key, value).apply();
    }

    String getString(String key) {
        return getPreferences().getString(key, "");
    }

    void setBoolean(String key, Boolean param) {
        getPreferences().edit().putBoolean(key, param).apply();
    }

    boolean getBoolean(String key) {
        return getPreferences().getBoolean(key, false);
    }
}
