package com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.vladimirbabenko.android_base_homeworks.R;
import com.example.vladimirbabenko.android_base_homeworks.lesson12.DialogFragmentActivity;
import com.example.vladimirbabenko.android_base_homeworks.lesson7_practice.data.DataManager;

public class CongratulationDialog extends DialogFragment {

    @BindView(R.id.ivFrafmentImageView) ImageView ivFrafmentImageView;
    @BindView(R.id.btFragmentClose) Button btFragmentClose;
    @BindView(R.id.btFragmentButtonAccept) Button btFragmentButtonAccept;

    // TODO how is right to get DataMandger
    private DataManager mDataManager;

    //Companion in Kotlin - static void?
    public static CongratulationDialog newInstance(Bundle bundle) {
        CongratulationDialog fragment = new CongratulationDialog();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //developrs.android - void  setStyle()
        //setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_DeviceDefault);
        mDataManager = DataManager.getInstance(getContext());// Probably wrong context?
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_congratulation, container, false);
        ButterKnife.bind(this, view);
        setCancelable(true);
        setupButtonListners();
        return view;
    }

    @Override public void onCancel(DialogInterface dialog) {
        Toast.makeText(getActivity(), "FragmentIs closed by onCancel", Toast.LENGTH_SHORT).show();
        super.onCancel(dialog);
    }

    private void setupButtonListners() {
        //btFragmentButtonAccept.setOnClickListener(v -> {
        //    mDataManager.getPrefs().setDialogIsShown(true);
        //    CongratulationDialog.this.dismiss();
        //    Toast.makeText(getActivity(), "Welcome screen is ACCEPTED", Toast.LENGTH_SHORT).show();
        //});

        //btFragmentClose.setOnClickListener(v->{
        //    CongratulationDialog.this.dismiss();
        //    Toast.makeText(getActivity(), "Welcome screen is CANSELED", Toast.LENGTH_SHORT).show();
        //
        //});
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        mDataManager = null; // Надо ли в обязательном порядке уничтожать ссылку на синглтон,
    }

    @OnClick(R.id.btFragmentButtonAccept) public void onBtAcceptClick(View v) {
            mDataManager.getPrefs().setDialogIsShown(true);
        CongratulationDialog.this.dismiss();
        Toast.makeText(getActivity(), "Welcome screen is ACCEPTED", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btFragmentClose) public void onBtFragmentCloseClick(View v){
        CongratulationDialog.this.dismiss();
        Toast.makeText(getActivity(), "Welcome screen is CANSELED", Toast.LENGTH_SHORT).show();
    }
}
