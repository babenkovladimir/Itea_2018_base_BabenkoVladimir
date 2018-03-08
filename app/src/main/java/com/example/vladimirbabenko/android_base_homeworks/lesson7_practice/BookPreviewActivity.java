package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Intent;
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
import com.squareup.picasso.Picasso;

public class BookPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvBookName, tvBookAuthor, tvBookDescription;
    private RatingBar rbBookRate;
    private ImageView ivBookImage;
    private BookEntity book;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_preview);

        setupUI();
        fillForm();
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btBack:
                onBackPressed();
                break;
            case R.id.btShare:
                if(book!=null){
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Book author - "+book.getAuthor()+ "Name of Book - "+ book.getNameofBook());
                    shareIntent.setType("text/plain");
                    startActivity(shareIntent);}
                break;
        }
    }

    private void setupUI() {
        findViewById(R.id.btBack).setOnClickListener(this);
        findViewById(R.id.btShare).setOnClickListener(this);

        View includeView = (View) findViewById(R.id.customPreview);
        tvBookName = (TextView) includeView.findViewById(R.id.tvNameOfBook);
        tvBookAuthor = (TextView) includeView.findViewById(R.id.tvAuthorofBook);
        rbBookRate = (RatingBar) includeView.findViewById(R.id.rbRaitingBar);
        ivBookImage = (ImageView)includeView.findViewById(R.id.ivBookLogo);
        tvBookDescription = (TextView) findViewById(R.id.tvBookDescription);
    }

    private void fillForm() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(BooksConstants.BOOK_ENTITY_KEY_PREVIEW)) {
            book = bundle.getParcelable(BooksConstants.BOOK_ENTITY_KEY_PREVIEW);
            tvBookName.setText(book.getNameofBook());
            tvBookAuthor.setText(book.getAuthor());
            tvBookDescription.setText(book.getDescription());
            rbBookRate.setRating(book.getRate());
            Picasso.with(getApplicationContext())
                .load(book.getImageUrl())
                .placeholder(R.drawable.open_book_logo)
                .error(R.drawable.open_book_logo)
                .fit()
                .into(ivBookImage);
        }
    }

}
