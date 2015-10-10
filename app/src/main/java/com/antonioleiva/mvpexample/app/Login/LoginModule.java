package com.antonioleiva.mvpexample.app.Login;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class LoginModule
{
    private LoginView view;
    private Activity loginActivity;

    public LoginModule(LoginView view, LoginActivity loginActivity)
    {
        this.view = view;
        this.loginActivity = loginActivity;
    }

    @Provides
    public LoginView provideLoginView()
    {
        return view;
    }

    @Provides
    public LoginInteractorImpl provideInteractor()
    {
        return new LoginInteractorImpl();
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginView loginView, LoginInteractorImpl loginInteractorImpl)
    {
        return new LoginPresenterImpl(loginView, loginInteractorImpl);
    }
}