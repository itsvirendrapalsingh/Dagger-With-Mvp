package com.antonioleiva.mvpexample.app.Login;

import com.antonioleiva.mvpexample.app.ActivityScope;
import com.antonioleiva.mvpexample.app.MvpAppComponent;

import dagger.Component;

//Set Activity Scope
@ActivityScope

//Set Component
@Component(dependencies = MvpAppComponent.class,
        modules = {LoginModule.class})

/**
 * Creating LoginComponent For satisfying the dependency of Login Module
 */
public interface LoginComponent
{
    void inject(LoginActivity activity);

    LoginView getLoginView();
    LoginInteractorImpl provideInteractor();
    LoginPresenter provideLoginPresenter();
}
