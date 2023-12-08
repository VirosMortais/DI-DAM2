package com.virosms.placesintheworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{
    public List<Integer> images;
    public List<String> titles;

    public CardAdapter(List<Integer> images, List<String> titles) {
        this.images = images;
        this.titles = titles;
    }

    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new CardViewHolder(view);
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.title.setText(titles.get(position));

        holder.acceptButton.setOnClickListener(v -> {
            images.add(position + 1, images.get(position));
            titles.add(position + 1, titles.get(position));
            notifyItemInserted(position + 1);
        });

        holder.cancelButton.setOnClickListener(v -> {
            images.remove(position);
            titles.remove(position);
            notifyItemRemoved(position);
        });
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return images != null && titles != null ? Math.min(images.size(), titles.size()) : 0;
    }

    static class  CardViewHolder extends RecyclerView.ViewHolder{

        public final ImageView imageView;
        public final TextView title;
        public final Button acceptButton;
        public final Button cancelButton;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);
        }
    }
}
