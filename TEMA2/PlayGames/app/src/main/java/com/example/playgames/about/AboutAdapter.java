package com.example.playgames.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playgames.R;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<AboutViewHolder>{

    private final List<Integer> images;

    private final List<String> names;

    private final List<String> years;
    private final Context context;

    public AboutAdapter(List<Integer> images, List<String> names, List<String> years, Context context) {
        this.images = images;
        this.names = names;
        this.years = years;
        this.context = context;
    }

    @NonNull
    @Override
    public AboutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.about_item, parent, false);

        return new AboutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutViewHolder holder, int position) {
        String name = this.names.get(position);
        String year = this.years.get(position);
        int image = this.images.get(position);

        holder.nameView.setText(name);
        holder.yearView.setText(year);
        holder.imageView.setImageResource(image);


        holder.linearLayout.setOnClickListener(
                v -> Toast.makeText(context, name, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return images != null && names != null && years != null ? images.size() : 0;
    }
}
