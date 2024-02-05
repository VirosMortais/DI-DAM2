package com.virosms.ejercicio02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * GalleryFragment es una subclase de Fragment que muestra una galería de imágenes con títulos.
 * Las imágenes y los títulos se muestran en un RecyclerView con un StaggeredGridLayoutManager.
 * Cada elemento del RecyclerView es una CardView que contiene una imagen y un título.
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see Fragment
 * @see RecyclerView
 * @see StaggeredGridLayoutManager
 * @see LayoutInflater
 * @see ViewGroup
 * @see Bundle
 * @see View
 * @see GallaryAdapter
 * @see R.layout#fragment_gallery
 */
public class GalleryFragment extends Fragment {

    // Lista de recursos de imagen
    List<Integer> imagenes = new ArrayList<Integer>() {{
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

    // Lista de títulos
    List<String> titulos = new ArrayList<String>() {{
        add("Cataratas del Niágara");
        add("Gran Cañón");
        add("Monte Everest");
        add("Monte Kilimanjaro");
        add("Monte Fuji");
        add("Monte Rushmore");
        add("Monte Saint-Michel");
        add("Monte Vesuvio");
        add("Monte Vesubio");
    }};

    /**
     * Llamado cuando se ha creado la actividad del fragmento y se ha instanciado la jerarquía de vistas de este fragmento.
     * @param savedInstanceState Si el fragmento se está recreando a partir de un estado guardado anterior, este es el estado.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Llamado para que el fragmento instancie su interfaz de usuario.
     * @param inflater El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento.
     * @param container Si no es nulo, esta es la vista principal a la que se debe adjuntar la interfaz de usuario del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior como se da aquí.
     * @return Devuelve la Vista para la interfaz de usuario del fragmento, o null.
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    /**
     * Llamado inmediatamente después de que onCreateView(LayoutInflater, ViewGroup, Bundle) ha devuelto, pero antes de que se haya restaurado cualquier estado guardado en la vista.
     * @param view La Vista devuelta por onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior como se da aquí.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa el RecyclerView y establece su administrador de diseño y adaptador
        RecyclerView recyclerView = requireView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        GallaryAdapter gallaryAdapter = new GallaryAdapter(imagenes, titulos);

        recyclerView.setAdapter(gallaryAdapter);
    }
}