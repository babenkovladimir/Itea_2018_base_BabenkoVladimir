package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.book_preview_activity_mvp;

public class BookPreviewPresenter {

    private BookPreviewActivity view;

    public void bind(BookPreviewActivity v){
        this.view = v;
    }
    public void unBind(){
        this.view = null;
    }

    public void fillForm(){

    }
}
