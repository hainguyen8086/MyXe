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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inf.inflate(layout, null);
        ImageView imageView = convertView.findViewById(R.id.cell_vehicle_imageView);
        TextView name = convertView.findViewById(R.id.cell_vehicle_name);
        TextView id = convertView.findViewById(R.id.cell_vehicle_id);
        id.setText(list.get(position).getBienSoXe());
        name.setText(list.get(position).getTenXe());
        Drawable res = context.getResources().getDrawable(R.drawable.img_moto);
        imageView.setImageDrawable(res);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalFunction.selectedXe = list.get(position);
                Intent intent = new Intent(context, ChiTietXe.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
