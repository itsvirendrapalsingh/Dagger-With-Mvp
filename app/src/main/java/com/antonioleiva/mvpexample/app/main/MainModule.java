package com.antonioleiva.mvpexample.app.main;

import android.app.Activity;

import com.antonioleiva.mvpexample.app.Login.LoginActivity;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;
import com.antonioleiva.mvpexample.app.Login.LoginPresenter;
import com.antonioleiva.mvpexample.app.Login.LoginPresenterImpl;
import com.antonioleiva.mvpexample.app.Login.LoginView;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule
{
    private MainView view;

    public MainModule(MainView view)
    {
        this.view = view;
    }

    @Provides
    public MainView provideLoginView()
    {
        return view;
    }

    @Provides
    public FindItemsInteractorImpl provideInteractor()
    {
        return new FindItemsInteractorImpl();
    }

    @Provides
    public MainPresenter provideMainPresenter(MainView mainView, FindItemsInteractorImpl findItemsInteractor)
    {
        return new MainPresenterImpl(mainView, findItemsInteractor);
    }
}