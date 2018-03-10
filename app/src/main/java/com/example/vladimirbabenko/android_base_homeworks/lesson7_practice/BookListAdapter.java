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
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.squareup.picasso.Picasso;
import java.util.List;
import lombok.Setter;

public class BookListAdapter extends ArrayAdapter<BookEntity> {

    private @Setter List<BookEntity> books;
    private Context context;

    public BookListAdapter(@NonNull Context context, int resource,
        @NonNull List<BookEntity> objects) {
        super(context, resource, objects);
        this.books = objects;
        this.context = context;
    }

    public void addBook(BookEntity book) {
        books.add(book);
        notifyDataSetChanged();
    }

    public void removeBook(int position) {
        books.remove(position);
        notifyDataSetChanged();
    }

    @NonNull @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_book_item, parent, false);
        } else {
            view = convertView;
        }

        ImageView bookImage = (ImageView) view.findViewById(R.id.ivBookLogo);
        TextView nameOfBook = (TextView) view.findViewById(R.id.tvNameOfBook);
        TextView author = (TextView) view.findViewById(R.id.tvAuthorOfBook);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rbRaitingBar);

        Picasso.with(context)
            .load(books.get(position).getImageUrl())
            .placeholder(R.drawable.open_book_logo)
            .error(R.drawable.open_book_logo)
            .fit()
            .into(bookImage);

        nameOfBook.setText(books.get(position).getNameOfBook());
        author.setText(books.get(position).getAuthor());
        ratingBar.setRating(books.get(position).getRate());

        return view;
    }

    public BookEntity getBook(int position) {
        return books.get(position);
    }
}
