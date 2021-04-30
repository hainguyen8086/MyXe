package com.doancuoiky.myxe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.activity.LichSuDoXangActivity;
import com.doancuoiky.myxe.activity.LichSuThayNhotActivity;
import com.doancuoiky.myxe.model.LichSuDoXang;
import com.doancuoiky.myxe.model.LichSuThayLinhKien;
import com.doancuoiky.myxe.model.LichSuThayNhot;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<LichSuDoXang> lichSuDoXang;
    List<LichSuThayNhot> lichSuThayNhot;
    List<LichSuThayLinhKien> lichSuThayLinhKien;
    int type = -1;

    public HistoryAdapter(Context context, int layout, List<LichSuDoXang> lichSuDoXang, List<LichSuThayNhot> lichSuThayNhot,
                          List<LichSuThayLinhKien> lichSuThayLinhKien) {
        this.context = context;
        this.layout = layout;
        this.lichSuDoXang = lichSuDoXang;
        this.lichSuThayNhot = lichSuThayNhot;
        this.lichSuThayLinhKien = lichSuThayLinhKien;
    }

    @Override
    public int getCount() {
        if (lichSuDoXang == null) {
            if (lichSuThayNhot == null) {
                return lichSuThayLinhKien.size();
            } else {
                return lichSuThayNhot.size();
            }
        } else {
            return lichSuDoXang.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (lichSuDoXang == null) {
            if (lichSuThayNhot == null) {
                return lichSuThayLinhKien.get(position);
            } else {
                return lichSuThayNhot.get(position);
            }
        } else {
            return lichSuDoXang.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inf.inflate(layout, null);
        TextView thoiGian = convertView.findViewById(R.id.trangcanhan_timeline_tvtime);
        TextView type = convertView.findViewById(R.id.cell_history_type);
        TextView money = convertView.findViewById(R.id.cell_history_money);
        TextView address = convertView.findViewById(R.id.cell_history_address);
        if (lichSuDoXang == null) {
            if (lichSuThayNhot == null) {
                thoiGian.setText(convertTime(lichSuThayLinhKien.get(position).getThoiGian()));
                type.setText("Tên linh kiện: " + lichSuThayLinhKien.get(position).getTenLinhKien());
                String mn = String.valueOf(lichSuThayLinhKien.get(position).getGiaLinhKien());
                money.setText("Giá: " + mn + " VND");
                address.setText("Địa chỉ: " + lichSuThayLinhKien.get(position).getDiaChi());
            } else {
                thoiGian.setText(convertTime(lichSuThayNhot.get(position).getThoiGian()));
                type.setText("Loại nhớt: " + lichSuThayNhot.get(position).getLoaiNhot());
                String mn = String.valueOf(lichSuThayNhot.get(position).getGiaNhot());
                money.setText("Giá: " + mn + " VND");
                address.setText("Địa chỉ: " + lichSuThayNhot.get(position).getDiaDiem());
            }
        } else {
            thoiGian.setText(convertTime(lichSuDoXang.get(position).getThoiGian()));
            String dt = String.valueOf("Số lit: " + lichSuDoXang.get(position).getDungTich());
            type.setText(dt);
            String mn = String.valueOf(lichSuDoXang.get(position).getTienDoXang());
            money.setText("Giá: " + mn + " VND");
            address.setText("Địa chỉ: " + lichSuDoXang.get(position).getDiaChi());
        }
        return convertView;
    }
    public String convertTime(String time) {
        //20200430_hhmmss
        String[] p = time.split("_");
        String year = p[0].substring(0, 4);
        String month = p[0].substring(4, 6);
        String day = p[0].substring(6, 8);
        String hh = p[1].substring(0, 2);
        String mm = p[1].substring(2, 4);
        String ss = p[1].substring(4, 6);
        return hh + ":" + mm + ":" + ss + " " + day + "/" + month + "/" + year;
    }
}
