package com.virosms.ejercicio2.ui.gallery;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virosms.ejercicio2.R;

import java.util.List;

public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.GallaryViewHolder> {
    public List<Integer> images;
    public List<String> titles;

    private ActionMode actionMode;

    public GallaryAdapter(List<Integer> images, List<String> titles) {
        this.images = images;
        this.titles = titles;
    }

    @NonNull
    @Override
    public GallaryAdapter.GallaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new GallaryViewHolder(view);
    }

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

        holder.imageView.setOnLongClickListener(v -> {
            if (actionMode != null) {
                return false;
            }

            actionMode = holder.imageView.startActionMode(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.action_menu, menu);
                    toolbar.setVisibility(View.GONE);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, android.view.MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.nav_eliminar_img:
//                            images.remove(position);
//                            titles.remove(position);
//                            notifyItemRemoved(position);
//                            mode.finish();
//                            return true;
//                        default:
//                            return false;
//                    }
//                }
                    return false;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    actionMode = null;
                    toolbar.setVisibility(View.VISIBLE);

                }
            });

            return true;
        });
    }



    @Override
    public int getItemCount() {
        return images != null && titles != null ? Math.min(images.size(), titles.size()) : 0;
    }

    static class GallaryViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView title;
        public final Button acceptButton;
        public final Button cancelButton;

        public GallaryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);
        }

    }
}
