package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;
import com.example.vladimirbabenko.android_base_homeworks.R;
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
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Aliquam ultrices sagittis orci a scelerisque purus semper eget. Fermentum posuere urna nec tincidunt praesent. Mi eget mauris pharetra et ultrices neque ornare. Volutpat lacus laoreet non curabitur gravida arcu ac tortor dignissim. Egestas sed sed risus pretium quam. Vitae aliquet nec ullamcorper sit amet risus nullam eget. Fames ac turpis egestas integer eget. Morbi quis commodo odio aenean sed adipiscing diam donec adipiscing. Nibh tortor id aliquet lectus proin nibh nisl. Ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi. Eros in cursus turpis massa tincidunt dui ut. Etiam non quam lacus suspendisse. Montes nascetur ridiculus mus mauris vitae ultricies. Amet aliquam id diam maecenas ultricies mi. Vitae congue mauris rhoncus aenean vel elit. Posuere sollicitudin aliquam ultrices sagittis orci.",
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
                bookDescription[i]));
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
