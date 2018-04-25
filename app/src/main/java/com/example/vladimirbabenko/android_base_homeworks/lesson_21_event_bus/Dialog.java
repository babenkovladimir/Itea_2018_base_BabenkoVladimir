package com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vladimirbabenko.android_base_homeworks.IteaApp;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus.event_bus_events.BusExampleEvent;

public class Dialog extends DialogFragment {

    @BindView(R.id.btSendEventBus) Button btSend;

    public static Dialog newInstance() {
        Bundle args = new Bundle();
        Dialog fragment = new Dialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_dialog_event_bus, container, false);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        IteaApp.getBus().register(this);
        ButterKnife.bind(this, getView());
        btSend.setOnClickListener(v->{

            IteaApp.getBus().post(new BusExampleEvent());
            dismiss();
        });

    }

    @Override public void onDestroy() {
        IteaApp.getBus().unregister(this);
        super.onDestroy();
    }
}
