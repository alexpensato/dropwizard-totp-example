package com.pensatocode.example.model;

public class Credential {
    private String username;
    private String secretKey;

    public Credential() {
        super();
    }

    public Credential(String username, String secretKey) {
        this.username = username;
        this.secretKey = secretKey;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}
