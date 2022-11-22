package com.sven.riceapp;

public class UserProfile {
    public String Email;
    public String Name;
    public String Password;

    public UserProfile(String userName, String userEmail, String userPassword){
        this.Name = userName;
        this.Email = userEmail;
        this.Password = userPassword;
    }
}
