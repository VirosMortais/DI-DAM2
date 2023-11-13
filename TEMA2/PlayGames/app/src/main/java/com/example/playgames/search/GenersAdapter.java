package com.example.playgames.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playgames.R;

import java.util.List;

public class GenersAdapter extends RecyclerView.Adapter<ViewHolderGeners>{

    private List<String> generosList;
    private Context context;

    public GenersAdapter(List<String> generosList, Context context) {
        this.generosList = generosList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderGeners onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_item, parent, false);
        return new ViewHolderGeners(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGeners holder, int position) {

            String genero = generosList.get(position);
            holder.genero.setText(genero);

            holder.genero.setOnClickListener(v -> Toast.makeText(context, genero, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return generosList == null ? 0 : generosList.size();
    }
}
