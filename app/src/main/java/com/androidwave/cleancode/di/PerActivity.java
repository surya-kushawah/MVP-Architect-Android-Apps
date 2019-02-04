package com.androidwave.cleancode.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}