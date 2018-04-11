package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp;

import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.base_mvp.IView_my;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import java.util.List;

public interface IBookListActivity extends IView_my {

    void showListOfBooks(List<BookEntity> list);


}
