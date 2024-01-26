package com.virosms.pratica2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout abas = findViewById(R.id.tab_layout);
        abas.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            Fragment fragment;
            @Override
            public void onTabSelected(TabLayout.Tab aba) {
                switch (aba.getPosition()){
                    case 0 -> fragment = new HomeFragment();
                    case 1 -> fragment = new GalleryFragment();
                    case 2 -> fragment = new SlideShowFragment();
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_fragment, fragment)
                        .commit();
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(aba.getText());
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab aba) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab aba) {
            }
        });
    }
}