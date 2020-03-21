package com.devlegnd.contacts.api.controllers;

import com.devlegnd.contacts.domain.entities.Contact;
import com.devlegnd.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactService service;


    @GetMapping(value = "/")
    public List<Contact> fetchAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{phoneNumber}")
    public Contact getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return this.service.findByPhoneNumber(phoneNumber);
    }

    @GetMapping(value = "/{name}")
    public List<Contact> getByName(@PathVariable("name") String name) {
        return this.service.findByName(name);
    }

    @GetMapping(value = "/{lastName}")
    public List<Contact> getByLastName(@PathVariable("lastName") String lastName) {
        return this.service.findByLastName(lastName);
    }


    @GetMapping(value = "/{email}")
    public Contact getByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }

    @GetMapping(value = "/{website}")
    public Contact getByWebsite(@PathVariable("website") String website) {
        return this.service.findByWebsite(website);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> addOrUpdateContact(@RequestBody Contact contact) {
        boolean b = this.service.addContact(contact) == null;
        if(b) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteContact(@PathVariable("id") long id) {
        return this.service.deleteContact(id);
    }

}
