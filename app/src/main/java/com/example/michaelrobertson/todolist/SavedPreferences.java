package com.example.michaelrobertson.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.prefs.Preferences;

/**
 * Created by michaelrobertson on 10/07/2017.
 */

public class SavedPreferences {

    private static final String PREF_SAVEDTYPE = "saved_type";
    private static final String PREF_SAVEDDESCRIPTION = "saved_description";
    private static final String PREF_SAVEDDATE = "saved_date";

    public static void setStoredType(Context context, String type) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDTYPE, type);
        editor.apply();

    }

    public static void setStoredDescription(Context context, String description) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDDESCRIPTION, description);
        editor.apply();

    }

    public static void setStoredDate(Context context, String date) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PREF_SAVEDDATE, date);
        editor.apply();

    }

    public static String getStoredText(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDTYPE, null);
    }

    public static String getStoredDescription(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDDESCRIPTION, null);
    }

    public static String getStoredDate(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(PREF_SAVEDDATE, null);
    }



}
