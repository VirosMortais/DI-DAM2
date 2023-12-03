package com.virosms.ejercicio01tema4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<ImgViewHolder> {

    private List<Integer> imgList;

    public ImgAdapter(List<Integer> imgList) {
        this.imgList = imgList;
    }


    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_layout, parent, false);
        return new ImgViewHolder(view);
    }

    /**
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ImgViewHolder holder, int position) {
        int img = imgList.get(position);
        holder.img.setImageResource(img);

        holder.img.setOnClickListener(v -> {
            ImageSwitcher imageSwitcher = v.getRootView().findViewById(R.id.img_switcher);
            imageSwitcher.setImageResource(img);
        });
    }


    /**
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return imgList.size();
    }
}
