package com.doancuoiky.myxe;

import android.os.Bundle;
import android.view.Window;

import com.doancuoiky.myxe.model.NetworkAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_xe,R.id.navigation_castro, R.id.navigation_petro, R.id.navigation_km)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        testAPI();
    }

    public void testAPI() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    JSONObject object = new JSONObject();
                    object.put("username", "tester");
                    object.put("password", "123456");
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("GetAllItem", object.toString()).get();
                    System.out.println("Response testAPI = " + response);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();

    }

}