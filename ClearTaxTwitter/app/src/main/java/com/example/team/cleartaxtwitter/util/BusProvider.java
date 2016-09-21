package com.example.team.cleartaxtwitter.util;

import com.squareup.otto.Bus;

/**
 * Created by Prakhar on 21-Sep-16.
 */

public class BusProvider {
    private static Bus mInstance = null;

    private BusProvider() {

    }

    public static Bus getInstance() {
        if (mInstance == null) {
            mInstance = new Bus();
        }
        return mInstance;
    }
}