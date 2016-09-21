package com.example.team.cleartaxtwitter.util;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

/**
 * Created by Prakhar on 21-Sep-16.
 */

public final class Util {

    public static final int INTERNET_CONN_CHECK_TIMEOUT = 1800;

    private static final String TAG = Util.class.getName();

    private Util() {

    }

    public static void makeToast(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static String getBase64String(String value) throws UnsupportedEncodingException {
        return Base64.encodeToString(value.getBytes("UTF-8"), Base64.NO_WRAP);
    }

}