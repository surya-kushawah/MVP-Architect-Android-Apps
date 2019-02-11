package com.androidwave.cleancode.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PreferenceInfo {
}