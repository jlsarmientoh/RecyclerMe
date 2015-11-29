package com.prodigious.science.fair.recycleme.fragments;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.prodigious.science.fair.recycleme.model.Goal;
import com.prodigious.science.fair.recycleme.presenter.Presenter;
import com.prodigious.science.fair.recycleme.presenter.PresenterFactory;
import com.prodigious.science.fair.recycleme.presenter.PresenterType;

import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by Jorge on 20/10/2015.
 */
public class CodeInputFragment extends Fragment implements View.OnClickListener,
        MainFragment<List<Goal>> {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    static final String SCAN_MODE = "SCAN_MODE";
    static final String QR_CODE_MODE = "QR_CODE_MODE";
    private static final String SCAN_RESULT = "SCAN_RESULT";
    private static final String SCAN_RESULT_FORMAT = "SCAN_RESULT_FORMAT";

    private EditText textCode;

    private ImageButton actionAdd;

    private Presenter presenter;

    public CodeInputFragment() {
    }

    public static CodeInputFragment createCodeInputFragment() {
        return new CodeInputFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View fragment = inflater.inflate(R.layout.fragment_code_input, container, false);

        try {
            this.textCode = (EditText) fragment.findViewById(R.id.textCode);
            this.actionAdd = (ImageButton) fragment.findViewById(R.id.action_add_code);
            this.actionAdd.setOnClickListener(this);

            this.presenter = PresenterFactory.create(PresenterType.CODE, this);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return fragment;
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "You've added new taps", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        openQRScannerActivity();
    }

    private void openQRScannerActivity(){
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra(SCAN_MODE, QR_CODE_MODE);
            startActivityForResult(intent, 0);
        }catch(ActivityNotFoundException ex){
            Snackbar.make(this.getView(), "No scanner found", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 0){
            if(resultCode == Activity.RESULT_OK){
                String contents = intent.getStringExtra(SCAN_RESULT);
                this.presenter.onInput(contents);
            }
        }
    }

    @Override
    public void onUpdateContent(List<Goal> content) {
        showGoalDialog(content);
    }

    @Override
    public void onShowMessage(String message) {
        Snackbar.make(this.getView(), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private void showGoalDialog(List<Goal> goals){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Challenge Completed");

        for(Goal goal : goals) {
            dialogBuilder
                    .setMessage(goal.getDescription())
                    .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog dialog = dialogBuilder.create();
            dialog.show();
        }
    }
}
