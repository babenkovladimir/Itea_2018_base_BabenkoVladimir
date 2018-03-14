package com.example.vladimirbabenko.android_base_homeworks.lesson9;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.BindView;
import com.example.vladimirbabenko.android_base_homeworks.MainActivity;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson8.base.BaseActivity;

public class AlertDialogActivity extends BaseActivity {

    @BindView(R.id.rvRecyclerView) RecyclerView rvRecyclerView;
    //private CustomRVAdapter mCustomRVAdapter;

    @Override public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_alert_dialog);
        super.onCreate(savedInstanceState);

        //AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        //builder.setTitle("Title");
        //builder.setIcon(R.drawable.ic_launcher_background);
        //builder.setMessage("Some message");
        //builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        //    @Override public void onClick(DialogInterface dialog, int which) {
        //    dialog.cancel();
        //        Toast.makeText(AlertDialogActivity.this, "Posotive choise", Toast.LENGTH_SHORT).show();
        //    }
        //});
        //builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        //    @Override public void onClick(DialogInterface dialog, int which) {
        //        Toast.makeText(AlertDialogActivity.this, "Negative choise", Toast.LENGTH_SHORT).show();
        //    }
        //});
        //
        //builder.setNeutralButton("not now", new DialogInterface.OnClickListener() {
        //    @Override public void onClick(DialogInterface dialog, int which) {
        //        dialog.dismiss();
        //        Toast.makeText(AlertDialogActivity.this, "Not now", Toast.LENGTH_SHORT).show();
        //    }
        //});
        //builder.setCancelable(false);// по дефолту это true
        //
        //AlertDialog alertDialog = builder.create();
        //alertDialog.show();

        //mCustomRVAdapter = new CustomRVAdapter();
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        //rvRecyclerView.setAdapter();
    }

    //private static class
}
