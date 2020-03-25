package com.devlegnd.contacts.api.domain.models;

public class UserViewModel {

    private String name;
    private String lastName;
    private String email;
    private String profile;
    private String tkn;

    public UserViewModel(String name, String lastName, String email, String profile, String tkn) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.profile = profile;
        this.tkn = tkn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTkn() {
        return tkn;
    }

    public void setTkn(String tkn) {
        this.tkn = tkn;
    }
}
