package com.androidwave.cleancode.data.db.model;

import com.androidwave.cleancode.data.utils.DateConverter;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


/**
 * Created on : Feb 01, 2019
 * Author     : AndroidWave
 */
@Entity(tableName = "user")
@TypeConverters({DateConverter.class})
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @ColumnInfo(name = "last_name")
    private String mLastName;

    @ColumnInfo(name = "email")
    private String mEmail;

    @ColumnInfo(name = "mobile")
    private String mMobile;

    @ColumnInfo(name = "address")
    private String mAddress;


    @ColumnInfo(name = "image_uri")
    private String mImageUrl;

    @ColumnInfo(name = "last_update")
    private Date mLastUpdate;

    @ColumnInfo(name = "created_at")
    private Date mCreatedAt;

    public User(String mFirstName, String mLastName, String mEmail, String mMobile, String mAddress, Date mLastUpdate, Date mCreatedAt) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mMobile = mMobile;
        this.mAddress = mAddress;
        this.mLastUpdate = mLastUpdate;
        this.mCreatedAt = mCreatedAt;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Date getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(Date mLastUpdate) {
        this.mLastUpdate = mLastUpdate;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
