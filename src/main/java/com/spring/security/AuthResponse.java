package com.spring.security;

public class AuthResponse {

    private String token;
    private String role;
    private String username;

    // Add a default constructor
    public AuthResponse() {
    }

    public AuthResponse(String token, String role, String username) {
        this.token = token;
        this.role = role;
        this.username = username;
    }

    // Getter and setter methods

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
