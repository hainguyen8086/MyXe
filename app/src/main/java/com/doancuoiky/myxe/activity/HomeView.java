package com.doancuoiky.myxe.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.ui.linhkien.FLinhKien;
import com.doancuoiky.myxe.ui.nhot.FNhot;
import com.doancuoiky.myxe.ui.xang.FXang;
import com.doancuoiky.myxe.ui.xang.XangFragment;
import com.doancuoiky.myxe.ui.xe.FXe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeView extends AppCompatActivity implements FXe.OnFragmentInteractionListener, FXang.OnFragmentInteractionListener,
        FNhot.OnFragmentInteractionListener, FLinhKien.OnFragmentInteractionListener{

    public static BottomNavigationView navigationView;
    public static Fragment[] fragments = {null, null, null, null, null};
    public static int tagFra = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragments[0] = new FXe();
        setTitle("Danh sách xe");
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_frame, fragments[0], "first").commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragments[0], "first").commit();
        tagFra = 0;
        getSupportFragmentManager().beginTransaction().addToBackStack("first");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            String currentTitle = getTitle().toString();
            switch (item.getItemId()) {
                case R.id.navigation_xe:
                    setTitle("Danh sách xe");
                    if (fragments[0] == null) {
                        fragments[0] = new FXe();
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).add(R.id.fragment_frame, fragments[0]).commit();
                    }
                    else {
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).show(fragments[0]).commit();
                    }
                    getSupportFragmentManager().beginTransaction().addToBackStack("first");
                    tagFra = 0;
                    return true;
                case R.id.navigation_petro:
                    setTitle("Đổ xăng");
                    if (fragments[1] == null) {
                        fragments[1] = new XangFragment();
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).add(R.id.fragment_frame, fragments[1]).commit();
                    }
                    else {
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).show(fragments[1]).commit();
                    }
                    getSupportFragmentManager().beginTransaction().addToBackStack("second");
                    tagFra = 1;
                    return true;
                case R.id.navigation_castro:
                    setTitle("Thay nhớt");
                    if (fragments[2] == null) {
                        fragments[2] = new FNhot();
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).add(R.id.fragment_frame, fragments[2]).commit();
                    }
                    else {
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).show(fragments[2]).commit();
                    }
                    getSupportFragmentManager().beginTransaction().addToBackStack("three");
                    tagFra = 2;
                    return true;
                case R.id.navigation_km:
                    setTitle("Thay linh kiện");
                    if (fragments[3] == null) {
                        fragments[3] = new FLinhKien();
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).add(R.id.fragment_frame, fragments[3]).commit();
                    }
                    else {
                        getSupportFragmentManager().beginTransaction().hide(fragments[tagFra]).show(fragments[3]).commit();
                    }
                    getSupportFragmentManager().beginTransaction().addToBackStack("four");
                    tagFra = 3;
                    return true;
            }
            return false;
        }
    };
}