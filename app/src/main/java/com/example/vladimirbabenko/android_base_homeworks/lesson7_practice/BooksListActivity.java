package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class BooksListActivity extends BaseActivity {

    @BindView(R.id.btAddBook) Button btAddBook;
    @BindView(R.id.lvBooksList) ListView booksList;
    private static List<BookEntity> books = new ArrayList<>();
    private BookListAdapter adapter;
    private com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager
        mDataManager;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_books_list);//Фича для ButterKnife
        super.onCreate(savedInstanceState);
        
        setupUI();
    }

    private void setupUI() {
        mDataManager =
            new com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager();
        adapter = new BookListAdapter(getApplicationContext(), R.layout.custom_book_item, books);
        booksList.setAdapter(adapter);
        adapter.setBooks(getMockBooks());// Use this void in Retrofit or Volley ?
    }

    //No Lyambda???
    @OnItemClick(R.id.lvBooksList) public void bookListOnItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        Intent intent = new Intent(getApplicationContext(), BookPreviewActivity.class);
        intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW,
            ((BookListAdapter) booksList.getAdapter()).getBook(position));
        startActivity(intent);
    }

    // Arguments?
    @OnItemLongClick(R.id.lvBooksList) public boolean bookListOnItemLongClick(int position) {
        String bookName = ((BookListAdapter) booksList.getAdapter()).getBook(position).getNameOfBook();
        String bookAuthor = ((BookListAdapter) booksList.getAdapter()).getBook(position).getAuthor();

        AlertDialog.Builder builder = new AlertDialog.Builder(BooksListActivity.this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want delete "+ bookName+ " "+ bookAuthor);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BooksListActivity.this, "not deleted", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ((BookListAdapter) booksList.getAdapter()).removeBook(position);
                Toast.makeText(BooksListActivity.this,  "deleted", Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        return true;
    }

    public List<BookEntity> getMockBooks() {
        books.addAll(mDataManager.fetchMoks());
        return books;
    }

    @OnClick(R.id.btAddBook) public void btAddBockClick(View v) {
        Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
        startActivityForResult(intent, BooksConstants.ADD_BOOK_REQUEST_CODE);
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
