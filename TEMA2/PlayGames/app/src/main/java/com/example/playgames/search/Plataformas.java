package com.example.playgames.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playgames.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.chip.Chip;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;
import java.util.List;



public class Plataformas extends AppCompatActivity{


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
        add("Familiares");
        add("Arcade");
        add("Otros");
    }};
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plataformas);

        recyclerView = findViewById(R.id.generosRecyclerView);
        var fab = findViewById(R.id.fab);



        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);



        fab.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(v, "Boton desplazado hacia arriba", Snackbar.LENGTH_LONG);
            snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
            snackbar.show();
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        });


        GenersAdapter adapter = new GenersAdapter(generos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adapter);

    }

    public void showChip(View view){
        Chip chip = (Chip) view;
        Toast.makeText(this, chip.getText(), Toast.LENGTH_SHORT).show();
    }


}