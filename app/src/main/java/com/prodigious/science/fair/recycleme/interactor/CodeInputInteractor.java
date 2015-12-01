package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;
import com.prodigious.science.fair.recycleme.model.CapInput;
import com.prodigious.science.fair.recycleme.model.Challenge;
import com.prodigious.science.fair.recycleme.model.Goal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jorge on 28/11/2015.
 */
public class CodeInputInteractor implements InputInteractor<String, List<Goal>> {

    private static List<Challenge> mockChallenges;

    @Override
    public void processInput(String input, OnFinishedListener<List<Goal>> listener){
        List<Goal> result= null;

        CapInput capInput = parseInput(input);

        if(capInput != null){

            initChallenges();
            result = new ArrayList<>();

            for(Challenge challenge : mockChallenges){
                if(capInput.getCapCount() >= challenge.getRequiredCaps()){
                    result.add(new Goal(challenge.getDescription(), "", capInput.getCapCount()));
                }
            }
        }

        listener.onFinished(result);
    }

    private CapInput parseInput(String input){
        try{
            String code = input.substring(0,3);
            int capCount = Integer.parseInt(input.substring(3, 6));
            long timestamp = Long.parseLong(input.substring(6, input.length()));
            Date date = new Date(timestamp);

            CapInput capInput = new CapInput(code,capCount,date,null);
            return capInput;
        }catch(Exception ex){
            return null;
        }
    }

    private void initChallenges(){

        if(mockChallenges == null){
            mockChallenges = new ArrayList<>();

            mockChallenges.add(new Challenge("Invite 10 friends", "", 10));
            mockChallenges.add(new Challenge("Collect your first cap", "", 1));
            mockChallenges.add(new Challenge("Collect 5 caps", "", 5));
            mockChallenges.add(new Challenge("Collect 20 caps", "", 20));
            mockChallenges.add(new Challenge("Collect 10 caps in one single day", "", 10));
        }
    }
}
