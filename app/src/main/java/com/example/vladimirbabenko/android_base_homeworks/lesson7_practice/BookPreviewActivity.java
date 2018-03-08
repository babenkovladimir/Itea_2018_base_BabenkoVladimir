package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;

public class BookPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvBookName, tvBookAuthor, tvBookDescription;
    private RatingBar rbBookRate;
    private ImageView ivBookImage;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_preview);

        setupUI();
        fillForm();
    }

    private void setupUI() {
        findViewById(R.id.btBack).setOnClickListener(this);
        findViewById(R.id.btShare).setOnClickListener(this);

        View includeView = (View) findViewById(R.id.customPreview);
        tvBookName = (TextView) includeView.findViewById(R.id.tvNameOfBook);
        tvBookAuthor = (TextView) includeView.findViewById(R.id.tvAuthorofBook);
        rbBookRate = (RatingBar) includeView.findViewById(R.id.rbRaitingBar);
        tvBookDescription = (TextView) findViewById(R.id.tvBookDescription);
        ivBookImage = (ImageView) findViewById(R.id.ivImageView);
    }

    private void fillForm() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(BooksConstants.BOOK_ENTITY_KEY_PREVIEW)) {
            BookEntity book = bundle.getParcelable(BooksConstants.BOOK_ENTITY_KEY_PREVIEW);
            tvBookName.setText(book.getNameofBook());
            tvBookAuthor.setText(book.getAuthor());
            tvBookDescription.setText(book.getDescription());
            rbBookRate.setRating(book.getRate());
        }
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btBack:
                onBackPressed();
                break;
            case R.id.btShare:
                //TODO share info
                break;
        }
    }
}
