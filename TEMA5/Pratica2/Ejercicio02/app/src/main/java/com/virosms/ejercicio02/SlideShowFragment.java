package com.virosms.ejercicio02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * SlideShowFragment es una subclase de Fragment que representa un fragmento de presentación de diapositivas en la aplicación.
 * @author charles
 * @version 1.0
 * @since 2023-02-05
 * @see Fragment
 * @see LayoutInflater
 * @see View
 */
public class SlideShowFragment extends Fragment {

    /**
     * Llamado para que el fragmento instancie su interfaz de usuario.
     * @param inflater El objeto LayoutInflater que se puede usar para inflar cualquier vista en el fragmento.
     * @param container Si no es nulo, esta es la vista principal a la que se debe adjuntar la interfaz de usuario del fragmento.
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior como se da aquí.
     * @return Devuelve la Vista para la interfaz de usuario del fragmento, o null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        return inflater.inflate(R.layout.fragment_slide_show, container, false);
    }
}