package com.antonioleiva.mvpexample.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.antonioleiva.mvpexample.app.Login.LoginInteractor;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zopper on 26/6/15.
 */
@Module
public class DaggerMVCModule
{
    private DaggerMVCApp app;

    public DaggerMVCModule(DaggerMVCApp app)
    {
        this.app = app;
    }

    @Provides
    public DaggerMVCApp provideApplication()
    {
        return app;
    }

    @Provides
    public SharedPreferences provideSharedPreferances()
    {
        return PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
    }
}
