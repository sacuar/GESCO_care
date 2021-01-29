package com.example.gesco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class User_PatientActivity extends AppCompatActivity {





    private DrawerLayout mDrawerLayout;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_patient);

        Button button_reminds = (Button) findViewById(R.id.button_reminder);
        button_reminds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_PatientActivity.this, ReminderActivity.class);
                startActivity(intent);
            }
        });

        Button button_medi = (Button) findViewById(R.id.button_Medication);
        button_medi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_PatientActivity.this, MedicationActivity.class);
                startActivity(intent);
            }
        });

        Button button_testalarm = (Button) findViewById(R.id.button_testalarm);
        button_testalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_PatientActivity.this, TestAlarmActivity.class);
                startActivity(intent);
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_patient);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);
        }


        NavigationView navView = (NavigationView) findViewById(R.id.nav_view_patient);




        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.nav_personaldata){
                Intent intent = new Intent(User_PatientActivity.this, PersonalData.class);
                startActivity(intent);
                return true;
                }
                else if(id==R.id.nav_message){
                    Intent intent = new Intent(User_PatientActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                    return true;
                }

                
                return true;
            }
        });











    }

}