package com.userdetail.account.utils;

import android.util.Log;

import com.userdetail.account.BuildConfig;

/**
 * Wrapper class for logging. Logs are disabled on release versions
 */


public class Logger {
    private static final String TAG = "ACCOUNT_DETAILS";

    public static void d(String string) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, string);
        }
    }

    public static void v(String string) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, string);
        }
    }

    public static void i(String string) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, string);
        }
    }

    public static void e(String string) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, string);
        }
    }

    public static void w(String string) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, string);
        }
    }

}
