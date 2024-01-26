package com.virosms.mymail.ui.outbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.virosms.mymail.databinding.FragmentOutboxBinding;

public class OutboxFragment extends Fragment {

    private FragmentOutboxBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OutboxViewModel outboxViewModel =
                new ViewModelProvider(this).get(OutboxViewModel.class);

        binding = FragmentOutboxBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textOutbox;
        outboxViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}