package com.antonioleiva.mvpexample.app;

import android.content.SharedPreferences;

import com.antonioleiva.mvpexample.app.Login.LoginInteractor;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;

import javax.inject.Singleton;

import dagger.Component;

//Creating this class as a SingleTon
@Singleton
//Creating Component
@Component(modules = {DaggerMVCModule.class})

/**
 * Creating DaggerMVCAppComponent for satisfying the dependency of Application level classes
 */
public interface MvpAppComponent
{
    void inject(DaggerMVCApp app);

    DaggerMVCApp getRMSApp();
    SharedPreferences getDefaultSharedPreferances();
}
