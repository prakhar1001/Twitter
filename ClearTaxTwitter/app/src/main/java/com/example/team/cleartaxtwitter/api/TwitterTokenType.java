package com.example.team.cleartaxtwitter.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class TwitterTokenType {


    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("access_token")
    public String accessToken;

}
