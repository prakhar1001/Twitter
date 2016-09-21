package com.example.team.cleartaxtwitter;

import android.app.Application;
import android.content.Context;

import com.example.team.cleartaxtwitter.api.ApiConstants;
import com.example.team.cleartaxtwitter.api.TwitterApiService;
import com.example.team.cleartaxtwitter.api.TwitterServiceProvider;
import com.example.team.cleartaxtwitter.util.BusProvider;
import com.squareup.otto.Bus;

import retrofit.RestAdapter;

/**
 * Created by Prakhar on 21-Sep-16.
 */

public class TwitterSearchApplication extends Application {
    private static TwitterSearchApplication mInstance;
    private static Context mAppContext;

    private TwitterServiceProvider mTwitterService;
    private Bus bus = BusProvider.getInstance();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        this.setAppContext(getApplicationContext());
        mTwitterService = new TwitterServiceProvider(buildApi(), bus);
        bus.register(mTwitterService);
        bus.register(this); //listen to "global" events
    }

    private TwitterApiService buildApi() {
        return new RestAdapter.Builder()
                .setEndpoint(ApiConstants.TWITTER_SEARCH_URL)
                .build()
                .create(TwitterApiService.class);
    }


    public static TwitterSearchApplication getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }


}