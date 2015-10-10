package com.antonioleiva.mvpexample.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * @author akshay
 * @version 1.0.0
 * @since 29/6/15
 */
public abstract class BaseActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Get Application Component
        DaggerMVCApp daggerMVCApp = DaggerMVCApp.getAppContext(this); // Get AppContext
        MvpAppComponent mvpAppComponent = daggerMVCApp.getAppComponent(); // Get AppComponent

        //Initialize Activity Component
        initializeComponent(mvpAppComponent);
    }

    //Create Abstract Method for initializing Activity References
    public abstract void initializeComponent(MvpAppComponent component);

    //This method is used to initialize the view in Sub-Activity
    public abstract void initializeView();
}
