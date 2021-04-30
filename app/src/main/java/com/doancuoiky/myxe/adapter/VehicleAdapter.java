package com.doancuoiky.myxe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

        return convertView;
    }
}
