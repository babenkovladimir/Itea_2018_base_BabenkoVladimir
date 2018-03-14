package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;

public class AddBookActivity extends BaseActivity {

    @BindView(R.id.etBookName) EditText etBookName;
    @BindView(R.id.etBookAuthor) EditText etBookAuthor;
    @BindView(R.id.etBookDescription) EditText etBookDescription;
    @BindView(R.id.rbBookRate) RatingBar rbBookRate;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add_book);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btBackPreview) public void btBackPreviewClick(View v) {
        onBackPressed();
    }

    @OnClick(R.id.btSavePreview) public void btSavePreviweClick(View v) {
        BookEntity book =
            new BookEntity(etBookName.getText().toString(), etBookAuthor.getText().toString(),
                "http://demo.makitweb.com/broken_image/images/noimage.png", rbBookRate.getRating(),
                etBookDescription.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(BooksConstants.BOOK_ENTITY_KEY, book);
        setResult(RESULT_OK, intent);
        finish();
    }

}
