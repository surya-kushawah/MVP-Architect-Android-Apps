package com.androidwave.cleancode.ui.login;

import android.os.Bundle;

import com.androidwave.cleancode.R;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginMvpView {
    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    // UI references.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        mPresenter.onAttach(LoginActivity.this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Override
    public void onLoginSuccess(UserProfile mUser) {

    }
}

