package com.virosms.ejercicio02;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * PlaceHolderFragment es una subclase de Fragment que representa un fragmento de marcador de posición en la aplicación.
 * Cada instancia de este fragmento debe tener un número de sección asociado.
 * Los fragmentos que contienen este fragmento deben estar vinculados a una instancia de SectionsPagerAdapter.
 * Ver también: SectionsPagerAdapter.
 * @author charles
 * @version 1.0
 * @since 2024-02-05
 * @see Fragment
 * @see MainActivity
 * @see R.layout#place_holder_fragment
 */
public class PlaceHolderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Constructor vacío requerido para la creación de fragmentos.
     */
    public PlaceHolderFragment() {
    }

    /**
     * Crea una nueva instancia de PlaceHolderFragment con un número de sección específico.
     * @param sectionNumber El número de sección para este fragmento.
     * @return Una nueva instancia de PlaceHolderFragment.
     */
    public static PlaceHolderFragment newInstance(int sectionNumber) {
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Llamado cuando se está iniciando el fragmento. Aquí es donde se debe realizar la mayoría de las inicializaciones.
     * @param savedInstanceState Si el fragmento se está reiniciando después de una parada anterior, este contiene los datos que más recientemente se suministraron en onSaveInstanceState(Bundle). De lo contrario, es nulo.
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        return inflater.inflate(R.layout.place_holder_fragment, container, false);
    }

    /**
     * Llamado inmediatamente después de onCreateView(LayoutInflater, ViewGroup, Bundle) ha devuelto, pero antes de que se haya restaurado cualquier estado guardado en la vista.
     * @param view La Vista devuelta por onCreateView(LayoutInflater, ViewGroup, Bundle).
     * @param savedInstanceState Si no es nulo, este fragmento se está reconstruyendo a partir de un estado guardado anterior como se da aquí.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ARG_SECTION_NUMBER)) {
            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            TextView textView = view.findViewById(R.id.section_label);
            textView.setText("FRAGMENT " + String.valueOf(sectionNumber));
        }
    }
}