package com.doancuoiky.myxe.ui.xe;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.adapter.VehicleAdapter;
import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.LichSuDoXang;
import com.doancuoiky.myxe.model.LichSuThayNhot;
import com.doancuoiky.myxe.model.NetworkAPI;
import com.doancuoiky.myxe.model.Xe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FXe extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FXe() {
        // Required empty public constructor
    }

    public static FXe newInstance(String param1, String param2) {
        FXe fragment = new FXe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ConstraintLayout rootView;
    ListView listView;
    VehicleAdapter vehicleAdapter;
    List<Xe> vehicleList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ConstraintLayout ) inflater.inflate(R.layout.fragment_f_xe, container, false);
        listView = rootView.findViewById(R.id.f_xe_listView);
        loadMyVehicle();
        return rootView;
    }

    public void loadMyVehicle() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    JSONObject object = new JSONObject();
                    object.put("email", GlobalFunction.loginEmail);
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("GetAllItem", object.toString()).get();
                    System.out.println("load my vehicle response = \n" + response);
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject item = array.getJSONObject(i);
                        String id = item.getString("id");
                        String tenXe = item.getString("tenXe");
                        String bienSoXe = item.getString("bienSoXe");
                        String loaiXe = item.getString("loaiXe");
                        String hangXe = item.getString("hangXe");
                        String ngayMua = item.getString("ngayMua");
                        int kmHienTai = item.getInt("kmHienTai");
                        String ghiChu = item.getString("ghiChu");
                        String chuXe = item.getString("chuXe");
                        int kmBaoTri = item.getInt("kmBaoTri");
                        String ngayBaoTri = item.getString("ngayBaoTri");
                        Xe xe = new Xe(id, tenXe, bienSoXe, loaiXe, hangXe, ngayMua, kmHienTai, ghiChu, chuXe);
                        xe.setListLichSuDoXang(getFuelList(item.getJSONArray("lichSuDoXang")));
                    }
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public List<LichSuDoXang> getFuelList(JSONArray array) {
        List<LichSuDoXang> list = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                String id = item.getString("id");
                int tienDoXang = item.getInt("tienDoXang");
                int dungTich = item.getInt("dungTich");
                int kmLucDoXang = item.getInt("kmLucDoXang");
                String thoiGian = item.getString("thoiGian");
                String diaChi = item.getString("diaChi");
                LichSuDoXang lichSuDoXang = new LichSuDoXang(id, tienDoXang, dungTich, kmLucDoXang, thoiGian, diaChi);
                list.add(lichSuDoXang);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<LichSuThayNhot> getRenewHistory(JSONArray array) {
        List<LichSuThayNhot> list = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                String id = item.getString("id");
                int kmLucThayNhot = item.getInt("kmLucThayNhot");
                String loaiNhot = item.getString("loaiNhot");
                int giaNhot = item.getInt("giaNhot");
                String thoiGian = item.getString("thoiGian");
                String diaChi = item.getString("diaChi");
                LichSuThayNhot lichSuThayNhot = new LichSuThayNhot(id, kmLucThayNhot, loaiNhot, giaNhot, thoiGian, diaChi);
                list.add(lichSuThayNhot);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }


    public interface OnFragmentInteractionListener {

    }
}