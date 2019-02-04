package com.androidwave.cleancode.data;

import android.content.Context;

import com.androidwave.cleancode.data.db.AppDatabase;
import com.androidwave.cleancode.data.db.model.User;
import com.androidwave.cleancode.data.network.RestApiHelper;
import com.androidwave.cleancode.data.network.pojo.LoginRequest;
import com.androidwave.cleancode.data.network.pojo.UserProfile;
import com.androidwave.cleancode.data.network.pojo.WrapperResponse;
import com.androidwave.cleancode.data.prefs.PreferencesHelper;
import com.androidwave.cleancode.data.utils.LoggedInMode;
import com.androidwave.cleancode.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class BaseDataManager implements DataManager {
    private static final String TAG = "BaseDataManager";


    private final Context mContext;
    private final AppDatabase mDatabase;
    private final PreferencesHelper mPreferencesHelper;
    private final RestApiHelper mApiHelper;

    @Inject
    public BaseDataManager(@ApplicationContext Context context,
                           AppDatabase database,
                           PreferencesHelper preferencesHelper,
                           RestApiHelper apiHelper) {
        mContext = context;
        mDatabase = database;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {

    }

    @Override
    public void setUserLoggedOut() {

    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName, String email, String profilePicPath) {
//mPreferencesHelper.
    }

    @Override
    public List<User> getAll() {
        return mDatabase.userDao().getAll();
    }

    @Override
    public void insertUser(User mUser) {
        mDatabase.userDao().insertUser(mUser);
    }

    @Override
    public void insertAllUser(User... mUsersList) {
        mDatabase.userDao().insertAllUser(mUsersList);
    }

    @Override
    public void deleteUser(User mUser) {
        mDatabase.userDao().deleteUser(mUser);
    }

    @Override
    public void updateUser(User mUser) {

    }


    @Override
    public User getUserById(int uId) {
        return mDatabase.userDao().getUserById(uId);
    }

    @Override
    public List<User> loadAllByIds(int[] userIds) {
        return mDatabase.userDao().loadAllByIds(userIds);
    }

    @Override
    public User findByName(String first, String last) {
        return mDatabase.userDao().findByName(first,last);
    }

    @Override
    public Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest request) {
        return mApiHelper.doLoginApiCall(request);
    }

    @Override
    public int getUserLoggedInMode() {
        return 0;
    }

    @Override
    public void setUserLoggedIn(LoggedInMode mode) {

    }

    @Override
    public Long getUserId() {
        return null;
    }

    @Override
    public void setUserId(Long userId) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserEmail() {
        return null;
    }

    @Override
    public void setUserEmail(String email) {

    }

    @Override
    public String getUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setUserProfilePicUrl(String profilePicUrl) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
