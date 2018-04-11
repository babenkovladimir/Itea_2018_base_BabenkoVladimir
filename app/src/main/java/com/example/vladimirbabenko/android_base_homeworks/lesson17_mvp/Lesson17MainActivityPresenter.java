package com.example.vladimirbabenko.android_base_homeworks.lesson17_mvp;

public class Lesson17MainActivityPresenter extends BasePresenter<ILesson17MainActivityView> implements IMainActivityPresenter {

    //private ILesson17MainActivityView view;


    //public void bind(ILesson17MainActivityView iMainActivityView) {
    //    this.view = iMainActivityView;
    //}
    //
    //public void unBind(){
    //    this.view = null;
    //}
    @Override
    public void fetchMocks() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //view.showMocks("P R E S E N T E R S   T E X T !!! ");
        getV().showMocks("P R E S E N T E R S   T E X T !!! ");
    }
}
