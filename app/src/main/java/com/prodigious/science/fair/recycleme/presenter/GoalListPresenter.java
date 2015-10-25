package com.prodigious.science.fair.recycleme.presenter;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.fragments.MainFragment;
import com.prodigious.science.fair.recycleme.interactor.FindGoalInteractor;
import com.prodigious.science.fair.recycleme.interactor.ItemsInteractor;
import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.List;

/**
 * Created by Jorge on 24/10/2015.
 */
public class GoalListPresenter implements Presenter, OnFinishedListener<List<Goal>> {

    private MainFragment<List<Goal>> mainFragment;
    private ItemsInteractor<List<Goal>> goalsInteractor;

    public GoalListPresenter(MainFragment<List<Goal>> mainFragment) {
        this.mainFragment = mainFragment;
        this.goalsInteractor = new FindGoalInteractor();
    }

    @Override
    public void onFinished(List<Goal> result) {
        this.mainFragment.onUpdateContent(result);
    }

    @Override
    public void onResume() {
        this.goalsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {

    }
}
