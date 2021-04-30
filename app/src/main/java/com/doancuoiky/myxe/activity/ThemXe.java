package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.model.NetworkAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThemXe extends AppCompatActivity {
    EditText edtId,edtTenXe,edtBienSoXe,edtLoaiXe,edtHangXe,edtNgayMua,edtKilometHienTai, edtGhiChu;
    Button btnThemXeMoi;
    TextView textViewbtnAddXeMoi;
    ArrayList<String> listTenXe;
    ArrayList<String> listBienSoXe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_xe);

        init();
        getAllItem();

        textViewbtnAddXeMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            JSONObject object = new JSONObject();
                            object.put("id", edtId.getText().toString());
                            object.put("tenXe",edtTenXe.getText().toString());
                            object.put("bienSoXe",edtId.getText().toString());
                            object.put("loaiXe",edtLoaiXe.getText().toString());
                            object.put("hangXe",edtHangXe.getText().toString());
                            object.put("ngayMua",edtNgayMua.getText().toString());
                            object.put("kmHienTai",edtKilometHienTai.getText().toString());
//                            object.put("kmHienTai",Integer.parseInt(edtKilometHienTai.getText().toString()));
                            object.put("ghiChu",edtGhiChu.getText().toString());
                            NetworkAPI networkAPI = new NetworkAPI();
                            String response = networkAPI.execute("AddItem", object.toString()).get();
//                            JSONArray jsonArray = new JSONArray(response);
//                            System.out.println(jsonArray);
//                            System.out.println(object.toString());
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getInt("code") == 0) {
                                System.out.println("succes");
                            } else{
                                System.out.println("fail");
                            }
                            System.out.println("Response testAPI = " + response);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });
    }

    private void init() {
        edtId=findViewById(R.id.edt_id);
        edtTenXe = findViewById(R.id.edt_tenxe);
        edtLoaiXe=findViewById(R.id.edt_loaixe);
        edtHangXe=findViewById(R.id.edt_ngaymua);
        edtNgayMua=findViewById(R.id.edt_ngaymua);
        edtKilometHienTai=findViewById(R.id.edt_km);
        edtGhiChu=findViewById(R.id.edt_ghichu);
//        btnThemXeMoi = findViewById(R.id.btn_themxe);
        textViewbtnAddXeMoi = findViewById(R.id.textview_button_saveAdd);


    }
    private void getAllItem() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    JSONObject object = new JSONObject();
                    object.put("username", "tester");
                    object.put("password", "123456");
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("GetAllItem", object.toString()).get();
                    JSONArray jsonArray = new JSONArray(response);
//                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println("jsonAraay==="+jsonArray);

                    System.out.println("Response testAPI = " + response);

                    if (jsonArray != null){
                        String tenXe = "";
                        String bienSo = "";
                        for (int i=0;i<jsonArray.length();i++){
                            try{
                                JSONObject jsonObjectfor=jsonArray.getJSONObject(i);
                                tenXe = jsonObjectfor.getString("tenXe");
                                bienSo = jsonObjectfor.getString("bienSoXe");
                                System.out.println("getJsonObject"+tenXe+"--"+bienSo);
                                listTenXe.add(tenXe);
                                listBienSoXe.add(bienSo);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }
}