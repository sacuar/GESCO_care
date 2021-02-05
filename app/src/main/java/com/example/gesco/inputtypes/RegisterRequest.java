package com.example.gesco.inputtypes;

public class RegisterRequest {
    public String username;
    public String email;
    public String familyDoctorName;
    public String familyDoctorEmail;
    public String phone;
    public String emergencyPhone;
    public String password;
    public String role;

    public RegisterRequest(
            String username,
            String email,
            String familyDoctorName,
            String familyDoctorEmail,
            String phone,
            String emergencyPhone,
            String password,
            String role
    ){
        this.username = username;
        this.email = email;
        this.familyDoctorName = familyDoctorName;
        this.familyDoctorEmail = familyDoctorEmail;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.password = password;
        this.role = role;
    }
}
