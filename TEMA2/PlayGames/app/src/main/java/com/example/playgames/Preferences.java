package com.example.playgames;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Preferences extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        SeekBar seekBar = findViewById(R.id.seekBar);
        var fab = findViewById(R.id.fab);

        ratingBar.setOnRatingBarChangeListener(
                (RatingBar ratingBar2, float rating, boolean fromUser)->{
                //Método llamado cuando se llama el progreso de la RatingBar
        });


        final int maxValue = 5;
        final int minValue = 0;
        final double stepValue = 0.5;

        seekBar.setMax((int) ((maxValue - minValue) / stepValue));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            double progressChangedValue;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Método llamado cuando se cambia el progreso de la SeekBar
                progressChangedValue = minValue + (progress * stepValue);
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

        fab.setOnClickListener(v -> {
                Toast.makeText(this, "FAB Clicked!", Toast.LENGTH_SHORT).show();
        });

    }
}
