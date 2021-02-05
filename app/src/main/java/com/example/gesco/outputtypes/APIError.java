package com.example.gesco.outputtypes;

public class APIError {
    private String message;

    public APIError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
