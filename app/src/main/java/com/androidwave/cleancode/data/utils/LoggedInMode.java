package com.androidwave.cleancode.data.utils;

public enum LoggedInMode {

    LOGGED_IN_MODE_LOGOUT(0),
    LOGGED_IN_MODE_GMAIL(1),
    LOGGED_IN_MODE_FACEBOOK(2),
    LOGGED_IN_MODE_SERVER(3);

    private final int mType;

    LoggedInMode(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}
