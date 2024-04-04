package com.example.facultyportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText facultyName, noOfStudent;
    RadioGroup rg;
    Spinner courseName, sectionHandle;
    String selectedCourse, selectedSection;
    String[] coursesListed = {"App dev", "Blockchain", "Dip"};
    String[] sectionListed = {"8CSE1", "8CSE2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        facultyName = findViewById(R.id.fname);
        noOfStudent = findViewById(R.id.getNstudent);
        courseName = findViewById(R.id.getCourseName);
        sectionHandle = findViewById(R.id.getSection);

        ArrayAdapter<String> fetchCourseName = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coursesListed);
        fetchCourseName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseName.setAdapter(fetchCourseName);
        courseName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCourse = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //ignore
            }
        });

        ArrayAdapter<String> fetchSection = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sectionListed);
        fetchSection.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectionHandle.setAdapter(fetchSection);
        sectionHandle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSection = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    // ignore
            }
        });
    }
    public void submitActivity(View v) {
        Intent intent = new Intent(getApplicationContext(), ResultPage.class);
        String fname = facultyName.getText().toString();
        Double studentAttended = Double.parseDouble(noOfStudent.getText().toString());
//        String nOfStudent = noOfStudent.getText().toString();
        intent.putExtra("FNAME", fname);
        intent.putExtra("SAttended", studentAttended);
        intent.putExtra("COURSE", selectedCourse);
        intent.putExtra("SECTION", selectedSection);
        startActivity(intent);
    }
}