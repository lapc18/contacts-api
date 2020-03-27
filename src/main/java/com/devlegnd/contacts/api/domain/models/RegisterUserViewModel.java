package com.devlegnd.contacts.api.domain.models;

public class RegisterUserViewModel {

    private String name;
    private String lastName;
    private String email;
    private String pwd;
    private String profile;

    public RegisterUserViewModel(String name, String lastName, String email, String pwd, String profile) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pwd = pwd;
        this.profile = profile;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
