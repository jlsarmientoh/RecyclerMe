package com.prodigious.science.fair.recycleme.presenter;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.fragments.MainFragment;
import com.prodigious.science.fair.recycleme.interactor.CodeInputInteractor;
import com.prodigious.science.fair.recycleme.interactor.InputInteractor;
import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.List;

/**
 * Created by Jorge on 28/11/2015.
 */
public class CapInputPresenter implements Presenter, OnFinishedListener<List<Goal>> {

    private static final String DEFAULT_MESSAGE = "Keep Recycling and saving the planet. You rock";

    private MainFragment<List<Goal>> mainFragment;
    private InputInteractor<String, List<Goal>> capInputInteractor;

    public CapInputPresenter(MainFragment<List<Goal>> mainFragment) {
        this.mainFragment = mainFragment;
        this.capInputInteractor = new CodeInputInteractor();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onInput(String input) {
        capInputInteractor.processInput(input, this);
    }

    @Override
    public void onFinished(List<Goal> result) {
        if(result == null || result.size() == 0) {
            mainFragment.onShowMessage(DEFAULT_MESSAGE);
        }else{
            mainFragment.onUpdateContent(result);
        }
    }
}
