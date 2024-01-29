package com.virosms.ejercicio02;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.logging.Logger;

public class ViewPagerAdapter extends FragmentStateAdapter {

    Logger logger = Logger.getLogger(ViewPagerAdapter.class.getName());
    private final Context context;
    public ViewPagerAdapter(Context context, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.context = context;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        logger.info("createFragment: " + position);
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new GalleryFragment();
            default:
                return new SlideShowFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
