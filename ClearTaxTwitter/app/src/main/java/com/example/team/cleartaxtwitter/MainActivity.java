
package com.example.team.cleartaxtwitter;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.os.Bundle;

import com.example.team.cleartaxtwitter.util.ActivityHelper;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityHelper.navigateTo(this, new WelcomeFragment(), false, R.id.container_main);

        //Handle when activity is recreated like on orientation Change

    }




}