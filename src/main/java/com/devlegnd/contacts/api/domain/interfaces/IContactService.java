package com.devlegnd.contacts.api.domain.interfaces;

import com.devlegnd.contacts.api.domain.entities.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> findAll(String email);
    Contact addOrUpdateContact(Contact contact);
    void deleteContact(long id);
}
