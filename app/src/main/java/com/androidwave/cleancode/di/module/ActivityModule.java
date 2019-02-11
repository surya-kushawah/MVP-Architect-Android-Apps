package com.androidwave.cleancode.di.module;

import android.content.Context;

import com.androidwave.cleancode.di.ActivityContext;
import com.androidwave.cleancode.di.PerActivity;
import com.androidwave.cleancode.ui.login.LoginMvpPresenter;
import com.androidwave.cleancode.ui.login.LoginMvpView;
import com.androidwave.cleancode.ui.login.LoginPresenter;
import com.androidwave.cleancode.ui.main.MainMvpPresenter;
import com.androidwave.cleancode.ui.main.MainMvpView;
import com.androidwave.cleancode.ui.main.MainPresenter;
import com.androidwave.cleancode.ui.main.RssAdapter;
import com.androidwave.cleancode.utils.rx.AppSchedulerProvider;
import com.androidwave.cleancode.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }


    @Provides
    RssAdapter provideRssAdapter() {
        return new RssAdapter(new ArrayList<>());
    }
}