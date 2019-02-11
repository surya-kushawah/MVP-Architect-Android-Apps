package com.androidwave.cleancode.ui.login;

import com.androidwave.cleancode.data.network.pojo.LoginRequest;
import com.androidwave.cleancode.ui.base.MvpPresenter;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void onLoginClick();
}
