package com.virosms.placesintheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.virosms.placesintheworld.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding  = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Places in the World");

        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(new CardAdapter(imagenes, titulos));

        binding.floatingActionButton.setOnClickListener(v -> {
            Intent i = new Intent(this, PointsOfInterest.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}