package com.virosms.ejercicio02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * MainActivity es una subclase de AppCompatActivity que representa la actividad principal de la aplicación.
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see AppCompatActivity
 * @see ViewPager2
 * @see TabLayout
 * @see TabLayoutMediator
 * @see ViewPagerAdapter
 * @see ZoomOutPageTransformer
 * @see R.layout#activity_main
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Llamado cuando se está iniciando la actividad. Aquí es donde se debe realizar la mayoría de las inicializaciones: llamar a setContentView(int) para inflar la interfaz de usuario de la actividad, usar findViewById(int) para interactuar con los widgets de la interfaz de usuario.
     * @param savedInstanceState Si la actividad se está reiniciando después de una parada anterior, este contiene los datos que más recientemente se suministraron en onSaveInstanceState(Bundle). De lo contrario, es nulo.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ViewPager2 y establece su transformador de página
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());

        // Inicializa el adaptador de la vista de página y lo establece en el ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter
                (this, getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        // Inicializa el TabLayout
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Crea un nuevo mediador de TabLayout y ViewPager2 y lo adjunta
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();
    }
}