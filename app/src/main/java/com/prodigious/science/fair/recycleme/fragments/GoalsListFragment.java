package com.prodigious.science.fair.recycleme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodigious.science.fair.recycleme.adapter.GoalAdapter;
import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.ArrayList;
import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/23/15.
 */
public class GoalsListFragment extends Fragment {

    private RecyclerView goalListView;
    private RecyclerView.Adapter goalAdapter;
    private RecyclerView.LayoutManager goalLayoutManager;
    private List<Goal> goalList;


    private GoalsListFragment() {
        this.goalList = new ArrayList<Goal>();

        this.goalList.add(new Goal("First cap", null, 10));
        this.goalList.add(new Goal("Invite your friends", null, 10));
        this.goalList.add(new Goal("Collected 10 caps", null, 20));
        this.goalList.add(new Goal("Collected 20 caps in a single day", null, 40));
        this.goalList.add(new Goal("Collector of the week", null, 50));
    }

    public static GoalsListFragment createGoalsListFragment() {
        return new GoalsListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_goals_list, container, false);
        this.goalListView = (RecyclerView) fragment.findViewById(R.id.goals_view);

        this.goalLayoutManager = new LinearLayoutManager(this.getContext());
        this.goalListView.setLayoutManager(this.goalLayoutManager);

        this.goalAdapter = new GoalAdapter(this.goalList);
        this.goalListView.setAdapter(this.goalAdapter);

        return fragment;
    }
}
