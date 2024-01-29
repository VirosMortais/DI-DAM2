package com.virosms.ejercicio02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());

        ViewPagerAdapter adapter = new ViewPagerAdapter
                (this, getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();


    }
}