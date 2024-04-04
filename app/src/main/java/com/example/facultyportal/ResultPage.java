package com.example.facultyportal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ResultPage extends AppCompatActivity {
    TextView result;
    String handleDate, handleTime;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        result = findViewById(R.id.showResponse);

    }
    public void selectTime(View v) {
        Calendar calendar = Calendar.getInstance();
        int currHour = calendar.get(Calendar.HOUR);
        int currMin = calendar.get(Calendar.MINUTE);
        TimePickerDialog clock = new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        handleTime = hour + ":" + minute;
                    }
                }, currHour, currMin, false);
        clock.show();
    }

    public void selectDate(View v) {
        Calendar calendar = Calendar.getInstance();
        int curY = calendar.get(Calendar.YEAR);
        int currMonth = calendar.get(Calendar.MONTH);
        int currDate = calendar.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                handleDate = dayOfMonth + "/" + (month+1) + "/" + year;
            }
        }, curY, currMonth, currDate);
        dialog.show();
    }
    public void saveDetails(View v) {
        Intent intent = getIntent();
        String fname = intent.getStringExtra("FNAME");
        Double nstudent = intent.getDoubleExtra("SAttended", 0);
        String course = intent.getStringExtra("COURSE");
        String section = intent.getStringExtra("SECTION");
        String res = "";
        Double percent = (nstudent / 60) * 100;
        if(percent > 50)
            res = "Successfully updated!\nName: " + fname + "\nNumber of Student: " + nstudent + "\nCourseHandled: " +
                    course + "\nSectionHandled: " + section + "\nHandledTime: " + handleTime + "\nHandledDate: " + handleDate;
        else
            res = "Very less percentage of student not been Saved!";
        result.setText(percent+"\n"+res);
    }
}