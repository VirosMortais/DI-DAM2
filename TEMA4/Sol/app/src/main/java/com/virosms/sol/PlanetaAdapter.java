package com.virosms.sol;

import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaAdapter.PlanetaViewHolder> {
    private List<Integer> images;
    private List<String> titles;

    public PlanetaAdapter(List<Integer> images, List<String> titles) {
        this.images = images;
        this.titles = titles;
    }

    public class PlanetaViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final Toolbar toolbar;
        public PlanetaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            toolbar = itemView.findViewById(R.id.toolbar);
        }
    }
    @NonNull
    @Override
    public PlanetaAdapter.PlanetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new PlanetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.toolbar.setTitle(titles.get(position));
        holder.toolbar.inflateMenu(R.menu.toolbar_menu);

        holder.toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getTitle().toString()){
                case "Eliminar":
                    images.remove(position);
                    titles.remove(position);
                    notifyItemRemoved(holder.getAdapterPosition());
                    break;
                case "Copiar":
                    images.add(position + 1, images.get(position));
                    titles.add(position, titles.get(position));
                    notifyItemInserted(holder.getAdapterPosition());
                    break;
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return images != null && titles != null ? images.size() : 0;
    }
}
