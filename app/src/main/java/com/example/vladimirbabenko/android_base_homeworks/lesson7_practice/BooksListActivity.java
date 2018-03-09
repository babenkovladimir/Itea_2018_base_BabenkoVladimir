package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.DataManager;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.BaseActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BooksListActivity extends BaseActivity {

    private static List<BookEntity> books = new ArrayList<>();
    private Button btAddBook;
    @BindView(R.id.lvBooksList) ListView booksList;
    //private ListView booksList;
    private BookListAdapter adapter;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_books_list);//Фича для ButterKnife
        super.onCreate(savedInstanceState);

        //ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        //booksList = (ListView) findViewById(R.id.lvBooksList);
        adapter = new BookListAdapter(getApplicationContext(), R.layout.custom_book_item, books);
        booksList.setAdapter(adapter);
        adapter.setBooks(getMockBooks());// Use this void in Retrofit or Volley ?

        booksList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), BookPreviewActivity.class);
            intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW,
                ((BookListAdapter) booksList.getAdapter()).getBook(position));
            startActivity(intent);
        });
        booksList.setOnItemLongClickListener((parent, view, position, id) -> {
            ((BookListAdapter) booksList.getAdapter()).removeBook(position);
            return true;
        });

        findViewById(R.id.btAddBook).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
            startActivityForResult(intent, BooksConstants.ADD_BOOK_REQUEST_CODE);
        });
    }

    public List<BookEntity> getMockBooks() {
        books.addAll(DataManager.getMockData());
        return books;
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BooksConstants.ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras.containsKey(BooksConstants.BOOK_ENTITY_KEY)) {
                ((BookListAdapter) booksList.getAdapter()).addBook(
                    (BookEntity) extras.get(BooksConstants.BOOK_ENTITY_KEY));
            }
        }
    }
}
