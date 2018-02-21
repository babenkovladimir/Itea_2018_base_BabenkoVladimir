package com.example.vladimirbabenko.android_base_homeworks.card;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.vladimirbabenko.android_base_homeworks.R;

public class CustomUserInfoView extends LinearLayout {

    public ImageView ivPhoto;
    public TextView tvName;
    public TextView tvCountry;
    public RatingBar rbRaiting;


    public CustomUserInfoView(Context context) {
        super(context);
    }

    public CustomUserInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout llRoot = (LinearLayout) inflater.inflate(R.layout.custom_user_info_layout, this, true);

        ivPhoto = llRoot.findViewById(R.id.ivPhoto);
        tvName = llRoot.findViewById(R.id.tvName);
        tvCountry = llRoot.findViewById(R.id.tvCountry);
        rbRaiting = llRoot.findViewById(R.id.rbRaitingBar);

        tvName.setText("Some Name");
        tvCountry.setText("Some country");
        rbRaiting.setRating(2.1f);
    }
}
