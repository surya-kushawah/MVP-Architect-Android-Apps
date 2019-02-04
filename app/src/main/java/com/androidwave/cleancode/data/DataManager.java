package com.androidwave.cleancode.data;

import com.androidwave.cleancode.data.db.dao.UserDao;
import com.androidwave.cleancode.data.network.RestApiHelper;
import com.androidwave.cleancode.data.prefs.PreferencesHelper;
import com.androidwave.cleancode.data.utils.LoggedInMode;

public interface DataManager extends UserDao, PreferencesHelper, RestApiHelper {
    void updateApiHeader(Long userId, String accessToken);

    void setUserLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);
}
