package com.apirestmain.com.apirestmain.Models;

/**
 * Created by USER on 3/18/2018.
 */

public class User {

    private String  Name;
    private String  email;
    private String  avatar;
    private String  password;

    public User(String name, String email, String avatar, String password) {
        Name = name;
        this.email = email;
        this.avatar = avatar;
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
