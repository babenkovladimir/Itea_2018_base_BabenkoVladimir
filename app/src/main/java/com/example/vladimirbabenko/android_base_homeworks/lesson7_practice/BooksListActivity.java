package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class BooksListActivity extends BaseActivity {

    @BindView(R.id.btAddBook) Button btAddBook;
    @BindView(R.id.rvBooksRecyclerView) RecyclerView booksRecyclerView;
    private static List<BookEntity> books = new ArrayList<>();
    private BookRecycleViewAdapter adapter;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_books_list);//Фича для ButterKnife
        super.onCreate(savedInstanceState);

        setupUI();
    }

    private void setupUI() {
        adapter = new BookRecycleViewAdapter(getApplicationContext());
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(
            new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        books = mDataManager.fetchMoks();
        adapter.setBooks(books);
    }

    @OnClick(R.id.btAddBook) public void btAddBockClick(View v) {
        Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
        startActivityForResult(intent, BooksConstants.ADD_BOOK_REQUEST_CODE);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BooksConstants.ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            if (extras.containsKey(BooksConstants.BOOK_ENTITY_KEY)) {
                ((BookRecycleViewAdapter) booksRecyclerView.getAdapter()).addBook(
                    (BookEntity) extras.get(BooksConstants.BOOK_ENTITY_KEY));
            }
        }
    }
}
