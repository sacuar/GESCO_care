package com.example.gesco.utils;

import com.example.gesco.outputtypes.APIError;

import org.json.JSONObject;

import retrofit2.Response;

public class ErrorHandler {
    public static APIError parseError(Response<?> response) {
        try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            String msg = jObjError.getString("error");

            return new APIError(msg);
        } catch (Exception e) {
            return new APIError(e.getMessage());
        }
    }
}
