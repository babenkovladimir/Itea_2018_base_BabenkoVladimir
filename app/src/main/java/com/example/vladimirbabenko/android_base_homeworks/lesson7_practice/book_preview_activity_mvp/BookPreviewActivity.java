package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_preview_activity_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import com.squareup.picasso.Picasso;

public class BookPreviewActivity extends BaseActivity implements IBookPreviewActivity{

    @BindView(R.id.tvBookDescription) TextView tvBookDescription;
    @BindView(R.id.customPreview) View includeView;
    @BindView(R.id.tvNameOfBook) TextView tvBookName;

    @BindView(R.id.tvAuthorOfBook) TextView tvBookAuthor;
    @BindView(R.id.rbRaitingBar) RatingBar rbBookRate;
    @BindView(R.id.ivBookLogo) ImageView ivBookImage;

    private BookEntity book;

    private BookPreviewPresenter mPresenter; // Add presenter variable to View

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_book_preview);
        super.onCreate(savedInstanceState);

        ButterKnife.bind(includeView);
        mPresenter = new BookPreviewPresenter();// Create Presenter instance
        mPresenter.bind(this);// Binding this activity to presenter

        //mPresenter.fillForm();
    }

    @OnClick(R.id.btBack) public void btBackOnClick(View v) {
        onBackPressed();
    }

    @OnClick(R.id.btShare) public void btShareClick() {
        if (book != null) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                "Book author - " + book.getAuthor() + "Name of Book - " + book.getNameOfBook());
            shareIntent.setType("text/plain");
            startActivity(shareIntent);
        }
    }
    @Override // Имплементация интерфейса этого активити
    public void fillForm() {
        Bundle bundle = getIntent().getExtras(); // Probably needs try/catch

        if (bundle != null && bundle.containsKey(BooksConstants.BOOK_ENTITY_KEY_PREVIEW)) {
            book = bundle.getParcelable(BooksConstants.BOOK_ENTITY_KEY_PREVIEW);
            tvBookName.setText(book.getNameOfBook());
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

    @Override protected void onDestroy() {
        super.onDestroy();
        mPresenter.unBind();// unBind
    }

    @Override public void showInfo() {
        // simple test void from IView_my interface
    }
}
