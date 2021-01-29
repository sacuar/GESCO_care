package com.example.gesco;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gesco.inputtypes.RegisterRequest;
import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.RegisterResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        Button button_continue = (Button) findViewById(R.id.button_Continue);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // THE CODE FOR REGISTERING
        // should be called inside the registration submit handler

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gesco-backend.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);
//
//        Call<RegisterResponse> registerCall = dbApi.register(new RegisterRequest("tommy12", "tom@tom.com", "tommy12")); // replace hardcoded values for user inputs
//
//        registerCall.enqueue(new Callback<RegisterResponse>() {
//            @Override
//            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
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
//            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                String errorMessage = t.getMessage();
//                // display error message somewhere
//            }
//        });
    }
}