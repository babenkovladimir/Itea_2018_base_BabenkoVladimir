package com.example.vladimirbabenko.android_base_homeworks.lesson4ClassMaterial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.vladimirbabenko.android_base_homeworks.R;

import java.util.Calendar;

public class IntentExampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents_examples);

        setupUI();
    }

    private void setupUI() {

        Button btAlarmClock = findViewById(R.id.btAlarmClock);
        Button btTimer = findViewById(R.id.btSetTimer);
        Button btShowAllAlarms = findViewById(R.id.btShowAllAlarms);
        Button btAddCalendarEvent = findViewById(R.id.btAddCalendarEvent);
        Button btCalendarTestEvent = findViewById(R.id.btCalendarTestEvent);
        Button btOpenSomeSettings = findViewById(R.id.btOpenSomeSettings);
        Button btInitiateAPhoneCall_ActionDial = findViewById(R.id.btInitiateAPhoneCall_ActionDial);
        Button btInitiateAPhoneCall_ActionCall = findViewById(R.id.btInitiateAPhoneCall_ActionCall);


        btAlarmClock.setOnClickListener(v -> createAlarm("My alarm message", 18, 15));
        btTimer.setOnClickListener(v -> startTimer("The Time is come", 15));
        btShowAllAlarms.setOnClickListener(v -> startActivity(new Intent(AlarmClock.ACTION_SHOW_ALARMS)));
        btAddCalendarEvent.setOnClickListener(v -> addCalendarEvent("Birthday", "Kiev", System.currentTimeMillis(), SystemClock.currentThreadTimeMillis() + 10000));
        btCalendarTestEvent.setOnClickListener(v -> calendarTest());
        btOpenSomeSettings.setOnClickListener(v -> callSomeSettings());
        btInitiateAPhoneCall_ActionDial.setOnClickListener(v-> initiateDial());
        btInitiateAPhoneCall_ActionCall.setOnClickListener(v-> initiateCall());

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

    public void addCalendarEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
            .setData(CalendarContract.Events.CONTENT_URI)
            .putExtra(CalendarContract.Events.TITLE, title)
            .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void calendarTest() {
        Intent intent = new Intent();
        Calendar cal = Calendar.getInstance();
        intent.setAction(Intent.ACTION_EDIT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "A Test Event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
            cal.getTimeInMillis() + 60 * 60 * 1000);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");
        startActivity(intent);
    }

    public void callSomeSettings() {
        Intent intent = new Intent();
        //intent.setAction(Settings.ACTION_ADD_ACCOUNT);
        //intent.setAction(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        //intent.setAction(Settings.ACTION_BLUETOOTH_SETTINGS);
        intent.setAction(Settings.ACTION_DISPLAY_SETTINGS);
        //intent.setAction(Settings.ACTION_NFC_SETTINGS);
        //intent.setAction(Settings.ACTION_ADD_ACCOUNT);

        startActivity(intent);
    }
    private void initiateCall(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:+380508668370");
        intent.setData(uri);

        startActivity(intent);
    }

    private void initiateDial(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:+380508668370");
        intent.setData(uri);

        startActivity(intent);
    }
}
