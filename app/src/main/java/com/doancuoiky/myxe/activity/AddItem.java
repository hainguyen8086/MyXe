package com.doancuoiky.myxe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doancuoiky.myxe.R;
import com.doancuoiky.myxe.global.GlobalFunction;

public class AddItem extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    EditText bienso;
    EditText tenxe;
    Button next;
    String bienSoXe;
    String tenXe;
    String loaiXe;
    String hangXe;
    int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView1 = findViewById(R.id.additem_textView1);
        textView2 = findViewById(R.id.additem_textView2);
        bienso = findViewById(R.id.additem_editText1);
        tenxe = findViewById(R.id.additem_editText2);
        next = findViewById(R.id.additem_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step == 1) {
                    bienSoXe = bienso.getText().toString();
                    tenXe = tenxe.getText().toString();
                    if (tenXe != null && bienSoXe != null && !tenXe.isEmpty() && !bienSoXe.isEmpty()) {
                        nextStep2();
                    } else {
                        Toast.makeText(AddItem.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    loaiXe = bienso.getText().toString();
                    hangXe = tenxe.getText().toString();
                    if (loaiXe != null && hangXe != null && !loaiXe.isEmpty() && !hangXe.isEmpty()) {
                        //next Activity
                        System.out.println(bienSoXe);
                        System.out.println(tenXe);
                        System.out.println(loaiXe);
                        System.out.println(hangXe);
                        Intent intent = new Intent(AddItem.this, AddItem2.class);
                        intent.putExtra("bienSoXe", bienSoXe);
                        intent.putExtra("tenXe", tenXe);
                        intent.putExtra("loaiXe", loaiXe);
                        intent.putExtra("hangXe", hangXe);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AddItem.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        GlobalFunction.hideSoftKeyboard(this);
    }

    public void nextStep2() {
        step = 2;
        bienso.setText("");
        tenxe.setText("");
        textView1.setText("Loại xe");
        textView2.setText("Hãng xe");
        bienso.requestFocus();
    }

    public void backStep1() {
        step = 1;
        textView1.setText("Biển số xe");
        textView2.setText("Tên xe của bạn");
        bienso.setText(bienSoXe);
        tenxe.setText(tenXe);
        bienso.requestFocus();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (step == 1) {
                    finish();
                    onBackPressed();
                } else {
                    loaiXe = "";
                    hangXe = "";
                    backStep1();
                }
        }
        return true;
    }
}