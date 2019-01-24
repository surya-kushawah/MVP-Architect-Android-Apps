package com.androidwave.cleancode.ui.login;

import com.androidwave.cleancode.network.pojo.User;
import com.androidwave.cleancode.ui.base.MvpView;

public interface LoginMvpView extends MvpView {
    void onLoginSuccess(User mUser);
}
