package com.androidcodegeeks.usermanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        // start thread
        timer.start();
    }
}
