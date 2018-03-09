package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.entity;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class BookEntity implements Parcelable{

    private @Getter @Setter String nameofBook;
    private @Getter @Setter String author;
    private @Getter @Setter String imageUrl;
    private @Getter @Setter float rate;
    private @Getter @Setter String description;

    //public BookEntity(String nameofBook, String author, String imageUrl, float rate,
    //    String description) {
    //    this.nameofBook = nameofBook;
    //    this.author = author;
    //    this.imageUrl = imageUrl;
    //    this.rate = rate;
    //    this.description = description;
    //}

    protected BookEntity(Parcel in) {
        nameofBook = in.readString();
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

    //public String getNameofBook() {
    //    return nameofBook;
    //}
    //
    //public String getAuthor() {
    //    return author;
    //}
    //
    //public String getImageUrl() {
    //    return imageUrl;
    //}
    //
    //public float getRate() {
    //    return rate;
    //}
    //
    //public String getDescription() {
    //    return description;
    //}

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameofBook);
        dest.writeString(author);
        dest.writeString(imageUrl);
        dest.writeFloat(rate);
        dest.writeString(description);
    }
}
