package com.prodigious.science.fair.recycleme.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodigious.science.fair.recycleme.adapter.GoalAdapter;
import com.prodigious.science.fair.recycleme.model.Goal;
import com.prodigious.science.fair.recycleme.presenter.Presenter;
import com.prodigious.science.fair.recycleme.presenter.PresenterFactory;
import com.prodigious.science.fair.recycleme.presenter.PresenterType;

import java.util.ArrayList;
import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/23/15.
 */
public class GoalsListFragment extends Fragment implements MainFragment<List<Goal>> {

    private RecyclerView goalListView;
    private GoalAdapter goalAdapter;
    private RecyclerView.LayoutManager goalLayoutManager;
    private List<Goal> goalList;
    private Presenter presenter;


    public GoalsListFragment() {
    }

    public static GoalsListFragment createGoalsListFragment() {
        return new GoalsListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_goals_list, container, false);
        try {
            this.goalListView = (RecyclerView) fragment.findViewById(R.id.goals_view);

            this.goalLayoutManager = new LinearLayoutManager(this.getContext());
            this.goalListView.setLayoutManager(this.goalLayoutManager);

            this.goalAdapter = new GoalAdapter(this.goalList);
            this.goalListView.setAdapter(this.goalAdapter);

            this.presenter = PresenterFactory.create(PresenterType.GOAL, this);
        }catch(Exception e){
            e.printStackTrace();
        }

        return fragment;
    }

    @Override
    public void onResume(){
        super.onResume();
        this.presenter.onResume();
    }

    @Override
    public void onUpdateContent(List<Goal> content) {
        this.goalAdapter.setGoals(content);
    }

    @Override
    public void onShowMessage(String message) {
        Snackbar.make(this.getView(), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
