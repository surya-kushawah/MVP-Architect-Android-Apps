package com.androidwave.cleancode.ui.base;

import androidx.annotation.StringRes;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public interface MvpView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void openLoginActivity();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}

