package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.global.GlobalFunction;
import com.doancuoiky.myxe.model.NetworkAPI;
import com.doancuoiky.myxe.ui.xe.FXe;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class AddItem2 extends AppCompatActivity {

    Button chonngay;
    Button submit;
    EditText editText;
    EditText note;
    ProgressDialog loadingAlert;
    JSONObject parameter = new JSONObject();
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String format = GlobalFunction.formatOnlyDate(calendar.getTime());
            chonngay.setText(format);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadingAlert = new ProgressDialog(this);
        loadingAlert.setTitle("");
        loadingAlert.setMessage("Đang xử lý");
        loadingAlert.setCancelable(false);
        chonngay = findViewById(R.id.additem2_button);
        chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chonngay.getText().toString().equals("Chọn ngày")) {
                    String[] fd = chonngay.getText().toString().split("/");
                    calendar.set(Integer.parseInt(fd[2]), Integer.parseInt(fd[1]) - 1, Integer.parseInt(fd[0]));
                }
                new DatePickerDialog(AddItem2.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        submit = findViewById(R.id.additem2_submit);
        editText = findViewById(R.id.additem2_editText);
        note = findViewById(R.id.additem2_note);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngayMua = chonngay.getText().toString();
                String km = editText.getText().toString();
                int kmHienTai = Integer.parseInt(km);
                String ghiChu = note.getText().toString();
                try {
                    parameter.put("ngayMua", ngayMua);
                    parameter.put("kmHienTai", kmHienTai);
                    parameter.put("ghiChu", ghiChu);
                    addItem();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        try {
            parameter.put("id", getIntent().getStringExtra("bienSoXe"));
            parameter.put("bienSoXe", getIntent().getStringExtra("bienSoXe"));
            parameter.put("tenXe", getIntent().getStringExtra("tenXe"));
            parameter.put("loaiXe", getIntent().getStringExtra("loaiXe"));
            parameter.put("hangXe", getIntent().getStringExtra("hangXe"));
            parameter.put("chuXe", GlobalFunction.loginEmail);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                onBackPressed();
        }
        return true;
    }

    public void addItem() {
        loadingAlert.show();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    NetworkAPI networkAPI = new NetworkAPI();
                    String response = networkAPI.execute("AddItem", parameter.toString()).get();
                    JSONObject result = new JSONObject(response);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println(result.getString("description"));
                                Toast.makeText(AddItem2.this, result.getString("description"), Toast.LENGTH_SHORT).show();
                                back(result.getInt("code") == 0);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingAlert.dismiss();
                    }
                });
            }
        };
        thread.start();
    }

    public void back(boolean success) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        submit.setEnabled(false);
                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (success) {
                            ((FXe) HomeView.fragments[0]).updateMyXe();
                        }
                        finish();
                        onBackPressed();
                    }
                });
            }
        };
        thread.start();
    }

}