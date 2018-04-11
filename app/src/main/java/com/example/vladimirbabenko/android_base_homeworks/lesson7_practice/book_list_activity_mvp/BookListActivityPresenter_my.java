package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp;

import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.base_mvp.BasePresenter_my;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import java.util.ArrayList;
import java.util.List;

public class BookListActivityPresenter_my extends BasePresenter_my<BooksListActivity> {

    private List<BookEntity> books;

    public BookListActivityPresenter_my() {
        DataManager dataManager = DataManager.getInstance(getContext());
        books = dataManager.fetchMoks();
    }

    public void showListOfBooks() {
        getV().showListOfBooks(books);
    }

    public void removeBook(int position) {
        books.remove(position);
        getV().showListOfBooks(books);
    }

    public void uploadLatestData() {
        BookEntity newBook = new BookEntity("New Book", "Arnold Shwarcneger","", 2.5f, "Some description");
        books.add(newBook);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getV().showListOfBooks(books);
    }
}
