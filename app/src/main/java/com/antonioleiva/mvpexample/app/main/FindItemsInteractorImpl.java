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

package com.antonioleiva.mvpexample.app.main;

import android.os.Handler;
import android.text.TextUtils;

import com.antonioleiva.mvpexample.app.AppConstants;

import java.util.Arrays;
import java.util.List;

public class FindItemsInteractorImpl implements FindItemsInteractor
{
    @Override
    public void findItems(final OnFinishedListener listener)
    {
        Handler handle = new Handler();
        MainRunnable mainRunnable = new MainRunnable(listener);
        handle.postDelayed(mainRunnable, AppConstants.RUNNABLE_TIME);
    }

    /**
     * Crate ArrayList of string
     * @return List<String>
     */
    private List<String> createArrayList()
    {
        return Arrays.asList( "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
    }

    /**
     * Creating MainHandler for Calling the listener back
     */
    private class MainRunnable implements Runnable
    {
        OnFinishedListener listener;

        public MainRunnable(OnFinishedListener listener)
        {
            this.listener = listener;
        }

        @Override
        public void run()
        {
            List<String> stringList = createArrayList();
            listener.onFinished(stringList);
        }
    }
}
