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
import com.doancuoiky.myxe.adapter.RecycleViewXeAdapter;
import com.doancuoiky.myxe.model.ViewXe;

import java.util.ArrayList;
import java.util.List;

public class XeFragment extends Fragment {

    private XeViewModel xeViewModel;
    //    private CardView cardViewAddXe;
    RecycleViewXeAdapter recycleViewXeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        xeViewModel =
                new ViewModelProvider(this).get(XeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_xe, container, false);

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

        xeViewModel.getListViewXe().observe(getViewLifecycleOwner(), new Observer<ArrayList<ViewXe>>() {
            @Override
            public void onChanged(ArrayList<ViewXe> viewXes) {
                List<String> tenXe = new ArrayList<>();
                List<String> bienSo = new ArrayList<>();
                for (ViewXe i:viewXes){
                    tenXe.add(i.getTenXe());
                    bienSo.add(i.getBienSo());
                }

                recycleViewXeAdapter = new RecycleViewXeAdapter(getActivity(), tenXe, bienSo);

                recyclerView.setAdapter(recycleViewXeAdapter);
                

            }
        });
        return root;
    }
}