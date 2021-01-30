package com.example.gesco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login_SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__select);

        Button buttonLogin_patient = (Button) findViewById(R.id.button_patient_login);
        buttonLogin_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_SelectActivity.this, Login_PatientActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLogin_doctor = (Button) findViewById(R.id.button_doctor_login);
        buttonLogin_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_SelectActivity.this, Login_DoctorActivity.class);
                startActivity(intent);
            }
        });

        Button button_back = (Button) findViewById(R.id.button_back3);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}