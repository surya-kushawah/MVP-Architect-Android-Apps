package com.androidwave.cleancode.ui.login;

import com.androidwave.cleancode.network.pojo.LoginRequest;
import com.androidwave.cleancode.ui.base.MvpPresenter;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void onServerLoginClick(LoginRequest request);
}
