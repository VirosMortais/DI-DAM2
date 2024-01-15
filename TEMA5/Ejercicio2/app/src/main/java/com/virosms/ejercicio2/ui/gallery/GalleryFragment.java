package com.virosms.ejercicio2.ui.gallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virosms.ejercicio2.R;
import com.virosms.ejercicio2.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    List<Integer> imagenes = new ArrayList<Integer>() {{
        add(R.drawable.image1);
        add(R.drawable.image2);
        add(R.drawable.image3);
        add(R.drawable.image4);
        add(R.drawable.image5);
        add(R.drawable.image6);
        add(R.drawable.image7);
        add(R.drawable.image8);
        add(R.drawable.image9);
    }};

    List<String> titulos = new ArrayList<String>() {{
        add("Cataratas del Niágara");
        add("Gran Cañón");
        add("Monte Everest");
        add("Monte Kilimanjaro");
        add("Monte Fuji");
        add("Monte Rushmore");
        add("Monte Saint-Michel");
        add("Monte Vesuvio");
        add("Monte Vesubio");
    }};

    private FragmentGalleryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentGalleryBinding.inflate(getLayoutInflater());


        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(new GallaryAdapter(imagenes, titulos));
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }
}