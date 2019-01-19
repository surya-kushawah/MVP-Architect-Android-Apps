package com.androidwave.cleancode.di.component;

import com.androidwave.errorhandling.WaveApp;
import com.androidwave.errorhandling.di.module.ApplicationModule;

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
