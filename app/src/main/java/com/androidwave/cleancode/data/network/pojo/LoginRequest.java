package com.androidwave.cleancode.data.network.pojo;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LoginRequest {

    @SerializedName("password")
    private String mPassword;
    @SerializedName("user_id")
    private String mUserId;

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

}
