package com.antonioleiva.mvpexample.app;

import android.app.Application;
import android.content.Context;

public class DaggerMVCApp extends Application
{
    private MvpAppComponent component;

    @Override
    public void onCreate()
    {
        super.onCreate();

        //Initialize Application Component For initializing dependency of application level
        initializeApplicationComponent();
    }

    public static DaggerMVCApp getAppContext(Context context)
    {
        return (DaggerMVCApp) context.getApplicationContext();
    }

    private void initializeApplicationComponent()
    {
        component = DaggerMvpAppComponent.builder().daggerMVCModule(new DaggerMVCModule(this)).build();
        component.inject(this);
    }

    public MvpAppComponent getAppComponent()
    {
        return component;
    }
}
