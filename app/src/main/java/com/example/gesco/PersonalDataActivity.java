package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.MeResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalDataActivity extends AppCompatActivity {
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        Button button_back = (Button) findViewById(R.id.button_back_pd);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        textViewResult = findViewById(R.id.text_view_result);


        String userToken = getIntent().getStringExtra("USER_TOKEN");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gesco-backend.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);

        Call<MeResponse> meCall = dbApi.me(userToken);

        meCall.enqueue(new Callback<MeResponse>() {
            @Override
            public void onResponse(Call<MeResponse> call, Response<MeResponse> response) {
                if (!response.isSuccessful()) {
                    APIError err = ErrorHandler.parseError(response);
                    textViewResult.setText(err.message());
                } else {
                    MeResponse userData = response.body();
                    textViewResult.setText(
                            "Id: " +'\n'+ userData.getId() + '\n' +'\n'+
                                    "Username: " +'\n'+ userData.getUsername() +'\n'+ '\n' +
                                    "Email: "+'\n' + userData.getEmail()
                    );


                }
            }

            @Override
            public void onFailure(Call<MeResponse> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
