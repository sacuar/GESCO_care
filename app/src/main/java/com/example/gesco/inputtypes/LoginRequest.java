package com.example.gesco.inputtypes;

public class LoginRequest {
    public String usernameOrEmail;
    public String password;

    public LoginRequest(String usernameOrEmail, String password){
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }
}
