package com.doancuoiky.myxe.ui.xang;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.adapter.FuelAdapter;
import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.BaseCell;
import com.doancuoiky.myxe.model.NetworkAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class XangFragment extends Fragment {

    ListView listView;
    TextView textView;
    Button button;
    List<BaseCell> list = new ArrayList<>();
    FuelAdapter fuelAdapter;
    ProgressDialog loadingAlert;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_xang, container, false);
        listView = root.findViewById(R.id.xang_listView);
        textView = root.findViewById(R.id.xang_textView);
        button = root.findViewById(R.id.xang_button);
        loadingAlert = new ProgressDialog(getActivity());
        loadingAlert.setTitle("");
        loadingAlert.setMessage("Đang xử lý");
        loadingAlert.setCancelable(false);
        setEvent();
        GlobalFunction.hideSoftKeyboard(getActivity());
        if (GlobalFunction.selectedXe != null) {
            textView.setText("Xe đang chọn: " + GlobalFunction.selectedXe.getTenXe());
        } else {
            textView.setText("Bạn chưa chọn xe");
        }
        list.add(new BaseCell(R.drawable.ic_moto, "", "Nhập số tiền đổ xăng"));
        list.add(new BaseCell(R.drawable.ic_dungtich, "", "Nhập số lit xăng đã đổ"));
        list.add(new BaseCell(R.drawable.ic_km, "", "Nhập số km hiện tại"));
        list.add(new BaseCell(R.drawable.ic_map, "", "Địa chỉ cây xăng"));
        renderList();
        return root;
    }

    //Show ListView
    public void renderList() {
        fuelAdapter = new FuelAdapter(getActivity(), R.layout.cell_add_fuel, list);
        listView.setAdapter(fuelAdapter);
    }

    //Handle button khi Click
    public void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GlobalFunction.selectedXe != null) {
                    //Tạo 1 json object -> để truyền body request tới API
                    String[] jsonKey = {"tienDoXang", "dungTich", "kmLucDoXang", "diaChi"};
                    try {
                        JSONObject object = new JSONObject();
                        object.put("id", GlobalFunction.selectedXe.getId());
                        boolean valid = true;
                        //Lấy all value from Edittext trong Listview
                        for (int i = 0; i < fuelAdapter.getCount(); i++) {
                            String value = fuelAdapter.getItem(i).getTitle();
                            if (value == null || value.isEmpty()) {
                                valid = false;
                                break;
                            }
                            //Các trường số thì convert giá trị sang int
                            object.put(jsonKey[i], i < 3 ? Integer.parseInt(value) : value);
                        }
                        //Nếu các editText đều có giá trị thì call API, ngược lại showToast báo
                        if (valid) {
                            addFuelHistory(object);
                        } else {
                            Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception ex) {
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                        ex.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity(), "Vui lòng chọn xe trước khi nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addFuelHistory(JSONObject object) {
        loadingAlert.show();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("AddFuelHistory", object.toString()).get();
                    JSONObject result = new JSONObject(response);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //Show message from API response // thành công hoặc thất bại
                                Toast.makeText(getActivity(), result.getString("description"), Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingAlert.dismiss();
                    }
                });
            }
        };
        thread.start();
    }
}