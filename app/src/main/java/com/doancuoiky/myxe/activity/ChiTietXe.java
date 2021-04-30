package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.doancuoiky.myxe.R;

public class ChiTietXe extends AppCompatActivity {
    TextView textViewChiTietTenXen,textViewChiTietBienSoXe;
    EditText editTextKM;
    ImageView imgViewDoXang, imgViewThayNhot, imgViewThayLinhKien,imgViewHistoryDoXang,imgViewHistoryThayNhot, imgViewHistoryThayLinhKien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_xe);
        init();
        Bundle bundle=getIntent().getExtras();
//        bundle.getString("position");
        textViewChiTietTenXen.setText(bundle.getString("putTenXe"));
        textViewChiTietBienSoXe.setText(bundle.getString("putBienSoXe"));
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


    }
}