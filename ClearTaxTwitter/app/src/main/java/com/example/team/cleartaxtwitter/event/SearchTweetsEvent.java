package com.example.team.cleartaxtwitter.event;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class SearchTweetsEvent {


    public final String hashtag;
    public final String twitterToken;

    public SearchTweetsEvent(String twitterToken, String hashtag) {
        this.hashtag = hashtag;
        this.twitterToken = twitterToken;
    }

}
