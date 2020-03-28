package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.entities.Contact;
import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.interfaces.IContactService;
import com.devlegnd.contacts.api.domain.interfaces.IUserService;
import com.devlegnd.contacts.api.repositories.IContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    @Autowired
    private IContactsRepository repository;

    @Override
    public List<Contact> findAll(String email) {
        return this.repository.findAllByEmail(email);
    }

    @Override
    public Contact addOrUpdateContact(String email, Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public void deleteContact(long id) {
        final Contact c =  this.repository.findById(id);
        this.repository.delete(c);
    }
}
