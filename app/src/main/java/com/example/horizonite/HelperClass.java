package com.example.horizonite;

public class HelperClass {
    String fullname,username,phonenumber,password,email;

    public HelperClass() {
    }

    public HelperClass(String fullname, String username, String phonenumber, String password, String email) {
        this.fullname = fullname;
        this.username = username;
        this.phonenumber = phonenumber;
        this.password = password;
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
