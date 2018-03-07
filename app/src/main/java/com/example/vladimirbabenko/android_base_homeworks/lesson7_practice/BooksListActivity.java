package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    private static String[] AuthtorNames = {"Author1", "Author2", "Author3", "Author4", "Author5", "Author6", "Author7", "Author8", "Author9", "Author10", "Author11", "Author12", "Author13"};
    private static String[] BookNames = {"Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8", "Book9", "Book10", "Book11", "Book12", "Author13"};
    private static float[] bookRating = {2.1f, 2.8f, 4.7f, 3.3f, 4.7f, 1.3f, 2.3f, 5f, 4.9f, 4.1f, 2.7f, 2.1f, 2.5f};
    private static String[] imageUrls = {"http://www.logologo.com/logos/book-logo.jpg", "", "", "", "", "", "", "", "", "", "", "", ""};
    private static String[] bookDescription = {"http://www.logologo.com/logos/book-logo.jpg", "", "", "", "", "", "", "", "", "", "", "", ""};

    private static List<BookEntity> books = new ArrayList<>();
    private Button btAddBook;
    private ListView booksList;
    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        booksList = (ListView) findViewById(R.id.lvBooksList);
        btAddBook = (Button) findViewById(R.id.btAddBook);
        btAddBook.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
           startActivityForResult(intent, BooksUtils.ADD_BOOK_REQUEST_CODE);
        });

        adapter = new BookListAdapter(getApplicationContext(), R.layout.custom_book_item, books);
        booksList.setAdapter(adapter);
        adapter.setBooks(getMockBooks());


    }

    public List<BookEntity> getMockBooks() {
        for (int i = 0; i < AuthtorNames.length; i++) {
            books.add(new BookEntity(AuthtorNames[i], BookNames[i], imageUrls[i], bookRating[i], bookDescription[i]));
        }
        return books;
    }
}
