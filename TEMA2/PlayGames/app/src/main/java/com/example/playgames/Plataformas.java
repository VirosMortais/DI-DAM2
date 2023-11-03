package com.example.playgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}