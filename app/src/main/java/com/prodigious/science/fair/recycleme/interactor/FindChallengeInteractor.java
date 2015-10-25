package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.model.Challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 24/10/2015.
 */
public class FindChallengeInteractor implements ItemsInteractor<List<Challenge>> {

    private static List<Challenge> mockChallenges;

    @Override
    public void findItems(OnFinishedListener<List<Challenge>> listener) {

        if(mockChallenges == null){
            mockChallenges = new ArrayList<>();

            mockChallenges.add(new Challenge("Invite 10 friens", ""));
            mockChallenges.add(new Challenge("Collect your first cap", ""));
            mockChallenges.add(new Challenge("Collect 20 caps", ""));
            mockChallenges.add(new Challenge("Collect 10 caps in one single day", ""));
        }

        listener.onFinished(mockChallenges);
    }
}
