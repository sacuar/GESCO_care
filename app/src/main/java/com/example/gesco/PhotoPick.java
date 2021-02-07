package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PhotoPick extends AppCompatActivity {
    private static final int CHOOSE_FILE_REQUESTCODE = 8777;
   // private static final int PICKFILE_RESULT_CODE = 8778;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pick);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        Intent i = Intent.createChooser(intent, "File");
        startActivityForResult(i, CHOOSE_FILE_REQUESTCODE);
    }
}