package com.example.gesco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

        Button button_alarm = (Button) findViewById(R.id.button_testalarm);
        button_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_PatientActivity.this, TestAlarmActivity.class);
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



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_patient);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
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
                //redirects to email
                else if(id==R.id.nav_message){
                    //Intent intent = new Intent(UserActivity.this, RegistrationActivity.class);
                   // startActivity(intent);
                    //Toast.makeText(getApplicationContext(),"Wait for Shen Tong- under construction :)",Toast.LENGTH_SHORT).show();
                    // Send an email below
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","abc@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    return true;
                }
                else if(id==R.id.nav_reminder) {
                    //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("557"));dooe not work without setdata
                    //startActivity(intent);
                    //return true;
                    Intent intent = new Intent(User_PatientActivity.this, ReminderActivity.class);
                    startActivity(intent);
                    return true;
                }
                // Starts the customer service page
                else if(id==R.id.nav_Customerserv) {
                   // Intent intent = new Intent(UserActivity.this, MainActivity.class);
                   //Toast.makeText(getActivity(), "This is my Toast message!",
                            //Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Wait for Shen Tong- under construction :)",Toast.LENGTH_SHORT).show();
                    return true;
                }
                // menubar function when pressed calls doctor
                else if(id==R.id.nav_calldoctor) {
                    //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("557"));dooe not work without setdata
                    //startActivity(intent);
                    //return true;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:555"));
                    startActivity(intent);
                }
                // menubar function when emergency call
                else if(id==R.id.nav_emergcall) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:555"));
                    startActivity(intent);
                    return true;
                }
                // menubar function when signout clicked
                else if(id==R.id.nav_signout) {
                    Intent intent = new Intent(User_PatientActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }

                return true;
            }
        });











    }

}