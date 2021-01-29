package com.example.gesco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gesco.outputtypes.APIError;
import com.example.gesco.outputtypes.MeResponse;
import com.example.gesco.utils.ErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonalData extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gesco-backend.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatabaseAPI dbApi = retrofit.create(DatabaseAPI.class);

        Call<MeResponse> meCall = dbApi.me("1611916993321");

        meCall.enqueue(new Callback<MeResponse>() {
            @Override
            public void onResponse(Call<MeResponse> call, Response<MeResponse> response) {
                if (!response.isSuccessful()) {
                    APIError err = ErrorHandler.parseError(response);
                    textViewResult.setText(err.message());
                } else {
                    MeResponse userData = response.body();
                    textViewResult.setText(
                            "Id: " + userData.getId() + '\n' +
                                    "Username: " + userData.getUsername() + '\n' +
                                    "Email: " + userData.getEmail()
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
