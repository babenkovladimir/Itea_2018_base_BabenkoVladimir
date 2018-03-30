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

public class Lesson14Activity extends BaseActivity {

    private ValidAsynckTask mAsynckTask;

    @BindView(R.id.etTextTobreak) EditText textToBreak;
    @BindView(R.id.tvShowHackedText) TextView mTextView;
    @BindView(R.id.btHack) Button btHack;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lesson14);
        super.onCreate(savedInstanceState);

        //int toHack = Integer.valueOf(textToBreak.getText().toString());
        //
        //mAsynckTask = new ValidAsynckTask();
        //mAsynckTask.execute(toHack);
    }

    @OnClick(R.id.btHack) public void hack() {
        //int toHack = Integer.valueOf(textToBreak.getText().toString());
        mAsynckTask = new ValidAsynckTask();
        mAsynckTask.execute(textToBreak.getText().toString());
    }

    class ValidAsynckTask extends AsyncTask<String, String, String> {

        @Override protected void onPreExecute() {
            Log.wtf("MyAsyncTask", "onPreExecute: ");
            super.onPreExecute();
        }

        @Override protected String doInBackground(String... needToHackString) {
            Log.wtf("MyAsyncTask", "doInBackground:");

            //char[] symbols = String.valueOf(param).toCharArray();
           // Log.d(TAG, "doInBackground: chars = " + symbols[0]);

            int indexHacking = 0;
            String hackRezult = "";
            while (indexHacking < needToHackString[0].length()) {

                for (char c = '\u0000'; c < 'z'; c++) {
                    if(c==needToHackString[0].charAt[indexHacking]){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        hackRezult= hackRezult+c;


                    }
                }
                indexHacking++;
            }

            publishProgress("String", "Stroka2");
            return "Rezult String";
        }

        @Override protected void onProgressUpdate(String... values) {
            Log.wtf("MyAsyncTask", "OnProgressUpdate" + values[0] + "  " + values[1]);
            Toast.makeText(Lesson14Activity.this, "OnProgressUpdate" + values[0] + "  " + values[1],
                Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
        }

        @Override protected void onCancelled() {
            Log.wtf("MyAsyncTask", "onCanceled");
            super.onCancelled();
        }

        @Override protected void onPostExecute(String aVoid) {
            Log.wtf("MyAsyncTask", "onPostExecute: " + aVoid);
            Toast.makeText(Lesson14Activity.this, "onPostExecute" + aVoid, Toast.LENGTH_SHORT)
                .show();
            super.onPostExecute(aVoid);
        }
    }
}
