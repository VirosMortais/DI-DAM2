package com.virosms.ejercicio01tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> imgs = new ArrayList<Integer>() {{
           add(R.drawable.image1);
           add(R.drawable.image2);
           add(R.drawable.image3);
           add(R.drawable.image4);
           add(R.drawable.image5);
           add(R.drawable.image6);
           add(R.drawable.image7);
           add(R.drawable.image8);
           add(R.drawable.image9);
        }};

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ImgAdapter imgAdapter = new ImgAdapter(imgs);

        recyclerView.setAdapter(imgAdapter);

        ImageSwitcher imageSwitcher = findViewById(R.id.img_switcher);

        imageSwitcher.setFactory(() -> new ImageView(getApplicationContext()));

    }
}