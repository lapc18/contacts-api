package com.devlegnd.contacts.domain.interfaces;

import com.devlegnd.contacts.domain.entities.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IContactService {

    List<Contact> findAll();
    Contact findByPhoneNumber(String phoneNumber);
    List<Contact> findByName(String name);
    List<Contact> findByLastName(String lastName);
    Contact findByEmail(String email);
    Contact findByWebsite(String website);
    Contact addContact(Contact contact);
    Contact editContact(Contact contact);
    boolean deleteContact(long id);
}
