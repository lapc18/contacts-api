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

    @OneToOne(mappedBy = "Login", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

}
