package com.doancuoiky.myxe.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.model.BaseCell;
import com.doancuoiky.myxe.model.LichSuDoXang;

import java.util.List;

public class FuelAdapter extends BaseAdapter {

    List<BaseCell> list;
    Context context;
    int layout;

    public FuelAdapter(Context context, int layout, List<BaseCell> list) {
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
        ImageView imageView = convertView.findViewById(R.id.cell_addFuel_imageView);
        Drawable res = context.getResources().getDrawable(list.get(position).getIconName());
        imageView.setImageDrawable(res);
        EditText editText = convertView.findViewById(R.id.cell_addFuel_editText);
        editText.setHint(list.get(position).getPlaceHolder());
        return convertView;
    }
}
