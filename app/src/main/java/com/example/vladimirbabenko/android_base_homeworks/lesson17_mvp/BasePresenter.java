package com.example.vladimirbabenko.android_base_homeworks.lesson17_mvp;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

public abstract class BasePresenter<V extends IView> {
    @Nullable @Getter private V v;

    public void bind(V v){
        this.v = v;
    }

    public void unBind(){
        v = null;
    }
}
