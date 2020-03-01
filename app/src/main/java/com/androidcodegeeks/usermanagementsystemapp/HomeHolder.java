package com.androidcodegeeks.usermanagementsystemapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    ItemClickListner itemClickListner;
    ItemLongListner itemLongListner;
    TextView fullname;
    ImageView imageView;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView_icon);
        fullname = itemView.findViewById(R.id.listfullname);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListner.itemOnClickListener(v,getLayoutPosition());
    }
    public void setItemClickListner(ItemClickListner ic){
        this.itemClickListner = ic;
    }

    public void setItemLongListner(ItemLongListner ic){
        this.itemLongListner = ic;
    }

    @Override
    public boolean onLongClick(View v) {
        this.itemLongListner.itemOnLongListener(v,getLayoutPosition());
        return true;
    }
}
