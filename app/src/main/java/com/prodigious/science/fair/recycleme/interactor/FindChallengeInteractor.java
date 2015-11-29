package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.model.Challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 24/10/2015.
 */
public class FindChallengeInteractor implements ItemsInteractor<List<Challenge>> {

    public static List<Challenge> mockChallenges;

    @Override
    public void findItems(OnFinishedListener<List<Challenge>> listener) {

        if(mockChallenges == null){
            mockChallenges = new ArrayList<>();

            mockChallenges.add(new Challenge("Invite 10 friends", "", 10));
            mockChallenges.add(new Challenge("Collect your first cap", "", 1));
            mockChallenges.add(new Challenge("Collect 20 caps", "", 20));
            mockChallenges.add(new Challenge("Collect 10 caps in one single day", "", 10));
        }

        listener.onFinished(mockChallenges);
    }
}
