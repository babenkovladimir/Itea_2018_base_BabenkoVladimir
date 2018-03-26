package com.example.vladimirbabenko.android_base_homeworks.lesson12;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.vladimirbabenko.android_base_homeworks.R;

public class TestDialogFragment extends DialogFragment {

    private final String TAG = "TAG";

    public TestDialogFragment() { // Обязательно
    }

    public static TestDialogFragment newInstance(Bundle bundle) {
        Log.d("TAG", "newInstance: ");
        TestDialogFragment fragment = new TestDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    /*
    * Плохая практика
    * */

    //@SuppressLint("ValidFragment") public TestDialogFragment(String string){
    //
    //}

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        View view = inflater.inflate(R.layout.fragment_test_dialog, container, false);
        return view;
    }

    /*
    * Доставать значение надо именно таким методом
    * */

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Log.d(TAG, "onCreate: ");
        //this.userName = bundle.getString("userName");
    }

    @Override public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
    }

    @Override public void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override public void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override public void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override public void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override public void onDetach() {
        Log.d(TAG, "onDetach: ");
        super.onDetach();
    }
    /*
    * можно запустить тайме или типа того
    * */
    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
    }
}
