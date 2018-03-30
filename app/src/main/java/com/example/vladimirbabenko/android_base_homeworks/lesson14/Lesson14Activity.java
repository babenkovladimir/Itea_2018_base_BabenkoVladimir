package com.example.vladimirbabenko.android_base_homeworks.lesson14;

import android.os.AsyncTask;
import android.os.BaseBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;
import java.util.Random;

public class Lesson14Activity extends BaseActivity {

    private ValidAsynckTask mAsynckTask;

    @BindView(R.id.etTextTobreak) EditText textToBreak;
    @BindView(R.id.tvShowHackedText) TextView mTextViewHackedText;
    @BindView(R.id.tvShowTimeOfHack) TextView mTextViewHackedTextTime;
    @BindView(R.id.btHack) Button btHack;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lesson14);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btHack) public void hack() {
        mAsynckTask = new ValidAsynckTask();
        mAsynckTask.execute(textToBreak.getText().toString());
    }

    class ValidAsynckTask extends AsyncTask<String, String, Integer> {

        @Override protected void onPreExecute() {
            super.onPreExecute();
            Log.wtf("MyAsyncTask", "onPreExecute: ");
        }

        @Override protected Integer doInBackground(String... needToHackString) {
            Log.d(TAG, "doInBackground: string from class "+ needToHackString);

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
                    if ((char)i == needToHackString[0].charAt(indexHacking)) {
                        try {
                            int hackTimeCurrent = new Random().nextInt(500);
                            hackTimeRezult += hackTimeCurrent;
                            Thread.sleep(hackTimeCurrent);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        hackRezult = hackRezult + (char)i;
                        publishProgress(hackRezult);
                    }
                }
                indexHacking++;
            }
            return  hackTimeRezult;
        }

        @Override protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.wtf("MyAsyncTask", "OnProgressUpdate" + values[0]);
            mTextViewHackedText.setText(values[0]);
        }

        @Override protected void onCancelled() {
            super.onCancelled();
            Log.wtf("MyAsyncTask", "onCanceled");
        }

        @Override protected void onPostExecute(Integer hackedTime) {
            super.onPostExecute(hackedTime);
            Log.wtf("MyAsyncTask", "onPostExecute: " + hackedTime);
            mTextViewHackedTextTime.setText(String.valueOf(hackedTime));
        }
    }
}
