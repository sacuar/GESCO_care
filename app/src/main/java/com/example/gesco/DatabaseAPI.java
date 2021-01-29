package com.example.gesco;

import com.example.gesco.inputtypes.LoginRequest;
import com.example.gesco.inputtypes.RegisterRequest;
import com.example.gesco.outputtypes.LoginResponse;
import com.example.gesco.outputtypes.MeResponse;
import com.example.gesco.outputtypes.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DatabaseAPI {
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest body);

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest body);

    @GET("me")
    Call<MeResponse> me(@Query("token") String token);
}