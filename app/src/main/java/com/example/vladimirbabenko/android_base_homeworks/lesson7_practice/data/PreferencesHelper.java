package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import android.content.Context;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

public class PreferencesHelper extends BasePreferencesHelper {

    public PreferencesHelper(Context context) {
        super(context);
    }

    public void clearUserPreferences() {
        setUserChecked(false);
        setUserEmail("");
        setUserPassword(-1);
        setUserName("");
        setUserSecondName("");
        setDialogIsShown(false);
    }

    public void setUserChecked(Boolean param) {
        setBoolean(BooksConstants.PrefsConstants.IS_USER_LOGED_IN_KEY, param);
    }
    public boolean isUserChecked(){
        return getBoolean(BooksConstants.PrefsConstants.IS_USER_LOGED_IN_KEY);
    }

    public void setUserEmail(String email) {
        setString(BooksConstants.PrefsConstants.USER_EMAIL_KEY, email);
    }

    public String getUserEmain(){
        return getString(BooksConstants.PrefsConstants.USER_EMAIL_KEY);
    }

    public void setUserPassword(int password) {
        setInt(BooksConstants.PrefsConstants.USER_PASSWORD_KEY, password);
    }

    public int getUserPassword(){
        return getInt(BooksConstants.PrefsConstants.USER_PASSWORD_KEY);
    }

    public void setUserName(String name) {
        setString(BooksConstants.PrefsConstants.USER_NAME, name);
    }

    public String getUserName(){
        return getString(BooksConstants.PrefsConstants.USER_NAME);
    }

    public void setUserSecondName(String secondName) {
        setString(BooksConstants.PrefsConstants.USER_SECOND_NAME, secondName);
    }

    public String getUserSecondName(){
        return getString(BooksConstants.PrefsConstants.USER_SECOND_NAME);
    }

    public boolean isDialogShown() {
        return getBoolean(BooksConstants.PrefsConstants.IS_CONGRATULATION_SHOWN_KEY);
    }

    public void setDialogIsShown(boolean isShown){
        setBoolean(BooksConstants.PrefsConstants.IS_CONGRATULATION_SHOWN_KEY, isShown);
    }
}
