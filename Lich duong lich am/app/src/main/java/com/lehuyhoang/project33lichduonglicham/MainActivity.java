package com.lehuyhoang.project33lichduonglicham;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView txtInputDate;
    private TextView txtOutputDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInputDate = (TextView) findViewById(R.id.txtinput);
        txtOutputDate = (TextView) findViewById(R.id.txtoutput);

        txtInputDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerpicker();
            }
        });


    }

    private void timerpicker(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                DateCalc s = new DateCalc(dayOfMonth,month+1,year);
                int[] l = s.getLunar();
                System.out.println(s.toString() + " to lunar is: " + l[0] + "/" + l[1] + "/" + l[2]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                calendar.set(year,month,dayOfMonth,0,0);
                txtInputDate.setText(simpleDateFormat.format(calendar.getTime()));
                calendar.set(l[2],l[1]-1,l[0],0,0);
                txtOutputDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },year, month, day);
        datePickerDialog.show();
    }

}
