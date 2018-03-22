package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import java.util.List;

public class DataManager {
    private RepositoryMockBooks mRepositoryMockBooks;
    private PreferencesHelper mPreferencesHelper;

    public DataManager(Context context) {
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
