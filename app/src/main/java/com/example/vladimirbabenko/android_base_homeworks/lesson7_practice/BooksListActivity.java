package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

import java.util.ArrayList;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    //private final String TAG = this.getClass().getSimpleName();
    private final String TAG = "TAG";

    private static String[] AuthtorNames = {
        "Author1", "Author2", "Author3", "Author4", "Author5", "Author6", "Author7", "Author8",
        "Author9", "Author10", "Author11", "Author12", "Author13"
    };
    private static String[] BookNames = {
        "Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8", "Book9", "Book10",
        "Book11", "Book12", "Author13"
    };
    private static float[] bookRating =
        { 2.1f, 2.8f, 4.7f, 3.3f, 4.7f, 1.3f, 2.3f, 5f, 4.9f, 4.1f, 2.7f, 2.1f, 2.5f };
    private static String[] imageUrls = {
        "http://www.logologo.com/logos/book-logo.jpg", "", "", "", "", "", "", "", "", "", "", "",
        ""
    };
    private static String[] bookDescription = {
        "sapien et ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac ut consequat semper viverra nam",
        "", "", "", "", "", "", "", "", "", "", "", ""
    };

    private static List<BookEntity> books = new ArrayList<>();
    private Button btAddBook;
    private ListView booksList;
    private BookListAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        booksList = (ListView) findViewById(R.id.lvBooksList);
        btAddBook = (Button) findViewById(R.id.btAddBook);
        btAddBook.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
            startActivityForResult(intent, BooksConstants.ADD_BOOK_REQUEST_CODE);
        });

        adapter = new BookListAdapter(getApplicationContext(), R.layout.custom_book_item, books);
        booksList.setAdapter(adapter);
        adapter.setBooks(getMockBooks());

        booksList.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(BooksListActivity.this, "IsPressed lekement number " + position,
                Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), BookPreviewActivity.class);
            intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW, ((BookListAdapter) booksList.getAdapter()).getBook(position));
            startActivity(intent);
        });

        booksList.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "onLong Click on position" + position, Toast.LENGTH_SHORT).show();
            ((BookListAdapter) booksList.getAdapter()).removeBook(position);
            return true;
        });
    }

    public List<BookEntity> getMockBooks() {
        for (int i = 0; i < AuthtorNames.length; i++) {
            books.add(new BookEntity(AuthtorNames[i], BookNames[i], imageUrls[i], bookRating[i],
                bookDescription[0]));
        }
        return books;
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = data.getExtras();

        if (requestCode == BooksConstants.ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            if (extras.containsKey(BooksConstants.BOOK_ENTITY_KEY)) {
                ((BookListAdapter) booksList.getAdapter()).addBook(
                    (BookEntity) extras.get(BooksConstants.BOOK_ENTITY_KEY));
            }
        }
    }
}
