package com.androidwave.cleancode.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidwave.cleancode.R;
import com.androidwave.cleancode.data.network.pojo.LoginRequest;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.ui.base.BaseActivity;
import com.androidwave.cleancode.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginMvpView {
    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    TextView mEmail, mPassword;
    Button loginButton;


    // UI references.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        mPresenter.onAttach(LoginActivity.this);
        setUp();
    }

    @Override
    protected void setUp() {
        mEmail = findViewById(R.id.input_email);
        mPassword = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(v -> {
          mPresenter.onLoginClick();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Override
    public void onLoginSuccess(UserProfile mUser) {
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showInputError() {
        showMessage(getString(R.string.input_invalid));
    }

    @Override
    public void setPassword(String password) {
        mEmail.setText(password);
    }

    @Override
    public void setEmail(String email) {
        mPassword.setText(email);
    }


}

