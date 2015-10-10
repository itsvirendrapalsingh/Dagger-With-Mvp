package com.antonioleiva.mvpexample.app.main;

import com.antonioleiva.mvpexample.app.ActivityScope;
import com.antonioleiva.mvpexample.app.Login.LoginActivity;
import com.antonioleiva.mvpexample.app.Login.LoginInteractorImpl;
import com.antonioleiva.mvpexample.app.Login.LoginModule;
import com.antonioleiva.mvpexample.app.Login.LoginPresenter;
import com.antonioleiva.mvpexample.app.Login.LoginView;
import com.antonioleiva.mvpexample.app.MvpAppComponent;

import dagger.Component;

//Set Activity Scope
@ActivityScope

//Set Component
@Component(dependencies = MvpAppComponent.class,
        modules = {MainModule.class})

/**
 * Creating MainComponent For satisfying the dependency of Main Module
 */
public interface MainComponent
{
    void inject(MainActivity activity);

    MainView getMainView();
    FindItemsInteractorImpl provideInteractor();
    MainPresenter provideMainPresenter();
}
