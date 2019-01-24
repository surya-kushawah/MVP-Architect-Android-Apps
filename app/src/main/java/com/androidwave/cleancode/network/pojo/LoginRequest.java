
package com.androidwave.cleancode.network.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
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
