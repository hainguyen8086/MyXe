package com.hainguyen8086.myxe.ui.linhkien;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hainguyen8086.myxe.R;

public class LinhkienFragment extends Fragment {

    private LinhkienViewModel linhkienViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        linhkienViewModel =
                new ViewModelProvider(this).get(LinhkienViewModel.class);
        View root = inflater.inflate(R.layout.fragment_linhkien, container, false);
        final TextView textView = root.findViewById(R.id.text_linhkien);
        linhkienViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}