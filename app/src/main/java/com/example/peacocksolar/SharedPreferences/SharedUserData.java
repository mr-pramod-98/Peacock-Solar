package com.example.peacocksolar.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUserData {

    private static final String MY_PREFERENCES = "com.example.peacocksolar.MyUserPrefs" ;
    private static final String USERNAME = "name";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String EMAIL = "email";
    private static final String DATE_OF_BIRTH = "dateOfBirth";
    private static final String GENDER = "gender";
    private static final String USER_ID = "usedID";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;


    public SharedUserData() {

    }

    public SharedUserData(Context context) {
        preferences = context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }


    // GETTERS
    public String getName() {
        return preferences.getString(USERNAME, "Anonymous");
    }

    public String getPhoneNumber() {
        return preferences.getString(PHONE_NUMBER, null);
    }

    public String getEmail() {
        return preferences.getString(EMAIL, null);
    }

    public String getDateOfBirth() {
        return preferences.getString(DATE_OF_BIRTH, null);
    }

    public String getGender() {
        return preferences.getString(GENDER, null);
    }

    public int getUserID() {
        return preferences.getInt(USER_ID, 0);
    }

    // TODO: CHANGE TO FALSE
    public boolean getIsLoggedIn() {
        return preferences.getBoolean(IS_LOGGED_IN, false);
    }


    // SETTERS
    public void setName(String name) {
        editor.putString(USERNAME, name);
        editor.apply();
    }

    public void setPhoneNumber(String phoneNumber) {
        editor.putString(PHONE_NUMBER, phoneNumber);
        editor.apply();
    }

    public void setEmail(String email) {
        editor.putString(EMAIL, email);
        editor.apply();
    }

    public void setDateOfBirth(String dateOfBirth) {
        editor.putString(DATE_OF_BIRTH, dateOfBirth);
        editor.apply();
    }

    public void setGender(String gender) {
        editor.putString(GENDER, gender);
        editor.apply();
    }

    public void setUserID(int userID) {
        editor.putInt(USER_ID, userID);
        editor.apply();
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public void clearData() {
        editor.clear();
        editor.commit();
    }
}
