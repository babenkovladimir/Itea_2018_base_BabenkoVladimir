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
import java.util.Random;

public class BooksListActivity extends AppCompatActivity {

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
        "http://sweetpanda.ru/wp-content/uploads/2017/02/stalo-izvestno-kogda-v-moskve-pojavjatsja-bolshie-pandy-sweetpanda.ru-001.jpg",
        "https://media.alienwarearena.com/media/tux-r.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmD3Svo4XWzYSRGCOyoIeXUlY3ZyJ8fI5Wu0bEgTme1_Rka3ttHg",
        "https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg",
        "http://1.bp.blogspot.com/-iwwd_6NUhUs/VmGWkwjrZCI/AAAAAAAAHAk/eZirwqYBS0w/s1600/3d%2Bwallpaper%2Blatest223221%2B%25281%2529.jpg",
        "http://www.uniwallpaper.com/static/images/Wallpaper-10.jpg",
        "https://www.bmw-eg.com/content/dam/bmw/common/all-models/4-series/gran-coupe/2017/images-and-videos/images/BMW-4-series-gran-coupe-images-and-videos-1920x1200-03.jpg.asset.1510606104354.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPqcpjpEqtY2iy9mWTaqF6bvqeWigxJ69B8Oehm6SdNj1ng9v0",
        "http://veralline.com/uploads/images/comparison/2016/01/15/695a303b25.jpg",
        "http://www.kinyu-z.net/data/wallpapers/19/766862.jpg",
        "https://i.ndtvimg.com/i/2018-02/teddy-day-images-pexels-650_650x400_61518152570.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRp0tRJtlX7OswpSRxKj4mUKxfMxo6Nl1_z5UA4xkHjcS3kI7SCYg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZa1PEBTTz2u04Y48fheeayale8cRWo9FMy3Pa8BaTRXO34jDk"
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

        setupUI();
    }

    private void setupUI() {
        booksList = (ListView) findViewById(R.id.lvBooksList);
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
        for (int i = 0; i < AuthtorNames.length; i++) {
            books.add(new BookEntity(AuthtorNames[i], BookNames[i], imageUrls[i], bookRating[i],
                bookDescription[0]));
        }
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
