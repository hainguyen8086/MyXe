package com.doancuoiky.myxe.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.activity.ChiTietXe;
import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.Xe;

import java.util.List;

public class VehicleAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Xe> list;
    int selected = -1;

    public VehicleAdapter(Context context, int layout, List<Xe> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void updateSelected(int index) {
        selected = index;
        GlobalFunction.selectedXe = list.get(index);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inf.inflate(layout, null);
        ImageView imageView = convertView.findViewById(R.id.cell_vehicle_imageView);
        TextView name = convertView.findViewById(R.id.cell_vehicle_name);
        TextView id = convertView.findViewById(R.id.cell_vehicle_id);
        id.setText(list.get(position).getBienSoXe());
        name.setText(list.get(position).getTenXe());
        Drawable res = context.getResources().getDrawable(GlobalFunction.motoIcons[position % GlobalFunction.motoIcons.length]);
        imageView.setImageDrawable(res);
        ImageView checkBox = convertView.findViewById(R.id.cell_vehicle_check);
        checkBox.setVisibility(position == selected ? View.VISIBLE : View.GONE);
        return convertView;
    }
}
