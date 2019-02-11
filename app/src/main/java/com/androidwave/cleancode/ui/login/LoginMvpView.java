package com.androidwave.cleancode.ui.login;

import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.ui.base.MvpView;

public interface LoginMvpView extends MvpView {
    void onLoginSuccess(UserProfile mUser);

    String getEmail();

    String getPassword();

    void showInputError();

    void setPassword(String userId);

    void setEmail(String password);
}
