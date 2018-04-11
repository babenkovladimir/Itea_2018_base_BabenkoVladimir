package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.base_mvp;

import android.content.Context;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/*
 * Джеререзированный класс. Работает только с конкретным типом интерфейсов
 * */
// Передаётся view, с которой будет вестись работа
public abstract class BasePresenter_my<V extends IView_my> {

    private @Nullable @Getter V v;
    private @Nullable @Getter Context context;

    public void bind(V v, Context context){
        this.v =v;
        this.context = context;
    }

    public void bind(V v) {
        this.v = v;
    }

    public void unBind() {
        this.v = null;
    }
}
