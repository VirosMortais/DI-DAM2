package com.example.playgames;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;
import java.util.List;



public class Plataformas extends AppCompatActivity{

    private ListView listView;
    private List<String> generos = new ArrayList<>() {{
        add("Plataformas");
        add("Aventura");
        add("Estrategia");
        add("Deportes");
        add("Carreras");
        add("Shooter");
        add("Lucha");
        add("Simulación");
        add("Rol");
        add("Puzzle");
        add("Musical");
        add("Educativo");
        add("Otros");

    }};
    private ArrayAdapter<String> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plataformas);

        listView = findViewById(R.id.generosListView);

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, generos);
        listView.setAdapter(adaptador);

        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);
        var fab = findViewById(R.id.fab);

        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

        fab.setOnClickListener(v -> {
            Snackbar.make(v, "El botón se desplaza hacia arriba", Snackbar.LENGTH_LONG).show();
        });

    }


}