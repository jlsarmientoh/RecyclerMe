package com.prodigious.science.fair.recycleme.fragments;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by Jorge on 20/10/2015.
 */
public class CodeInputFragment extends Fragment implements View.OnClickListener {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    static final String SCAN_MODE = "SCAN_MODE";
    static final String QR_CODE_MODE = "QR_CODE_MODE";
    private static final String SCAN_RESULT = "SCAN_RESULT";
    private static final String SCAN_RESULT_FORMAT = "SCAN_RESULT_FORMAT";

    private EditText textCode;

    private ImageButton actionAdd;

    public CodeInputFragment() {
    }

    public static CodeInputFragment createCodeInputFragment() {
        return new CodeInputFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View fragment = inflater.inflate(R.layout.fragment_code_input, container, false);
        this.textCode = (EditText) fragment.findViewById(R.id.textCode);
        this.actionAdd = (ImageButton) fragment.findViewById(R.id.action_add_code);
        this.actionAdd.setOnClickListener(this);
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
                String format = intent.getStringExtra(SCAN_RESULT_FORMAT);
                Snackbar.make(this.getView(), "Content: " + contents +
                        " formats: " + format, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }
    }
}
