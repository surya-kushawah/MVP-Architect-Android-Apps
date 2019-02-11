package com.androidwave.cleancode.di.component;


import com.androidwave.cleancode.di.PerActivity;
import com.androidwave.cleancode.di.module.ActivityModule;
import com.androidwave.cleancode.ui.login.LoginActivity;
import com.androidwave.cleancode.ui.main.MainActivity;

import dagger.Component;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);
}