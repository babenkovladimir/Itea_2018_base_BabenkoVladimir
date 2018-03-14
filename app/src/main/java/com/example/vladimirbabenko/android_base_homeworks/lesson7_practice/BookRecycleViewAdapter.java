package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.interfaces.IItemClickListner;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.interfaces.IItemLongClickListner;
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
            @Override public void onClick(View view, int position) {
                Intent intent = new Intent(mContext, BookPreviewActivity.class);
                intent.putExtra(BooksConstants.BOOK_ENTITY_KEY_PREVIEW, books.get(position));
                mContext.startActivity(intent);
            }
        });

        holder.setItemLongClickListner(new IItemLongClickListner() {
            @Override public void onClick(View view, int position) {
                String author = books.get(position).getAuthor();
                String nameofBook = books.get(position).getNameOfBook();

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(
                    "Are you sure you want remove " + nameofBook + " " + author + "?")
                    .setTitle("Confirmation")
                    .setNeutralButton("no", new DialogInterface.OnClickListener() {
                        @Override public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override public void onClick(DialogInterface dialog, int which) {
                            books.remove(position);
                            notifyDataSetChanged();
                        }
                    })
                    .setCancelable(false);

                AlertDialog dialog = builder.create();
                dialog.show();
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
        private IItemLongClickListner itemLongClickListner;

        public BookHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListner(IItemClickListner itemClickListner) {
            this.itemClickListner = itemClickListner;
        }

        public void setItemLongClickListner(IItemLongClickListner itemLongClickListner) {
            this.itemLongClickListner = itemLongClickListner;
        }

        @Override public void onClick(View view) {
            itemClickListner.onClick(view, getAdapterPosition());
        }

        @Override public boolean onLongClick(View view) {
            itemLongClickListner.onClick(view, getAdapterPosition());
            return true;
        }
    }
}
