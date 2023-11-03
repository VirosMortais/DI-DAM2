package com.example.playgames;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;



public class Preferences extends AppCompatActivity {

    private double progressChangedValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        SeekBar seekBar = findViewById(R.id.seekBar);
        var fab = findViewById(R.id.fab);

        final int maxValue = 5;

        seekBar.setMax(maxValue);
        ratingBar.setMax(maxValue);

        ratingBar.setOnRatingBarChangeListener(
                (RatingBar ratingBar2, float rating, boolean fromUser)->{
                //Método llamado cuando se llama el progreso de la RatingBar

                seekBar.setProgress((int)rating);
        });




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Método llamado cuando se cambia el progreso de la SeekBar
                ratingBar.setRating((float) progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(ratingBar.getContext(), "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup rg = findViewById(R.id.radioGroup);

        fab.setOnClickListener(v -> {
            RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
            if (rb != null) {
                Toast.makeText(this, "Game: " + rb.getText().toString() + "\n Rating: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            } else {
                // Show a message to the user asking them to select a game
                Toast.makeText(this, "Please select a game.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
