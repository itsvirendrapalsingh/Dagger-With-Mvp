package com.antonioleiva.mvpexample.app.Login;

import android.os.Handler;
import android.text.TextUtils;

import com.antonioleiva.mvpexample.app.AppConstants;

public class LoginInteractorImpl implements LoginInteractor
{
    private OnLoginFinishedListener listener;

    public void initializeFinishedListener(OnLoginFinishedListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void login(final String username, final String password)
    {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        Handler handler = new Handler();
        LoginRunnable loginRunnable = new LoginRunnable(username, password);
        handler.postDelayed(loginRunnable, AppConstants.RUNNABLE_TIME);
    }

    /**
     * Creating LoginHandler for Checking dummy login with user name and password
     */
    private class LoginRunnable implements Runnable
    {
        String userName;
        String password;

        public LoginRunnable(String userName, String password)
        {
            this.userName = userName;
            this.password = password;
        }

        @Override
        public void run()
        {
            boolean isError = false;
            if (TextUtils.isEmpty(userName))
            {
                listener.onUsernameError();
                isError = true;
            }
            if (TextUtils.isEmpty(password))
            {
                listener.onPasswordError();
                isError = true;
            }
            if (!isError)
            {
                listener.onSuccess();
            }
        }
    }
}
