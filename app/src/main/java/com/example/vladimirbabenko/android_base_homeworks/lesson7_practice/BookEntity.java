package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice;

public class BookEntity {

    private String nameofBook;
    private String author;
    private String imageUrl;
    private float rate;
    private String description;

    public BookEntity(String nameofBook, String author, String imageUrl, float rate,
        String description) {
        this.nameofBook = nameofBook;
        this.author = author;
        this.imageUrl = imageUrl;
        this.rate = rate;
        this.description = description;
    }

    public String getNameofBook() {
        return nameofBook;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }
}
