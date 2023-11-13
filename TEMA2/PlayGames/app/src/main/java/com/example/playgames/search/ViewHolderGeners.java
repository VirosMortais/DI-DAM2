package com.example.playgames.search;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playgames.R;

public class ViewHolderGeners extends RecyclerView.ViewHolder{

    protected TextView genero;

    public ViewHolderGeners(@NonNull View itemView) {
        super(itemView);

        genero = itemView.findViewById(R.id.textItemGenero);
    }
}
