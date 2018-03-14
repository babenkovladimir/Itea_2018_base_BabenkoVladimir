package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils;

import android.content.Context;
import android.content.Intent;
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
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.BookPreviewActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity.BookEntity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
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

    @Override public void onBindViewHolder(BookHolder holder, int position) {
        holder.tvNameOfBook.setText(books.get(position).getNameOfBook());
        holder.tvAuthorOfBook.setText(books.get(position).getAuthor());
        holder.rbRaitingBar.setRating(books.get(position).getRate());

        Picasso.with(mContext)
            .load(books.get(position).getImageUrl())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fit()
            .into(holder.ivBookLogo);

        holder.setItemClickListner(new IItemClickListner() {
            @Override public void onClick(View v, int position, boolean isLongClick) {
                if (isLongClick) {
                    books.remove(position);
                    notifyDataSetChanged();
                } else {
                    Intent intent = new Intent(mContext, BookPreviewActivity.class);
                    intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW, books.get(position));
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<BookEntity> newBooks) {
        books.clear();
        books.addAll(newBooks);
        notifyDataSetChanged();
    }

    public void addBook(BookEntity newBook) {
        books.add(newBook);
        notifyDataSetChanged();
    }

    public BookEntity getBook(int position) {
        return books.get(position);
    }

    /*
    * BookHolder
    * */
    static class BookHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.ivBookLogo) ImageView ivBookLogo;
        @BindView(R.id.tvNameOfBook) TextView tvNameOfBook;
        @BindView(R.id.tvAuthorOfBook) TextView tvAuthorOfBook;
        @BindView(R.id.rbRaitingBar) RatingBar rbRaitingBar;

        private IItemClickListner itemClickListner;

        public BookHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListner(IItemClickListner itemClickListner) {
            this.itemClickListner = itemClickListner;
        }

        @Override public void onClick(View v) {
            itemClickListner.onClick(v, getAdapterPosition(), false);
        }

        @Override public boolean onLongClick(View v) {
            itemClickListner.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}
