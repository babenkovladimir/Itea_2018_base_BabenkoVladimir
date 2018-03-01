package com.example.vladimirbabenko.android_base_homeworks.lesson5ClassMaterial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vladimirbabenko.android_base_homeworks.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VladimirBabenko on 3/1/2018.
 */

public class CustomAdapter extends ArrayAdapter<Country> {
    private Context context;
    private List<Country> countries = new ArrayList<>();

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Country> objects) {
        super(context, resource, objects);
        this.context = context;
        this.countries = objects;
    }

    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rootView = null;
        //LayoutInflater inflater =
        //    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //
        //rootView = inflater.inflate(R.layout.item_layout_custom, parent, false);
        //
        //TextView countryName = (TextView) rootView.findViewById(R.id.tvTextView);
        //countryName.setText(countries.get(position));

        if (convertView == null) {
            Log.w("getView", "temp: " + position);
            LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.item_layout_custom, parent, false);
        } else {
            rootView = convertView;
        }

        TextView countryName = (TextView) rootView.findViewById(R.id.tvTextView);
        countryName.setText(countries.get(position).getCountryName());

        ImageView imageView = rootView.findViewById(R.id.ivImageView);
        imageView.setImageResource(countries.get(position).getFlag());

        Button buttonWiki = (Button) rootView.findViewById(R.id.btButton);
        buttonWiki.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("https://ru.wikipedia.org/wiki/" + countries.get(position));
            intent.setData(uri);
            context.startActivity(intent);
        });

        return rootView;
    }
}
