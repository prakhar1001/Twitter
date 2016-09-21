package com.example.team.cleartaxtwitter.event;

import com.example.team.cleartaxtwitter.api.TweetList;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class SearchTweetsEventOK {


    public final TweetList tweetsList;

    public SearchTweetsEventOK(TweetList tweets) {
        this.tweetsList = tweets;
    }

}
