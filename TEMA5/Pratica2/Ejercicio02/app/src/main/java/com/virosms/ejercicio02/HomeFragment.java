package com.virosms.ejercicio02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * HomeFragment es una subclase de Fragment que representa la pantalla de inicio de la aplicación.
 * Un fragmento es una parte de la interfaz de usuario en una Activity que puede definirse o modificarse por separado.
 * @see <a href="https://developer.android.com/guide/components/fragments">Fragments</a>
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see <a href="https://developer.android.com/guide/components/fragments">Fragments</a>
 *
 */
public class HomeFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}