package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @ToString public class BookEntity implements Parcelable {

    private @Getter @Setter String nameOfBook;
    private @Getter @Setter String author;
    private @Getter @Setter String imageUrl;
    private @Getter @Setter float rate;
    private @Getter @Setter String description;

    protected BookEntity(Parcel in) {
        nameOfBook = in.readString();
        author = in.readString();
        imageUrl = in.readString();
        rate = in.readFloat();
        description = in.readString();
    }

    public static final Creator<BookEntity> CREATOR = new Creator<BookEntity>() {
        @Override public BookEntity createFromParcel(Parcel in) {
            return new BookEntity(in);
        }

        @Override public BookEntity[] newArray(int size) {
            return new BookEntity[size];
        }
    };

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameOfBook);
        dest.writeString(author);
        dest.writeString(imageUrl);
        dest.writeFloat(rate);
        dest.writeString(description);
    }
}
