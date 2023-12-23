package com.spring.security;

import java.io.Serializable;

public class AuthRequest implements Serializable {
    private final String userName;
    private final String password;

    public AuthRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AuthRequest [userName=" + userName + ", password=" + password + "]";
    }
}
