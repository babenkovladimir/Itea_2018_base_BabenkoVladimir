package com.example.vladimirbabenko.android_base_homeworks.lesson6CalssMaterial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.vladimirbabenko.android_base_homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<CountryLess6> {

    private Context context;
    private List<CountryLess6> contries = new ArrayList<>();

    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull List<CountryLess6> objects) {
        super(context, resource, objects);
        this.context = context;
        this.contries = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = null;

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.item_layout_custom, parent, false);
        } else rootView = convertView;

        TextView textView = rootView.findViewById(R.id.tvTextView);
        textView.setText(contries.get(position).getCountryName());

        // Vrong way to setOnClickListner

        Button button = (Button)rootView.findViewById(R.id.btButton);
        button.setOnClickListener(view ->{
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://ru.wikipedia.org/wiki/"+contries.get(position).getCountryName()));
            context.startActivity(i);
        });

        return rootView;
    }

    public List<CountryLess6> getContries() {
        return contries;
    }
}
