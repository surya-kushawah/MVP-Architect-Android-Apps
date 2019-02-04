package com.androidwave.cleancode.data.network.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class WrapperResponse<T> {
    @SerializedName("data")
    private T mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("authToken")
    private String mAuthToken;

    public String getAuthToken() {
        return mAuthToken;
    }

    public void setAuthToken(String mAuthToken) {
        this.mAuthToken = mAuthToken;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public Boolean getError() {
        return mError;
    }

    public void setError(Boolean error) {
        mError = error;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }
}
