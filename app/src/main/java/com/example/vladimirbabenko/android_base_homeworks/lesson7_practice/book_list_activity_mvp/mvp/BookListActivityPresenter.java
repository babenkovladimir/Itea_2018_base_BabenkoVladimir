package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp.mvp;

import android.content.Context;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.base_mvp.BasePresenter_my;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp.BooksListActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager;
import org.jetbrains.annotations.Nullable;

public class BookListActivityPresenter {
//public class BookListActivityPresenter extends BasePresenter_my<BooksListActivity> {
    //private DataManager mDataManager = DataManager.getInstance();

    private BooksListActivity mBooksListActivity;
    private @Nullable Context mContext;
    private DataManager mDataManager;

    public void bind(BooksListActivity view, Context context) {
        this.mBooksListActivity = view;
        this.mContext = context;
        mDataManager = DataManager.getInstance(context);
    }

    public void bind(BooksListActivity view){
        bind(view, null);
    }

    public void unBind(){
        this.mBooksListActivity = null;
    }

    public void showListOfBooks(){
        mBooksListActivity.showListOfBooks(mDataManager.fetchMoks());

    }
}
