package com.virosms.ejercicio02;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.logging.Logger;

/**
 * ViewPagerAdapter es una subclase de FragmentStateAdapter que proporciona las vistas de fragmento para un ViewPager2.
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see FragmentStateAdapter
 * @see Fragment
 * @see FragmentManager
 * @see Lifecycle
 * @see Logger
 * @see Context
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    Logger logger = Logger.getLogger(ViewPagerAdapter.class.getName());
    private final Context context;

    /**
     * Constructor para ViewPagerAdapter.
     * @param context El contexto de la aplicación.
     * @param fragmentManager El administrador de fragmentos para interactuar con los fragmentos asociados con este adaptador.
     * @param lifecycle El ciclo de vida con el que se debe coordinar este adaptador.
     */
    public ViewPagerAdapter(Context context, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.context = context;
    }

    /**
     * Llamado para crear un fragmento para una posición dada.
     * @param position La posición del fragmento.
     * @return El fragmento que se creó.
     */
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

    /**
     * Devuelve el número total de elementos que se deben mostrar en el ViewPager2.
     * @return El número total de elementos.
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}