package com.androidwave.cleancode.data.prefs;

import com.androidwave.cleancode.data.utils.LoggedInMode;

public interface PreferencesHelper {
    int getUserLoggedInMode();

    void setUserLoggedIn(LoggedInMode mode);

    Long getUserId();

    void setUserId(Long userId);

    String getUserName();

    void setUserName(String userName);

    String getUserEmail();

    void setUserEmail(String email);

    String getUserProfilePicUrl();

    void setUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getUserMobile();

    void setUserMobile(String mobileNumber);

    boolean isCoachMarkView();

    void setCoachMarkView(boolean coachMark);

    boolean isFirstTime();

    void setFirstTime(boolean firstTime);

    void logoutUser();
}
