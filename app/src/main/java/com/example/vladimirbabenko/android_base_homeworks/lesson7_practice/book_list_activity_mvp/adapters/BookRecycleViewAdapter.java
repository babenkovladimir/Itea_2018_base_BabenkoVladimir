package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_list_activity_mvp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRecycleViewAdapter
    extends RecyclerView.Adapter<BookRecycleViewAdapter.BookHolder> {
    private List<BookEntity> books = new ArrayList<>();
    private Context mContext;

    public BookRecycleViewAdapter(Context context) {
        mContext = context;
    }

    @Override public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.custom_book_item, parent, false);
        return new BookRecycleViewAdapter.BookHolder(v);
    }

    /*
     *  JakeWharton commented on 9 Mar 2015
     *  You can filter empty URLs to null before passing them to Picasso.
     * */
    @Override public void onBindViewHolder(BookHolder holder, int position) {
        holder.tvNameOfBook.setText(books.get(position).getNameOfBook());
        holder.tvAuthorOfBook.setText(books.get(position).getAuthor());
        holder.rbRaitingBar.setRating(books.get(position).getRate());

        if (books.get(position).getImageUrl().isEmpty() || (books.get(position).getImageUrl()
            == null)) {

            Picasso.with(mContext)
                .load(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.ivBookLogo);
        } else {
            Picasso.with(mContext)
                .load(books.get(position).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.ivBookLogo);
        }
    }

    @Override public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<BookEntity> newBooks) {
        books.clear();
        books.addAll(newBooks);
        Collections.reverse(books);
        notifyDataSetChanged();
    }

    public void addBook(BookEntity newBook) {
        books.add(newBook);
        notifyDataSetChanged();
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    /*
     * BookHolder
     * */
    static class BookHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivBookLogo) ImageView ivBookLogo;
        @BindView(R.id.tvNameOfBook) TextView tvNameOfBook;
        @BindView(R.id.tvAuthorOfBook) TextView tvAuthorOfBook;
        @BindView(R.id.rbRaitingBar) RatingBar rbRaitingBar;

        public BookHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
