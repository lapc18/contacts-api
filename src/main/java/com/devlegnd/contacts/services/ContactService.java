package com.devlegnd.contacts.services;

import com.devlegnd.contacts.domain.entities.Contact;
import com.devlegnd.contacts.domain.interfaces.IContactService;
import com.devlegnd.contacts.domain.interfaces.IContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactsRepository repository;

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        return this.repository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Contact> findByName(String name) {
        return this.repository.findAllByName(name);
    }

    @Override
    public List<Contact> findByLastName(String lastName) {
        return this.repository.findAllByLastName(lastName);
    }

    @Override
    public Contact findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public Contact findByWebsite(String website) {
        return this.repository.findByWebsite(website);
    }

    @Override
    public Contact addContact(Contact contact) {
        try {
            this.repository.save(contact);
        } catch (Exception e) {
            return null;
        }
        return contact;
    }

    @Override
    public Contact editContact(Contact contact) {
        try {
            this.repository.save(contact);
        } catch (Exception e) {
            return null;
        }
        return contact;
    }

    @Override
    public boolean deleteContact(long id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
