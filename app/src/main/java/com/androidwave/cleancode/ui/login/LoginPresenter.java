package com.androidwave.cleancode.ui.login;

import android.os.Handler;

import com.androidwave.cleancode.data.DataManager;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.data.utils.LoggedInMode;
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
    public void onLoginClick() {
        if (getMvpView() != null) {
            if (getMvpView().getEmail().trim().equals("") || getMvpView().getPassword().trim().equals("")) {
                getMvpView().showInputError();
            } else {
                getMvpView().showLoading();
                new Handler().postDelayed(() -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    // set demo user
                    UserProfile mProfile = new UserProfile();
                    mProfile.setFirstName("Dinesh");
                    mProfile.setLastName("Kumar");
                    mProfile.setEmail("dinesh@gmail.com");
                    mProfile.setUserId("1");
                    //update preferences
                    getDataManager().updateUserInfo("access toekn", 1l, LoggedInMode.LOGGED_IN_MODE_SERVER, "", mProfile.getEmail(), "");
                    getMvpView().onLoginSuccess(mProfile);

                    getMvpView().hideLoading();
                }, 1000);

            }

        }


    }
}
