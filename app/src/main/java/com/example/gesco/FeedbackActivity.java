package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Button button_back = (Button) findViewById(R.id.button_back_feedback);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button_feedback = (Button) findViewById(R.id.button_feedback);
        button_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
                whatsappIntent.getStringExtra("Feedback_Body");
                whatsappIntent.setData(Uri.parse("https://chat.whatsapp.com/LfgCvt5vhxpKLym2N2M1Zi"));
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Whatsapp not available", Toast.LENGTH_LONG).show();
                }
                //intent.setData(Uri.parse("http://www.goolge.com"));
                //   startActivity(intent);
            }
        });



    }
}