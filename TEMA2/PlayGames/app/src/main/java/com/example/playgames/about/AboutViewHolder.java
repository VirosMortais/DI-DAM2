package com.example.playgames.about;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playgames.R;

public class AboutViewHolder extends RecyclerView.ViewHolder{

    protected ImageView imageView;
    protected TextView nameView;
    protected TextView yearView;
    protected LinearLayout linearLayout;


    public AboutViewHolder(@NonNull View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.aboutImageView);
        this.nameView = itemView.findViewById(R.id.aboutName);
        this.yearView = itemView.findViewById(R.id.aboutYear);
        this.linearLayout = itemView.findViewById(R.id.linearLay);
    }
}
