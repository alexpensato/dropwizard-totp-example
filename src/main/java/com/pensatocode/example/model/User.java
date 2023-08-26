package com.pensatocode.example.model;

public class User {

    private Long id;
    private PersonalData personalData;
    private Credentials credentials;

    public User() {
        super();
    }

    public User(Long id, PersonalData personalData, Credentials credentials) {
        this.id = id;
        this.personalData = personalData;
        this.credentials = credentials;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "User{" +
                "personalData=" + personalData +
                ", credentials=" + credentials +
                '}';
    }
}
