package com.example.gesco;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String username;
    private String name;
    private int id;
    private String email;
    @SerializedName("Address")
    private String text;


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getText() {
        return text;
    }


}