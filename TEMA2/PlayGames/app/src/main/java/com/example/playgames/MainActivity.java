package com.example.playgames;

import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.playgames.search.Plataformas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newPlayerButton = findViewById(R.id.newPlayerButton);
        Button preferencesButton = findViewById(R.id.PreferecesButton);
        Button playButton = findViewById(R.id.PlayButton);

        newPlayerButton.setOnClickListener(v -> {
            Intent i = new Intent(this, NewPlayer.class);
            startActivity(i);
        });

        preferencesButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Preferences.class);
            startActivity(i);
        });

        playButton.setOnClickListener(v -> {
            Intent i = new Intent(this, games.class);
            startActivity(i);
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_buscar){
            Intent i = new Intent(this, Plataformas.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}