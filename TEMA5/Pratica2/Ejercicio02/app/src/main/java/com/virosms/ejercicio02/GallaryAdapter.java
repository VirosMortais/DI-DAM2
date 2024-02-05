package com.virosms.ejercicio02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * GallaryAdapter es una subclase de RecyclerView.Adapter que se utiliza para mostrar una lista de imágenes y títulos en un RecyclerView.
 * Cada elemento en el RecyclerView está representado por un GallaryViewHolder.
 * @author Charles
 * @since 2024-02-05
 * @version 1.0
 * @see RecyclerView.Adapter
 * @see GallaryViewHolder
 * @see RecyclerView
 * @see R.layout#card_layout
 */
public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.GallaryViewHolder> {
    public List<Integer> images; // Lista de recursos de imagen
    public List<String> titles; // Lista de títulos

    /**
     * Constructor para GallaryAdapter.
     * @param images Lista de recursos de imagen
     * @param titles Lista de títulos
     */
    public GallaryAdapter(List<Integer> images, List<String> titles) {
        this.images = images;
        this.titles = titles;
    }

    /**
     * Llamado cuando RecyclerView necesita un nuevo RecyclerView.ViewHolder del tipo dado para representar un elemento.
     * @param parent El ViewGroup en el que se agregará la nueva Vista después de que se vincule a una posición del adaptador.
     * @param viewType El tipo de vista de la nueva Vista.
     * @return Un nuevo ViewHolder que contiene una Vista del tipo de vista dado.
     */
    @NonNull
    @Override
    public GallaryAdapter.GallaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new GallaryViewHolder(view);
    }

    /**
     * Llamado por RecyclerView para mostrar los datos en la posición especificada.
     * @param holder El ViewHolder que debe actualizarse para representar el contenido del elemento en la posición dada en el conjunto de datos.
     * @param position La posición del elemento dentro del conjunto de datos del adaptador.
     */
    @Override
    public void onBindViewHolder(@NonNull GallaryAdapter.GallaryViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Toolbar toolbar = holder.itemView.findViewById(R.id.toolbar);

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

        holder.imageView.setOnCreateContextMenuListener((menu, v, menuInfo) -> {
            MenuInflater inflater = new MenuInflater(context);
            inflater.inflate(R.menu.context_menu, menu);
        });

    }

    /**
     * Devuelve el número total de elementos en el conjunto de datos que mantiene el adaptador.
     * @return El número total de elementos en este adaptador.
     */
    @Override
    public int getItemCount() {
        return images != null && titles != null ? Math.min(images.size(), titles.size()) : 0;
    }

    /**
     * Un ViewHolder describe una vista de elemento y metadatos sobre su lugar dentro del RecyclerView.
     */
    static class GallaryViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView; // ImageView para mostrar la imagen
        public final TextView title; // TextView para mostrar el título
        public final Button acceptButton; // Botón para aceptar el elemento
        public final Button cancelButton; // Botón para cancelar el elemento

        /**
         * Constructor para GallaryViewHolder.
         * @param itemView La Vista que inflaste en onCreateViewHolder().
         */
        public GallaryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);
        }

    }
}