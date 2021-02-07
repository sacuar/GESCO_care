package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UploadDocumentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_document);
        Button button_upload = (Button) findViewById(R.id.button_upload);
        button_upload.setOnClickListener(new View.OnClickListener() {
           // @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Attach your files to upload", Toast.LENGTH_LONG).show();
                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setData(Uri.parse("https://chat.whatsapp.com/LfgCvt5vhxpKLym2N2M1Zi"));
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Whatsapp not available", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button button_choose_document = findViewById(R.id.button_choose_document);
        button_choose_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                {
                    String[] mimeTypes =
                            {"application/msword", "text/plain", "application/pdf", "application/zip"};

                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
                        if (mimeTypes.length > 0) {
                            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                        }

                    } else {
                        String mimeTypesStr = "";

                        for (String mimeType : mimeTypes) {

                            mimeTypesStr += mimeType + "|";
                        }
                        intent.setType(mimeTypesStr.substring(0, mimeTypesStr.length() - 1));

                    }

                    startActivityForResult(Intent.createChooser(intent, "ChooseFile"), 100);

                }
                }

        });
        Button button_back = findViewById(R.id.button_back_uploaddocu);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}