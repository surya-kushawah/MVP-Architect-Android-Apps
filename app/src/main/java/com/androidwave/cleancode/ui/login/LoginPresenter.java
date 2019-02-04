package com.androidwave.cleancode.ui.login;

import com.androidwave.cleancode.data.DataManager;
import com.androidwave.cleancode.data.network.pojo.LoginRequest;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.ui.base.BasePresenter;
import com.androidwave.cleancode.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {
    @Inject
    public LoginPresenter(DataManager manager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(manager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginClick(LoginRequest request) {
        // todo api call here
        getMvpView().showLoading();
        getMvpView().onLoginSuccess(new UserProfile());
        if (!isViewAttached()) {
            return;
        }
    }
}
