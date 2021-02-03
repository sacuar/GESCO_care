package com.example.gesco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Registration_FinishedDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__finished_doctor);

        Button button1 = (Button) findViewById(R.id.button_finish_do);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Registration_FinishedDoctorActivity.this, Login_DoctorActivity.class);
                startActivity(intent);
            }
        });




    }
}