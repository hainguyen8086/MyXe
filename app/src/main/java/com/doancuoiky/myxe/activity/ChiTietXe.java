package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.global.GlobalFunction;

public class ChiTietXe extends AppCompatActivity {
    TextView textViewChiTietTenXen,textViewChiTietBienSoXe;
    EditText editTextKM;
    ImageView imgViewDoXang, imgViewThayNhot, imgViewThayLinhKien,imgViewHistoryDoXang,imgViewHistoryThayNhot, imgViewHistoryThayLinhKien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_xe);
        setTitle("Thông tin xe: " + GlobalFunction.selectedXe.getTenXe());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                onBackPressed();
        }
        return true;
    }

    private void init() {
        textViewChiTietTenXen=findViewById(R.id.tv_chitiet_tenxe);
        textViewChiTietBienSoXe = findViewById(R.id.tv_chitiet_bienso);
        editTextKM = findViewById(R.id.edt_chitiet_km);
        imgViewDoXang = findViewById(R.id.imgview_doxang);
        imgViewThayNhot = findViewById(R.id.imgview_thaynhot);
        imgViewThayLinhKien=findViewById(R.id.imgview_thaylinhkien);
        imgViewHistoryDoXang = findViewById(R.id.imgview_doxang_history);
        imgViewHistoryThayNhot = findViewById(R.id.imgview_thaynhot_history);
        imgViewHistoryThayLinhKien=findViewById(R.id.imgview_thaylinhkien_history);
        textViewChiTietTenXen.setText(GlobalFunction.selectedXe.getTenXe());
        textViewChiTietBienSoXe.setText(GlobalFunction.selectedXe.getBienSoXe());
        imgViewHistoryDoXang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietXe.this, LichSuDoXangActivity.class);
                startActivity(intent);
            }
        });
        imgViewHistoryThayNhot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietXe.this, LichSuThayNhotActivity.class);
                startActivity(intent);
            }
        });
        imgViewHistoryThayLinhKien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietXe.this, LichSuThayLinhKienActivity.class);
                startActivity(intent);
            }
        });
    }
}