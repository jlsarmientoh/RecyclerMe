package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 24/10/2015.
 */
public class FindGoalInteractor implements ItemsInteractor<List<Goal>> {

    public static List<Goal> mockGoals;

    @Override
    public void findItems(OnFinishedListener<List<Goal>> listener) {

        if(mockGoals == null){
            this.mockGoals = new ArrayList<Goal>();

            this.mockGoals.add(new Goal("First cap", null, 10));
            this.mockGoals.add(new Goal("Invite your friends", null, 10));
            this.mockGoals.add(new Goal("Collected 10 caps", null, 20));
            this.mockGoals.add(new Goal("Collected 20 caps in a single day", null, 40));
            this.mockGoals.add(new Goal("Collector of the week", null, 50));
        }

        listener.onFinished(mockGoals);

    }
}
