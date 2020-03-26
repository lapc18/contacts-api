package com.devlegnd.contacts.api.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String pwd;

    @OneToOne(mappedBy = "login", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    public Login(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
