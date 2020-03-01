package com.androidcodegeeks.usermanagementsystemapp;

public class Home {
    String fullname;
    String email;
    String phoneN;
    String username;
    String password;
    String gender;

    public Home(String fullname, String email, String phoneN,
                String username, String gender, String password) {
        this.fullname = fullname;
        this.email = email;
        this.phoneN = phoneN;
        this.username = username;
        this.gender = gender;
        this.password = password;
    }

    public Home(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
