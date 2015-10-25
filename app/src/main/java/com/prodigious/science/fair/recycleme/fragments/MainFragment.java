package com.prodigious.science.fair.recycleme.fragments;

/**
 * Created by Jorge on 24/10/2015.
 */
public interface MainFragment<T> {

    public void onUpdateContent(T content);

    public void onShowMessage(String message);
}
