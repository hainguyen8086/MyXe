package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.adapter.HistoryAdapter;
import com.doancuoiky.myxe.global.GlobalFunction;

public class LichSuThayLinhKienActivity extends AppCompatActivity {
    ListView listView;
    HistoryAdapter historyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_thay_linh_kien);
        setTitle("Lịch sử thay linh kiện");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.fuel_history);
        historyAdapter = new HistoryAdapter(this, R.layout.cell_history, null, null, GlobalFunction.selectedXe.getListLichSuThayLinhKien());
        listView.setAdapter(historyAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                onBackPressed();
        }
        return true;
    }

}