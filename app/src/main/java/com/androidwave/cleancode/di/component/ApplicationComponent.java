package com.androidwave.cleancode.di.component;

import com.androidwave.cleancode.WaveApp;
import com.androidwave.cleancode.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WaveApp app);


    @Component.Builder
    interface Builder {
        ApplicationComponent build();
        Builder applicationModule(ApplicationModule applicationModule);
    }



}
