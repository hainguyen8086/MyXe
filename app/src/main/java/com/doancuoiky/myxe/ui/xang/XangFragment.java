package com.doancuoiky.myxe.ui.xang;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.adapter.FuelAdapter;
import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.BaseCell;

import java.util.ArrayList;
import java.util.List;

public class XangFragment extends Fragment {

    ListView listView;
    TextView textView;
    List<BaseCell> list = new ArrayList<>();
    FuelAdapter fuelAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_xang, container, false);
        listView = root.findViewById(R.id.xang_listView);
        textView = root.findViewById(R.id.xang_textView);
        GlobalFunction.hideSoftKeyboard(getActivity());
        textView.setText("Xe đang chọn: XE ABC");
        list.add(new BaseCell(R.drawable.ic_moto, "Tiền đổ xăng", "Nhập số tiền đổ xăng"));
        list.add(new BaseCell(R.drawable.ic_moto, "Dung tích", "Nhập số lit xăng đã đổ"));
        list.add(new BaseCell(R.drawable.ic_moto, "Số km", "Nhập số km hiện tại"));
        list.add(new BaseCell(R.drawable.ic_moto, "Địa chỉ", "Địa chỉ cây xăng"));
        renderList();
        return root;
    }

    public void renderList() {
        fuelAdapter = new FuelAdapter(getActivity(), R.layout.cell_add_fuel, list);
        listView.setAdapter(fuelAdapter);
    }

}