package com.virosms.ejercicio01tema4;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImgViewHolder extends RecyclerView.ViewHolder{

        protected ImageView img;

        public ImgViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_recycler_view);
        }
}
