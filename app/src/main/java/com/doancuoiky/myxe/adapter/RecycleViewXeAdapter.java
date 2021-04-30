package com.doancuoiky.myxe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.activity.ChiTietXe;
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

//    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.cartview_xe,parent,false);
//        view.setOnClickListener((View.OnClickListener) this);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewBienSoXe;
        TextView textViewTenXe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewBienSoXe = itemView.findViewById(R.id.textview_bienso);
            textViewTenXe = itemView.findViewById(R.id.textview_tenxe);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), ChiTietXe.class);
            intent.putExtra("position", getLayoutPosition());
            intent.putExtra("putTenXe", listTenXe.get(getLayoutPosition()));
            intent.putExtra("putBienSoXe", listBienSoXe.get(getLayoutPosition()));
            v.getContext().startActivity(intent);

        }
    }
}
