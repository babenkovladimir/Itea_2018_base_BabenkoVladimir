package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.example.vladimirbabenko.android_base_homeworks.R;
import java.util.Collections;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {
    private Button vv;

    private static List<BookEntity> books = Collections.emptyList();

    private ListView booksList;
    private BookListAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        booksList = (ListView) findViewById(R.id.lvBooksList);

        adapter = new BookListAdapter(getApplicationContext(), R.layout.custom_book_item, books);
        booksList.setAdapter(adapter);






    }
}
