package com.doancuoiky.myxe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doancuoiky.myxe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleViewXeAdapter extends RecyclerView.Adapter<RecycleViewXeAdapter.ViewHolder> {
    private List<String> listTenXe;
    private List<String> listBienSoXe;
    private LayoutInflater mInflater;

    public RecycleViewXeAdapter(Context context, List<String> listTenXe, List<String> listBienSoXe) {
        this.mInflater = LayoutInflater.from(context);
        this.listTenXe = listTenXe;
        this.listBienSoXe = listBienSoXe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.cartview_xe,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String bienSo = listBienSoXe.get(position);
        holder.textViewBienSoXe.setText(bienSo);

        String tenXe = listTenXe.get(position);
        holder.textViewTenXe.setText(tenXe);

    }

    @Override
    public int getItemCount() {
        return listTenXe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBienSoXe;
        TextView textViewTenXe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBienSoXe = itemView.findViewById(R.id.textview_bienso);
            textViewTenXe = itemView.findViewById(R.id.textview_tenxe);
        }
    }
}
