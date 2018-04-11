package com.example.vladimirbabenko.android_base_homeworks.lesson17_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.Toast;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial.Country;
import java.util.List;

public class Lesson17MainActivity extends AppCompatActivity implements ILesson17MainActivityView{

    private Lesson17MainActivityPresenter mPresenter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson17);

        mPresenter = new Lesson17MainActivityPresenter();
        mPresenter.bind(this);

        findViewById(R.id.btPresentersAction).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mPresenter.fetchMocks();
            }
        });


    }

    @Override public void showMocks(String forToast) {
        Toast.makeText(this, "This is for toast - " + forToast , Toast.LENGTH_SHORT).show();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mPresenter.unBind();
    }


    /*
    * Сами решаем что делать в этом методе
    * */
    @Override public void showText() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
