package com.example.playgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        String[] numeros = {"Teléfono 1","Teléfono 2","Teléfono 3","Teléfono 4","Teléfono 5","Teléfono 6","Teléfono 7","Teléfono 8","Teléfono 9","Teléfono 10"};

        Spinner listaNumeros =  findViewById(R.id.spin);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numeros);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listaNumeros.setAdapter(adapter);

        listaNumeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}