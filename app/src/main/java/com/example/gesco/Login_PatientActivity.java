package com.example.gesco;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gesco.inputtypes.LoginRequest;
import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.LoginResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);

        EditText usernameOrEmailField = ((EditText)findViewById(R.id.editTextLoginUsernameOrEmail));
        EditText passwordField = ((EditText)findViewById(R.id.editTextLoginPassword));

        ImageButton button_ques =(ImageButton) findViewById(R.id.button_question);
        button_ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.goolge.com"));
                startActivity(intent);
            }
        });

        Button button_back = (Button) findViewById(R.id.button_back_patient);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button buttonLogin = (Button) findViewById(R.id.button_login2);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://gesco-backend.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);

                Call<LoginResponse> loginCall = dbApi.login(new LoginRequest(usernameOrEmailField.getText().toString(), passwordField.getText().toString())); // replace hardcoded values for user inputs

                loginCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (!response.isSuccessful()) {
                            APIError err = ErrorHandler.parseError(response);
                            String errorMessage = err.message();
                            // display error message
                            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                        } else {
                            String token = response.body().getToken();

                            Intent intent = new Intent(Login_PatientActivity.this, User_PatientActivity.class);
                            intent.putExtra("USER_TOKEN", token);

                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        String errorMessage = t.getMessage();
                        // display error message
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}