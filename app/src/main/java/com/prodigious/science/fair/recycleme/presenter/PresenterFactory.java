package com.prodigious.science.fair.recycleme.presenter;

import com.prodigious.science.fair.recycleme.fragments.MainFragment;

/**
 * Created by Jorge on 24/10/2015.
 */
public class PresenterFactory {

    private PresenterFactory(){}

    public static Presenter create(PresenterType type, MainFragment mainFragment) throws Exception{

        Presenter presenter = null;

        if(type == null)
            throw new Exception("Presenter type is required");

        switch(type){
            case CHALLENGE: {
                presenter =  new ChallengeListPresenter(mainFragment);
                break;
            }
            case CODE:
                break;
            case GOAL:
                presenter = new GoalListPresenter(mainFragment);
                break;
            default:
                throw new Exception("Presenter type does not exist");
        }

        return presenter;
    }
}
