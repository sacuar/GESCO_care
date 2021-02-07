package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MedicationActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);


        Button button_back = (Button) findViewById(R.id.button_back2);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button_up_doc = (Button) findViewById(R.id.button_up_doc);
        button_up_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicationActivity.this, PhotoPick.class);
                startActivity(intent);
            }
        });
        Button button_up_patient = (Button) findViewById(R.id.button_up_patient);
        button_up_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicationActivity.this, PhotoPick.class);
                startActivity(intent);

            }
        });
    }
}