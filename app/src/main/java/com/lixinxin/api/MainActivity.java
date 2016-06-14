package com.lixinxin.api;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button btn1;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initview();
        initData();
        initEvent();


    }

    private void initview() {

        btn = (Button) findViewById(R.id.btn);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

    }

    private void initData() {


    }

    private void initEvent() {

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                showDatePickerDialog();
                break;
            case R.id.btn1:
                showTimePickerDialog();
                break;
            case R.id.btn2:
                showProgressDialogHorizontal();
                progressDialog.setProgress(100);
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String msg = year + "-" + monthOfYear + "-" + dayOfMonth;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, 2016, 4, 15);
        datePickerDialog.show();
    }


    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String msg = hourOfDay + ":" + minute;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, 12, 12, true);
        timePickerDialog.show();
    }

    ProgressDialog progressDialog;

    private void showProgressDialogHorizontal() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("标题");
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMax(200);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }


}
