package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gesco.inputtypes.RegisterRequest;
import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.RegisterResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration_PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__patient);

        EditText usernameField = ((EditText)findViewById(R.id.editTextRegisterUsername));
        EditText emailField = ((EditText)findViewById(R.id.editTextRegisterEmail));
        EditText passwordField = ((EditText)findViewById(R.id.editTextRegisterPassword));
        EditText passwordRepeatedField = ((EditText)findViewById(R.id.editTextRegisterPasswordRepeated));

        Button button1 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://gesco-backend.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);

                if(passwordField.getText().toString() != passwordRepeatedField.getText().toString()){
                    Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Call<RegisterResponse> registerCall = dbApi.register(new RegisterRequest(usernameField.getText().toString(), emailField.getText().toString(), passwordField.getText().toString()));

                registerCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (!response.isSuccessful()) {
                            APIError err = ErrorHandler.parseError(response);
                            String errorMessage = err.message();
                            // display error message
                            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                        } else {
                            String token = response.body().getToken();
                            // do something with the token
                            Intent intent = new Intent(Registration_PatientActivity.this, Registration_FinishedPatientActivity.class);
                            intent.putExtra("USER_TOKEN", token);

                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        String errorMessage = t.getMessage();
                        // display error message
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button button_back = (Button) findViewById(R.id.button_back_pa);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}