package com.doancuoiky.myxe.ui.xang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.doancuoiky.myxe.R;

public class XangFragment extends Fragment {

    private XangViewModel xangViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        xangViewModel =
                new ViewModelProvider(this).get(XangViewModel.class);
        View root = inflater.inflate(R.layout.fragment_xang, container, false);
//        final TextView textView = root.findViewById(R.id.text_xang);
//        xangViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


//        final int MIN_CHARS = 10;
//        String fullText;
//        final boolean[] isExpanded = new boolean[1];
//
//        TextView textViewDropdown = root.findViewById(R.id.expandableTextView);
//        ImageButton imageButton = root.findViewById(R.id.expandBtn);
//
//        fullText = textView.getText().toString();
//        textView.setText(fullText.substring(0,MIN_CHARS));
//        imageButton.setImageResource(R.drawable.ic_add);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isExpanded[0] = !isExpanded[0];
//                imageButton.setImageResource(isExpanded[0] ?R.drawable.ic_castro:R.drawable.ic_petro);
//                textView.setText(isExpanded[0] ?fullText:fullText.substring(0,MIN_CHARS));
//            }
//        });

        
        return root;
    }
}