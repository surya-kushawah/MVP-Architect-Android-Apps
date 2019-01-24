package com.androidwave.cleancode.ui.login;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.androidwave.cleancode.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    // UI references.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

}

