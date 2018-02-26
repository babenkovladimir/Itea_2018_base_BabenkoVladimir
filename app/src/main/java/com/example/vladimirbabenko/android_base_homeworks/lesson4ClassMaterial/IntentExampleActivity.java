package com.example.vladimirbabenko.android_base_homeworks.lesson4ClassMaterial;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.example.vladimirbabenko.android_base_homeworks.R;

/**
 * Created by VladimirBabenko on 2/25/2018.
 */

public class IntentExampleActivity extends AppCompatActivity {



    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents_examples);

        setupUI();
    }

    private void setupUI() {

        Button btAlarmClock = findViewById(R.id.btAlarmClock);
        Button btTimer = findViewById(R.id.btSetTimer);
        Button btShowAllAlarms = findViewById(R.id.btShowAllAlarms);


        btAlarmClock.setOnClickListener(v-> createAlarm("My alarm message", 18,15));
        btTimer.setOnClickListener(v-> startTimer("The Time is come", 15));
        btShowAllAlarms.setOnClickListener(v-> startActivity(new Intent(AlarmClock.ACTION_SHOW_ALARMS)));
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
            .putExtra(AlarmClock.EXTRA_HOUR, hour)
            .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
            .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
