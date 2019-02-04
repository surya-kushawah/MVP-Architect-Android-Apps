package com.androidwave.cleancode.data.utils;

import java.util.Date;

import androidx.room.TypeConverter;


/**
 * Created on : Jan 29, 2019
 * Author     : AndroidWave
 */
public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}