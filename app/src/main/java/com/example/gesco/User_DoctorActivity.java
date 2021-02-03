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

import com.google.android.material.navigation.NavigationView;

public class User_DoctorActivity extends AppCompatActivity {
    private DrawerLayout mdDrawerLayout;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mdDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_doctor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_doctor);
        setSupportActionBar(toolbar);
        mdDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        }



        NavigationView navView = (NavigationView) findViewById(R.id.nav_view_doctor);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.nav_Customerserv_do){
                    Intent intent = new Intent(User_DoctorActivity.this, CustomerServiceActivity.class);

                    startActivity(intent);
                    return true;
                }
                else if(id==R.id.nav_upload) {
                    //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("557"));dooe not work without setdata
                    //startActivity(intent);
                    //return true;
                    Intent intent = new Intent(User_DoctorActivity.this, UploadDocumentActivity.class);
                    startActivity(intent);
                    return true;
                }

                else if(id==R.id.nav_feedback) {
                    //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("557"));dooe not work without setdata
                    //startActivity(intent);
                    //return true;
                    Intent intent = new Intent(User_DoctorActivity.this, FeedbackActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(id==R.id.nav_signout) {
                    finish();
                    Intent intent = new Intent(User_DoctorActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }



                return true;
            }
        });


    }
}



