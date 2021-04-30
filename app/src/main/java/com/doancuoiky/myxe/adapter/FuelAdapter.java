package com.doancuoiky.myxe.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
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
    public BaseCell getItem(int position) {
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
        //Show image icon từ drawable
        ImageView imageView = convertView.findViewById(R.id.cell_addFuel_imageView);
        Drawable res = context.getResources().getDrawable(list.get(position).getIconName());
        imageView.setImageDrawable(res);
        EditText editText = convertView.findViewById(R.id.cell_addFuel_editText);
        editText.setText(list.get(position).getTitle());
        editText.setHint(list.get(position).getPlaceHolder());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //Mỗi khi edit cần save lại vào list, để có thể lấy những giá trị này từ Fragment
            @Override
            public void afterTextChanged(Editable s) {
                list.get(position).setTitle(s.toString());
            }
        });
        //Các trường số thì set keyboard type Number
        if (position < 3) {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        return convertView;
    }
}
