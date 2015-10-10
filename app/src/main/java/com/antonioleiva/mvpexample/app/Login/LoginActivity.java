/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.antonioleiva.mvpexample.app.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.antonioleiva.mvpexample.app.BaseActivity;
import com.antonioleiva.mvpexample.app.MvpAppComponent;
import com.antonioleiva.mvpexample.app.R;
import com.antonioleiva.mvpexample.app.main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener
{
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize View
        initializeView();
    }

    public void initializeView()
    {
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void initializeComponent(MvpAppComponent component)
    {
        DaggerLoginComponent.builder()
                .mvpAppComponent(component)
                .loginModule(new LoginModule(this, this))
                .build()
                .inject(this);
    }

    @Override
    public void showProgress()
    {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress()
    {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError()
    {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError()
    {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view)
    {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
