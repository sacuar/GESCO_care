package com.example.gesco;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gesco.inputtypes.LoginRequest;
import com.example.gesco.inputtypes.RegisterRequest;
import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.LoginResponse;
import com.example.gesco.outputtypes.RegisterResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        ImageButton button_ques =(ImageButton) findViewById(R.id.button_question);
        button_ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.goolge.com"));
                startActivity(intent);
            }
        });

        Button buttonLogin = (Button) findViewById(R.id.button_login2);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        // THE CODE FOR LOGGING IN
        // should be called inside the login submit handler

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gesco-backend.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);
//
//        Call<LoginResponse> loginCall = dbApi.login(new LoginRequest("tommy12", "tommy12")); // replace hardcoded values for user inputs
//
//        loginCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (!response.isSuccessful()) {
//                    APIError err = ErrorHandler.parseError(response);
//                    String errorMessage = err.message();
//                    // display error message somewhere
//                } else {
//                    String token = response.body().getToken();
//                    // do something with the token
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                String errorMessage = t.getMessage();
//                // display error message somewhere
//            }
//        });
    }
}