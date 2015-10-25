package com.prodigious.science.fair.recycleme.presenter;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.fragments.MainFragment;
import com.prodigious.science.fair.recycleme.interactor.FindChallengeInteractor;
import com.prodigious.science.fair.recycleme.interactor.ItemsInteractor;
import com.prodigious.science.fair.recycleme.model.Challenge;

import java.util.List;

/**
 * Created by Jorge on 24/10/2015.
 */
public class ChallengeListPresenter implements Presenter, OnFinishedListener<List<Challenge>>{

    private MainFragment<List<Challenge>> mainFragment;
    private ItemsInteractor<List<Challenge>> challengesInteractor;

    public ChallengeListPresenter(MainFragment mainFragment) {
        this.mainFragment = mainFragment;
        this.challengesInteractor = new FindChallengeInteractor();
    }

    @Override
    public void onResume() {
        this.challengesInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onFinished(List<Challenge> result) {
        this.mainFragment.onUpdateContent(result);
    }
}
