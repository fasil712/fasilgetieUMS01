package com.androidcodegeeks.usermanagementsystemapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String dbname = "userinfo.db";
    static final String tablename = "user";
    static final String col_fullname = "FullName";
    static final String col_email = "Email";
    static final String col_phone = "PhoneNum";
    static final String col_username = "UserName";
    static final String col_password = "Password";
    static final String col_gender = "Gender";
    public DataBaseHelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qrty = "Create table "+tablename+" ("+col_fullname+" text," +
                ""+col_email+" text,"+col_phone+" text,"+col_username
                +" text,"+col_gender+" text,"+col_password+" integer primary key)";
        db.execSQL(qrty);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
        onCreate(db);
    }
    public String userRegistered(String p1,String p2,String p3,String p4,String p5,String p6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_fullname,p1);
        contentValues.put(col_email,p2);
        contentValues.put(col_phone,p3);
        contentValues.put(col_username,p4);
        contentValues.put(col_gender,p5);
        contentValues.put(col_password,p6);

        long res = db.insert(tablename,null,contentValues);

        if (res==-1){
            return "failed!, please try again ?";
        }
        else {
            return "Successfully Registered";
        }
    }

    public boolean checkUser(String username, String password){
        String[] columns = {col_password};
        SQLiteDatabase db = getReadableDatabase();
        String selection = col_username + "=?" + " and " + col_password + "=?";
        String[] selectionArgs = {username,password};
        Cursor cursor = db.query(tablename,columns,selection
                ,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }
    public Integer deleteData(String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tablename,col_password+" =?",new String[]{pass});
    }
}
