package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.vladimirbabenko.android_base_homeworks.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookListAdapter extends ArrayAdapter<BookEntity> {

    private List<BookEntity> books;
    private Context context;

    public BookListAdapter(@NonNull Context context, int resource,
                           @NonNull List<BookEntity> objects) {
        super(context, resource, objects);
        this.books = objects;
        this.context = context;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view =
            null;//= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_book_item, parent, false);

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_book_item, parent, false);
        } else {
            view = convertView;
        }

        ImageView bookImage = (ImageView) view.findViewById(R.id.ivBookLogo);
        TextView nameOfBook = (TextView) view.findViewById(R.id.tvNameOfBook);
        TextView author = (TextView) view.findViewById(R.id.tvAuthorofBook);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rbRaitingBar);

        // TODO use glide or picass for image

        nameOfBook.setText(books.get(position).getNameofBook());
        author.setText(books.get(position).getAuthor());
        ratingBar.setRating(books.get(position).getRate());

//        Picasso.with(context)
//            .load(books.get(position).getImageUrl())
//            .placeholder(R.drawable.open_book_logo)
//            .error(R.drawable.open_book_logo)
//            .centerCrop()
//            .into(bookImage);

        return view;
    }
}
