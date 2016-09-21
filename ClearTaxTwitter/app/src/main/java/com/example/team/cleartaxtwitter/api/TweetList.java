package com.example.team.cleartaxtwitter.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class TweetList {

    @SerializedName("statuses")
    public ArrayList<Tweet> tweets;

}
