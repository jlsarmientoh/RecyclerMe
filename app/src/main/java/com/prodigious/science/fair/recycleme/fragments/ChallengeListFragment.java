package com.prodigious.science.fair.recycleme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prodigious.science.fair.recycleme.adapter.ChallengeAdapter;
import com.prodigious.science.fair.recycleme.model.Challenge;

import java.util.ArrayList;
import java.util.List;

import fair.science.prodigious.com.recycleme.R;

/**
 * Created by jsarmien on 10/23/15.
 */
public class ChallengeListFragment extends Fragment {

    private RecyclerView challengeListView;
    private RecyclerView.Adapter challengeAdapter;
    private RecyclerView.LayoutManager challengeLayoutManager;
    private List<Challenge> challengeList;

    private ChallengeListFragment() {
        this.challengeList = new ArrayList<>();

        this.challengeList.add(new Challenge("Invite 10 friens", ""));
        this.challengeList.add(new Challenge("Collect your first cap", ""));
        this.challengeList.add(new Challenge("Collect 20 caps", ""));
        this.challengeList.add(new Challenge("Collect 10 caps in one single day", ""));
    }


    public static ChallengeListFragment createChallengeListFragment() {
        return new ChallengeListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_challenges_list, container, false);
        this.challengeListView = (RecyclerView) fragment.findViewById(R.id.challenges_view);

        this.challengeLayoutManager = new LinearLayoutManager(this.getContext());
        this.challengeListView.setLayoutManager(this.challengeLayoutManager);

        this.challengeAdapter = new ChallengeAdapter(this.challengeList);
        this.challengeListView.setAdapter(this.challengeAdapter);

        return fragment;
    }
}
