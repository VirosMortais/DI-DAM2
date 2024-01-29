package com.virosms.ejercicio02;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlaceHolderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    public PlaceHolderFragment() {
    }
    public static PlaceHolderFragment newInstance(int sectionNumber) {
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.place_holder_fragment, container, false);
    }
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
