package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etBookName, etBookAuthor, etBookDescription;
    private RatingBar rbBookRate;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        setupUI();
    }

    private void setupUI() {
        findViewById(R.id.btBackPreview).setOnClickListener(this);
        findViewById(R.id.btSavePreview).setOnClickListener(this);

        etBookName = (EditText) findViewById(R.id.etBookName);
        etBookAuthor = (EditText) findViewById(R.id.etBookAuthor);
        etBookDescription = (EditText) findViewById(R.id.etBookDescription);
        rbBookRate = (RatingBar) findViewById(R.id.rbBookRate);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btBackPreview:
                onBackPressed();
                break;
            case R.id.btSavePreview:
                BookEntity
                    book = new BookEntity(etBookName.getText().toString(), etBookAuthor.getText().toString(), "",
                    rbBookRate.getRating(), etBookDescription.getText().toString());

                Intent intent = new Intent();
                intent.putExtra(BooksConstants.BOOK_ENTITY_KEY, book);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
