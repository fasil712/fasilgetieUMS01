package com.androidcodegeeks.usermanagementsystemapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewDetailActivity extends AppCompatActivity {

    TextView fullname,email,username,phone_number,gender;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        dbHelper = new DataBaseHelper(this);

        fullname = findViewById(R.id.tvfullname);
        email = findViewById(R.id.tvemail);
        phone_number = findViewById(R.id.tvPhone);
        username = findViewById(R.id.tvUserName);
       // password = findViewById(R.id.tvpassword);
        gender = findViewById(R.id.tvgender);

        ActionBar actionBar = getSupportActionBar();
        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("fullname");
        fullname.setText(mTitle);
        String emailname = intent.getStringExtra("email");
        email.setText(emailname);
        String setphone = intent.getStringExtra("phonenum");
        phone_number.setText(setphone);
        String setusername = intent.getStringExtra("username");
        username.setText(setusername);
        //String setpassword = intent.getStringExtra("password");
       // password.setText(setpassword);
        String setgender = intent.getStringExtra("gender");
        gender.setText(setgender);

        actionBar.setTitle(mTitle + " detail info");
    }

    public void ok(View view) {
        Intent intent = new Intent(ViewDetailActivity.this,UserListActivity.class);
        startActivity(intent);
        finish();
    }
}
