package com.androidcodegeeks.usermanagementsystemapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder>  {
    ArrayList<Home> homeArrayList;
    Context context;
    public HomeAdapter(ArrayList<Home> homeArrayList, Context context) {
        this.homeArrayList = homeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listuser,null);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeHolder holder, final int position) {
        final Home home = homeArrayList.get(position);
        holder.fullname.setText(home.getFullname());

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void itemOnClickListener(View view, int postion) {
                    Intent intent = new Intent(context, ViewDetailActivity.class);
                    String fullnameTitle = homeArrayList.get(postion).getFullname();
                    String email = homeArrayList.get(postion).getEmail();
                    String phone_num = homeArrayList.get(postion).getPhoneN();
                    String username = homeArrayList.get(postion).getUsername();
                    String gender = homeArrayList.get(postion).getGender();

                    intent.putExtra("fullname", fullnameTitle);
                    intent.putExtra("email",email);
                    intent.putExtra("phonenum",phone_num);
                    intent.putExtra("username",username);
                    intent.putExtra("gender",gender);
                    context.startActivity(intent);
                }
        });
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata", Context.MODE_PRIVATE);
        final String username = sharedPreferences.getString("uname", null);
        holder.setItemLongListner(new ItemLongListner() {            
            @Override
            public void itemOnLongListener(View view, int postion) {
                Home home1 = homeArrayList.get(postion);
                if (home1.getUsername().equals(username)){
                    Toast.makeText(context, "Not delete!!\n b/c This account current loggedIn", Toast.LENGTH_SHORT).show();
                }
                else {
                    homeArrayList.remove(postion);
                    notifyItemRemoved(postion);
                }
                return;
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeArrayList.size();
    }

}
