package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;

/**
 * Created by Jorge on 28/11/2015.
 */
public interface InputInteractor<T, R> {

    public void processInput(T input, OnFinishedListener<R> listener);
}
