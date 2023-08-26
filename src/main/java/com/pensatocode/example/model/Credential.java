package com.pensatocode.example.model;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Credential {
    private String username;
    private Key secret;

    public Credential(String username, Key secret) {
        this.username = username;
        this.secret = secret;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Key getSecret() {
        return secret;
    }

    public void setSecret(Key secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", secret='" + new String(secret.getEncoded(), StandardCharsets.UTF_8) + '\'' +
                '}';
    }
}
