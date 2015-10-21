package fair.science.prodigious.com.recycleme.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by Jorge on 20/10/2015.
 */
public class CodeInputFragment extends Fragment implements View.OnClickListener {


    private TextView textCode;

    private ImageButton actionAdd;

    private CodeInputFragment() {
    }

    public static CodeInputFragment createCodeInputFragment() {
        return new CodeInputFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View fragment = inflater.inflate(R.layout.fragment_code_input, container, false);
        this.textCode = (TextView) fragment.findViewById(R.id.textCode);
        this.actionAdd = (ImageButton) fragment.findViewById(R.id.action_add_code);
        this.actionAdd.setOnClickListener(this);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "You've added new taps", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }
}
