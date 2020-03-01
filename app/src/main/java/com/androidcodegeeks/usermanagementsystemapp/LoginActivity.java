package com.androidcodegeeks.usermanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {
    Button loginBtn;
    TextView registerTV;
    EditText urname,pass;
    DataBaseHelper db;
    UserSharedPreferences usersharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        urname = findViewById(R.id.username_log);
        pass = findViewById(R.id.password_log);
        loginBtn = findViewById(R.id.login_btn);

        db = new DataBaseHelper(this);
        usersharedPreferences = new UserSharedPreferences(this);
        if (usersharedPreferences.userLoggedin()){
            startActivity(new Intent(getApplicationContext(),Active_User_Page.class));
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = urname.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if (user.isEmpty()){
                    urname.setError("user name not entered");
                    urname.requestFocus();
                }
                else if (pwd.isEmpty()){
                    pass.setError("password not entered");
                    pass.requestFocus();
                }
                else {
                    if (res == true) {
                        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("uname", user);
                        editor.commit();
                        usersharedPreferences.setUserLoggedin(true);
                        Intent intent = new Intent(getApplicationContext(), Active_User_Page.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Successfully logged", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                    }
                }
          }
        });
        registerTV = findViewById(R.id.register_tv);
        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

}
