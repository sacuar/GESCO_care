package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration_SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__select);

        Button button1 = (Button) findViewById(R.id.button_patient_login_re);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration_SelectActivity.this, Registration_PatientActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_doctor_login_re);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration_SelectActivity.this, Registration_DoctorActivity.class);
                startActivity(intent);
            }
        });

        Button button_back = (Button) findViewById(R.id.button_back_re);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}