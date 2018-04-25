package com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson_21_event_bus.event_bus_events.BusExampleEvent;
import com.squareup.otto.Subscribe;

public class EventBusParenActivity extends BaseActivity {

    @BindView(R.id.tvFromEventBus) TextView tvFromEvenBus;
    @BindView(R.id.btShowDialog) Button btShowDialog;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_event_bus_paren);
        super.onCreate(savedInstanceState);

        btShowDialog.setOnClickListener(v->{
            Dialog dialog = Dialog.newInstance();
            FragmentManager manager = EventBusParenActivity.this.getSupportFragmentManager();
            dialog.show(manager, "Event bus dialog");
        });
    }

    @Subscribe public void onBusEvent(BusExampleEvent event){
        tvFromEvenBus.setText("After getting from event Bus");
    }

}
