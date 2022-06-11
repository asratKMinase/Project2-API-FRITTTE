package com.revature.frittte.util.web.dto;

public class LoginCreds {

        private String username;
        private String password;

        // JACKSON REQUIRES A NO ARG CONSTRUCTOR

    public String getEmail() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
