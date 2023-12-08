package com.virosms.placesintheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.virosms.placesintheworld.databinding.ActivityPointsOfInterestBinding;

import java.util.ArrayList;
import java.util.List;

public class PointsOfInterest extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityPointsOfInterestBinding binding = ActivityPointsOfInterestBinding
                .inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.floatingActionButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

        binding.chipGroup.setOnCheckedStateChangeListener((group, checkedId) -> {
            for (Integer id : checkedId) {
                Chip chip = group.findViewById(id);
                if(chip != null){
                    Toast.makeText(this,"ADD: "+ chip.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.actividades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinner.setAdapter(adapter);
    }
}