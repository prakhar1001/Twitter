package com.example.team.cleartaxtwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Prakhar on 21-Sep-16.
 */
public class TweetAnalytics extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweetanalytics);
        String msg = null;
        Bundle extras = getIntent().getExtras();

        if (extras != null)

        {
            msg = extras.getString("TweetMessage");

        }
        TextView msgtv = (TextView) findViewById(R.id.msg);
        if (!msg.equals(null))
            msgtv.setText(msg);

       /* String[] words = msg.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].replaceAll("[^\\w]", "");
            msgtv.setText(words[i]);
        }*/


    }
}
