package com.androidcodegeeks.usermanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    RecyclerView recyclerViewUL;
    DataBaseHelper dataBaseHelper;
    ArrayList<Home> homeArrayList;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        recyclerViewUL = findViewById(R.id.rvListofusers);
        homeArrayList = new ArrayList<>();
      try {
          dataBaseHelper = new DataBaseHelper(this);
          SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
          if (db != null) {
              Cursor res = db.rawQuery("select * from user", null);
              if (res.getCount() == 0) {
                  Toast.makeText(this, "no data is returned", Toast.LENGTH_SHORT).show();
              } else {
                  while (res.moveToNext()) {
                     homeArrayList.add(new Home(
                             res.getString(0),
                             res.getString(1),
                             res.getString(2),
                             res.getString(3),
                             res.getString(4),
                             res.getString(5)));
                  }
                  homeAdapter = new HomeAdapter(homeArrayList,this);
                  recyclerViewUL.hasFixedSize();
                  recyclerViewUL.setLayoutManager(new LinearLayoutManager(this));
                  recyclerViewUL.setAdapter(homeAdapter);
              }
          } else {
              Toast.makeText(this, "data is null...", Toast.LENGTH_SHORT).show();
          }
      }
      catch (Exception e){
          Toast.makeText(this, "no Show data value "+e.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }
}
