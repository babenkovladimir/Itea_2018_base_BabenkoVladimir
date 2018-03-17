package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data;

import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import java.util.List;

public class DataManager {
    private RepositoryMockBooks mRepositoryMockBooks;

    public DataManager(){
        mRepositoryMockBooks = new RepositoryMockBooks();
    }

    public List<BookEntity> fetchMoks() {
        return mRepositoryMockBooks.fetchMocks();
    }

}
