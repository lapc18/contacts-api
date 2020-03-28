package com.devlegnd.contacts.api.domain.models;


public class ContactViewModel {

    private String profile;

    private String firstName;

    private String lastName;

    private String nickName;

    private String email;

    private String phoneNumber;

    private String address;

    private String website;

    private String relationship;

    private String notes;

    public ContactViewModel() {
    }

    public ContactViewModel(String profile, String firstName, String lastName, String nickName, String email, String phoneNumber, String address, String website, String relationship, String notes) {
        this.profile = profile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.website = website;
        this.relationship = relationship;
        this.notes = notes;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
