package com.doancuoiky.myxe.ui.xe;

import android.content.Intent;
import android.net.Uri;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.activity.ThemXe;

public class XeFragment extends Fragment {

    private XeViewModel xeViewModel;
//    private CardView cardViewAddXe;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        xeViewModel =
                new ViewModelProvider(this).get(XeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_xe, container, false);
        final TextView textView = root.findViewById(R.id.text_xe);
        xeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
//        final CardView cardViewAddXe = root.findViewById(R.id.cardview_add_xe);
////        cardViewAddXe.findViewById(R.id.cardview_add_xe);
//        cardViewAddXe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(getContext(), "clicked card", Toast.LENGTH_SHORT).show();
//                Log.e("card", "clicked");
//                System.out.println("you click ");
//            }
//        });

        final RecyclerView recyclerView=root.findViewById(R.id.recycleview_xe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));


        Uri uri;
        Intent intent=new Intent(getActivity(),ThemXe.class);
        final TextView textViewAddXe=root.findViewById(R.id.textview_button_add);
        textViewAddXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("clicked text on cardview");
                startActivity(intent);
            }
        });
        return root;
    }
}