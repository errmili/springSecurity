package com.spring.security.dto;

public class ResponseLogin {

    String token;
    String username;
    public ResponseLogin() {
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
