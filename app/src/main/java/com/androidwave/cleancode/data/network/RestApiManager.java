package com.androidwave.cleancode.data.network;

import com.androidwave.cleancode.data.network.pojo.LoginRequest;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.data.network.pojo.WrapperResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class RestApiManager implements RestApiHelper {

    NetworkService mService;

    @Inject
    public RestApiManager(NetworkService apiService) {
        mService = apiService;
    }

    @Override
    public Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest request) {
        return null;
    }
}
