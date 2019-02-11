package com.androidwave.cleancode.di.component;

import android.app.Application;
import android.content.Context;

import com.androidwave.cleancode.data.DataManager;
import com.androidwave.cleancode.di.ApplicationContext;
import com.androidwave.cleancode.di.module.ApplicationModule;
import com.androidwave.cleancode.root.WaveApp;

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

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
//    @Component.Builder
//    interface Builder {
//        ApplicationComponent build();
//
//        Builder applicationModule(ApplicationModule applicationModule);
//
//        DataManager getDataManager();
//    }


}
