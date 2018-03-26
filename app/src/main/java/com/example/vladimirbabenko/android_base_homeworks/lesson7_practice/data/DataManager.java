package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import android.content.Context;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import java.util.List;

public class DataManager {
    private RepositoryMockBooks mRepositoryMockBooks;
    private PreferencesHelper mPreferencesHelper;
    private static DataManager instance;

    public static synchronized DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context);
        }
        return instance;
    }

    private DataManager(Context context) {
        mRepositoryMockBooks = new RepositoryMockBooks();
        mPreferencesHelper = new PreferencesHelper(context);
    }

    public List<BookEntity> fetchMoks() {
        return mRepositoryMockBooks.fetchMocks();
    }

    public PreferencesHelper getPrefs() {
        return mPreferencesHelper;
    }
}
