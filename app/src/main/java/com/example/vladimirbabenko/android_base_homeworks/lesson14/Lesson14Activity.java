package com.example.vladimirbabenko.android_base_homeworks.lesson14;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.utils.BooksConstants;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.Random;

public class Lesson14Activity extends BaseActivity {

    private ValidAsynckTask mAsynckTask;
    private ValidHandler mHandler;

    @BindView(R.id.etTextTobreak) EditText textToBreak;
    @BindView(R.id.tvShowHackedText) TextView mTextViewHackedText;
    @BindView(R.id.tvShowTimeOfHack) TextView mTextViewHackedTextTime;
    @BindView(R.id.tvShowHackedTextByHandler) TextView tvShowHackedTextByHandler;
    @BindView(R.id.tvShowTimeOfHackByHandler) TextView tvShowTimeOfHackByHandler;
    @BindView(R.id.btHack) Button btHack;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lesson14);
        super.onCreate(savedInstanceState);

        //  do with AsynckTask
        mAsynckTask = (ValidAsynckTask) getLastCustomNonConfigurationInstance();
        if (mAsynckTask != null) {
            mAsynckTask.link(this);
        }
        mHandler = new ValidHandler(this);
    }

    /*
     * This void contains new Thread and mHandler link. Here i sand a message to my mHandler
     * */
    private void startHack(String stroka) {

        new Thread(new Runnable() {
            @Override public void run() {
                int indexHacking = 0;
                int hackTimeRezult = 0;
                StringBuilder stringBuilder = new StringBuilder();

                while (indexHacking < stroka.length()) {
                    for (char c = '\u0000'; c < 'z'; c++) {
                        if (c == stroka.charAt(indexHacking)) {
                            try {
                                int hackTimeCurrent = new Random().nextInt(500);
                                hackTimeRezult += hackTimeCurrent;
                                Thread.sleep(hackTimeCurrent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            stringBuilder.append(c);
                        }
                    }
                    for (int i = 1; i < 10; i++) {
                        if ((char) i == stroka.charAt(indexHacking)) {
                            try {
                                int hackTimeCurrent = new Random().nextInt(500);
                                hackTimeRezult += hackTimeCurrent;
                                Thread.sleep(hackTimeCurrent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            stringBuilder.append(i);
                        }
                    }
                    indexHacking++;

                    Message message = new Message();// Only new Message
                    Bundle data = new Bundle();

                    data.putInt(BooksConstants.HACK_TIME_REZULT, hackTimeRezult);
                    data.putString(BooksConstants.HACK_REZULT, stringBuilder.toString());

                    message.setData(data);
                    mHandler.sendMessage(message);
                }
            }
        }).start();
    }

    @OnClick(R.id.btHack) public void hack() {
        mAsynckTask = new ValidAsynckTask();
        mAsynckTask.link(this);
        mAsynckTask.execute(textToBreak.getText().toString());
        // Start hacking by Handler
        startHack(textToBreak.getText().toString());
    }

    /*
     * onRetainCustomNonConfigurationInstance - for AppCompatActivity
     * onRetainNonConfigurationInstance - for Activity
     * */
    @Override public Object onRetainCustomNonConfigurationInstance() {
        mAsynckTask.link(this);
        return mAsynckTask;
    }

    @Override protected void onDestroy() {
        //mHandler.removeCallbacks();// если Handler.post или Handler.postDelayed
        super.onDestroy();
    }

    static class ValidAsynckTask extends AsyncTask<String, String, Integer> {

        WeakReference<Lesson14Activity> activity;

        // получаем ссылку на
        void link(Lesson14Activity act) {
            activity = new WeakReference<>(act);
        }

        // обнуляем ссылку
        void unLink() {
            //activity = null
            activity.clear();
        }

        @Override protected void onPreExecute() {
            super.onPreExecute();
            Log.wtf("MyAsyncTask", "onPreExecute: ");
        }

        @Override protected Integer doInBackground(String... needToHackString) {
            Log.d("TAG", "doInBackground: string from class " + needToHackString[0]);

            int indexHacking = 0;
            int hackTimeRezult = 0;
            String hackRezult = "";

            while (indexHacking < needToHackString[0].length()) {
                for (char c = '\u0000'; c < 'z'; c++) {
                    if (c == needToHackString[0].charAt(indexHacking)) {
                        try {
                            int hackTimeCurrent = new Random().nextInt(500);
                            hackTimeRezult += hackTimeCurrent;
                            Thread.sleep(hackTimeCurrent);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        hackRezult = hackRezult + c;
                        publishProgress(hackRezult);
                    }
                }
                for (int i = 1; i < 10; i++) {
                    if ((char) i == needToHackString[0].charAt(indexHacking)) {
                        try {
                            int hackTimeCurrent = new Random().nextInt(500);
                            hackTimeRezult += hackTimeCurrent;
                            Thread.sleep(hackTimeCurrent);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        hackRezult = hackRezult + (char) i;
                        publishProgress(hackRezult);
                    }
                }
                indexHacking++;
            }
            return hackTimeRezult;
        }

        @Override protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.wtf("MyAsyncTask", "OnProgressUpdate" + values[0]);
            activity.get().mTextViewHackedText.setText(values[0]);
        }

        @Override protected void onCancelled() {
            super.onCancelled();
            Log.wtf("MyAsyncTask", "onCanceled");
        }

        @Override protected void onPostExecute(Integer hackedTime) {
            super.onPostExecute(hackedTime);
            Log.wtf("MyAsyncTask", "onPostExecute: " + hackedTime);
            activity.get().mTextViewHackedTextTime.setText(String.valueOf(hackedTime));
        }
    }

    static class ValidHandler extends Handler {

        // Params
        WeakReference<Lesson14Activity> wrActivity;

        // Constructor
        public ValidHandler(Lesson14Activity activity) {
            wrActivity = new WeakReference<Lesson14Activity>(activity);
        }

        @Override public void handleMessage(Message msg) {
            Lesson14Activity activity = wrActivity.get();
            Bundle bundle = msg.getData();

            if (bundle.containsKey(BooksConstants.HACK_TIME_REZULT)) {
                activity.tvShowTimeOfHackByHandler.setText(
                    String.valueOf(bundle.getInt(BooksConstants.HACK_TIME_REZULT)));
            }

            if (bundle.containsKey(BooksConstants.HACK_REZULT)) {
                activity.tvShowHackedTextByHandler.setText(
                    bundle.getString(BooksConstants.HACK_REZULT));
            }
        }
    }
}
