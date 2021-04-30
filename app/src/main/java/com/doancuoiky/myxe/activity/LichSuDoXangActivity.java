package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.adapter.HistoryAdapter;
import com.doancuoiky.myxe.global.GlobalFunction;

public class LichSuDoXangActivity extends AppCompatActivity {

    ListView listView;
    HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_do_xang);
        setTitle("Lịch sử đổ xăng");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.fuel_history);
        historyAdapter = new HistoryAdapter(this, R.layout.cell_history, GlobalFunction.selectedXe.getListLichSuDoXang(), null, null);
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