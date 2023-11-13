package com.example.playgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        CheckBox check1 = (CheckBox) findViewById(R.id.angryBirdsCheckBox);
        CheckBox check2 = (CheckBox) findViewById(R.id.dragonFlyCheckBox);
        CheckBox check3 = (CheckBox) findViewById(R.id.hillClimbingRacingCheckBox);
        CheckBox check4 = (CheckBox) findViewById(R.id.radiantDefenseCheckBox);
        CheckBox check5 = (CheckBox) findViewById(R.id.ninJumpCheckBox);
        CheckBox check6 = (CheckBox) findViewById(R.id.pocketSoccerCheckBox);

        var fab = findViewById(R.id.fab);



        fab.setOnClickListener(view -> {
            List<String> games = new ArrayList<>();

            if (check1.isChecked()) {
               games.add("Angry Birds");
            }
            if (check2.isChecked()) {
                games.add("Dragon Fly");
            }
            if (check3.isChecked()) {
                games.add("Hill Climbing Racing");
            }
            if (check4.isChecked()) {
                games.add("Radiant Defense");
            }
            if (check5.isChecked()) {
                games.add("Ninja Jump");
            }
            if (check6.isChecked()) {
                games.add("Pocket Soccer");
            }

            String gamesString = String.join(", ", games);
            Toast.makeText(getApplicationContext(), "Games: " + gamesString, Toast.LENGTH_LONG).show();
        });

    }
}