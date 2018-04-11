package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.MainActivity;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.AddBookActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_preview_activity_mvp.BookPreviewActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.fragments.CongratulationDialogKt;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.ItemClickSupport;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class BooksListActivity extends BaseActivity implements IBookListActivity{

    @BindView(R.id.btAddBook) Button btAddBook;
    @BindView(R.id.rvBooksRecyclerView) RecyclerView booksRecyclerView;
    @BindView(R.id.srlSwipeRefresh) SwipeRefreshLayout mSwipeRefreshLayout;
    private static List<BookEntity> books = new ArrayList<>();
    private BookRecycleViewAdapter adapter;

    private BookListActivityPresenter_my mPresenter;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_books_list);// Фича для ButterKnife
        super.onCreate(savedInstanceState);

        mPresenter = new BookListActivityPresenter_my(); // create Instance of
        mPresenter.bind(this, getApplicationContext()); // binding activity to presenter

        setupUI();
        checkAndShowCongratulationFragment();
    }

    private void setupUI() {
        adapter = new BookRecycleViewAdapter(getApplicationContext());
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(
            new LinearLayoutManager(this, LinearLayout.VERTICAL, false));

        mPresenter.showListOfBooks();//

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                Toast.makeText(BooksListActivity.this, "onRegresh", Toast.LENGTH_SHORT).show();

                CountDownTimer timer = new CountDownTimer(3000, 1000) {
                    @Override public void onTick(long millisUntilFinished) {
                    }

                    @Override public void onFinish() {
                        mPresenter.uploadLatestData();
                        //adapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                };
                timer.start();
            }
        });

        ItemClickSupport.addTo(booksRecyclerView)
            .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    Intent intent = new Intent(getApplicationContext(), BookPreviewActivity.class);
                    intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW,
                        adapter.getBooks().get(position));

                    startActivity(intent);
                }
            })
            .setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                    String author = adapter.getBooks().get(position).getAuthor();
                    String nameofBook = adapter.getBooks().get(position).getNameOfBook();

                    AlertDialog.Builder builder = new AlertDialog.Builder(BooksListActivity.this);
                    builder.setMessage(
                        "Are you sure you want remove " + nameofBook + " " + author + "?")
                        .setTitle("Confirmation")
                        .setNeutralButton("no", new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override public void onClick(DialogInterface dialog, int which) {
                                // Presenter do callback to void showListOfBooks(List<BookEntity> list)
                                mPresenter.removeBook(position);
                            }
                        })
                        .setCancelable(false);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                    return true;
                }
            });
    }

    private void checkAndShowCongratulationFragment() {
        CountDownTimer timer= new CountDownTimer(2000, 1000) {
            @Override public void onTick(long millisUntilFinished) {
            }

            @Override public void onFinish() {
                Log.d(TAG, "onFinish: is dialog shown" +mDataManager.getPrefs().isDialogShown());



                if (!mDataManager.getPrefs().isDialogShown()) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                    CongratulationDialogKt.Companion.newInstance(null).show(ft, "Congratulation dialog");
                    //CongratulationDialog.newInstance(null).show(ft, "CongratulationDialog");

                }
            }
        };
        timer.start();
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

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_books, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miLogout:
                mDataManager.getPrefs().clearUserPreferences();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mPresenter.unBind();
    }

    // Имплементация маетода, которая будет вызвана внутри презентер


    @Override public void showInfo() {
        // Do nothick
    }

    /*
    * All manipulyation with data is adapters'responce
    * */
    @Override public void showListOfBooks(List<BookEntity> list) {
        adapter.setBooks(list);
    }
}
