package com.example.team.cleartaxtwitter.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class TwitterUser {


    @SerializedName("screen_name")
    public String screenName;

    @SerializedName("name")
    public String name;

    @SerializedName("profile_image_url")
    public String profileImageUrl;
}
