package com.prodigious.science.fair.recycleme.presenter;

/**
 * Created by Jorge on 24/10/2015.
 */
public interface Presenter {

    public void onResume();

    public void onItemClicked(int position);

    public void onInput(String input);
}
