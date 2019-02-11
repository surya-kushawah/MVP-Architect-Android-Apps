package com.androidwave.cleancode.ui.main;

import com.androidwave.cleancode.data.network.pojo.FeedItem;
import com.androidwave.cleancode.ui.base.MvpView;

import java.util.List;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public interface MainMvpView extends MvpView {
    void updateFeed(List<FeedItem> feedItemList);
}
