package com.prodigious.science.fair.recycleme.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodigious.science.fair.recycleme.adapter.ChallengeAdapter;
import com.prodigious.science.fair.recycleme.model.Challenge;
import com.prodigious.science.fair.recycleme.presenter.Presenter;
import com.prodigious.science.fair.recycleme.presenter.PresenterFactory;
import com.prodigious.science.fair.recycleme.presenter.PresenterType;

import java.util.ArrayList;
import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/23/15.
 */
public class ChallengeListFragment extends Fragment implements MainFragment<List<Challenge>>{

    private RecyclerView challengeListView;
    private ChallengeAdapter challengeAdapter;
    private RecyclerView.LayoutManager challengeLayoutManager;
    private List<Challenge> challengeList;
    private Presenter presenter;

    public ChallengeListFragment() {

    }

    public static ChallengeListFragment createChallengeListFragment() {
        return new ChallengeListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_challenges_list, container, false);

        try {
            this.challengeListView = (RecyclerView) fragment.findViewById(R.id.challenges_view);

            this.challengeLayoutManager = new LinearLayoutManager(this.getContext());
            this.challengeListView.setLayoutManager(this.challengeLayoutManager);

            this.challengeAdapter = new ChallengeAdapter(this.challengeList);
            this.challengeListView.setAdapter(this.challengeAdapter);

            this.presenter = PresenterFactory.create(PresenterType.CHALLENGE, this);
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
    public void onUpdateContent(List<Challenge> content) {
        this.challengeAdapter.setChallengeList(content);
    }

    @Override
    public void onShowMessage(String message) {
        Snackbar.make(this.getView(), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
