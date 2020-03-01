package com.androidcodegeeks.usermanagementsystemapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public UserSharedPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("mydata",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUserLoggedin(boolean userLoggedin) {
        editor.putBoolean("userlogin",userLoggedin);
        editor.commit();
    }
    public boolean userLoggedin(){
        return sharedPreferences.getBoolean("userlogin",false);
    }
}
