package com.androidcodegeeks.usermanagementsystemapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Active_User_Page extends AppCompatActivity {
    TextView textViewUN;
    WebView webViewforAndroid;
    UserSharedPreferences userSharedPreferences;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active__user__page);
        textViewUN = findViewById(R.id.upUserName);
        webViewforAndroid = findViewById(R.id.webview);
        webViewforAndroid.setWebViewClient(new WebViewClient());
        webViewforAndroid.loadUrl("https://www.youtube.com/channel/UCGGFhNGxyY01OI7bH_QCwiA/featured");
        sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("uname", null);
        textViewUN.setText(username);
        userSharedPreferences = new UserSharedPreferences(this);
        if (!userSharedPreferences.userLoggedin()){
            logout();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void logout(){
        userSharedPreferences.setUserLoggedin(false);
        finish();
        sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("uname");
        editor.commit();
        startActivity(new Intent(this,LoginActivity.class));
        textViewUN.setText("");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_active__user__page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_view_details) {
            startActivity(new Intent(Active_User_Page.this,UserListActivity.class));
            return true;
        }else if(id==R.id.action_logout){
            logout();
        }
        else if(id==R.id.action_about){
            startActivity(new Intent(this, About_Developer.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
