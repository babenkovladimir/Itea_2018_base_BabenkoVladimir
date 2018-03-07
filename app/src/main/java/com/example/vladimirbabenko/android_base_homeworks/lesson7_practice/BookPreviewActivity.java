package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class BookPreviewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btBack, btShare;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_preview);

        setupUI();
    }

    private void setupUI() {
        btBack = (Button) findViewById(R.id.btBack);
        btShare = (Button) findViewById(R.id.btShare);
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
