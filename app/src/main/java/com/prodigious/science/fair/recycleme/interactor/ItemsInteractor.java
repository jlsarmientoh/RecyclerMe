package com.prodigious.science.fair.recycleme.interactor;

import com.prodigious.science.fair.recycleme.Listener.OnFinishedListener;

/**
 * Created by Jorge on 24/10/2015.
 */
public interface ItemsInteractor<T> {

    public void findItems(OnFinishedListener<T> listener);
}
