package com.virosms.sol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.virosms.sol.databinding.ActivityCompPlanetaBinding;
import com.virosms.sol.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> images = new ArrayList<Integer>() {{
        add(R.drawable.corona_solar);
        add(R.drawable.erupcionsolar);
        add(R.drawable.espiculas);
        add(R.drawable.filamentos);
        add(R.drawable.magnetosfera);
        add(R.drawable.manchasolar);
    }};

    private List<String> titles = new ArrayList<String>() {{
        add("Corona Solar");
        add("Erupción Solar");
        add("Espículas");
        add("Filamentos");
        add("Magnetosfera");
        add("Mancha Solar");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(new PlanetaAdapter(images, titles));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CompPlaneta.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}