package com.devlegnd.contacts.api.controllers;

import com.devlegnd.contacts.api.domain.entities.Contact;
import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.models.ContactViewModel;
import com.devlegnd.contacts.api.services.ContactService;
import com.devlegnd.contacts.api.services.LoginService;
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

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<?> fetchAll(@PathVariable("email") String email) {
        if(!this.loginService.existsUserByEmail(email) || email.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        final List<Contact> list = this.service.findAll(email);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/{email}")
    public ResponseEntity<?> addContact(@PathVariable("email") String email, @RequestBody ContactViewModel contact) {
        if(contact == null || !this.loginService.existsUserByEmail(email))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        final Contact entity = new Contact(contact.getProfile(), contact.getFirstName(), contact.getLastName(), contact.getNickName(), contact.getEmail(), contact.getPhoneNumber(), contact.getAddress(), contact.getWebsite(), contact.getRelationship(), contact.getNotes());
        final User user = this.loginService.getUser(email);
        entity.setUser(user);
        this.service.addOrUpdateContact(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<?> updateContact(@PathVariable("email") String email, @RequestBody ContactViewModel contact) {
        if(contact == null || !this.loginService.existsUserByEmail(email))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        final Contact entity = new Contact(contact.getProfile(), contact.getFirstName(), contact.getLastName(), contact.getNickName(), contact.getEmail(), contact.getPhoneNumber(), contact.getAddress(), contact.getWebsite(), contact.getRelationship(), contact.getNotes());
        final User user = this.loginService.getUser(email);
        entity.setUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/delete/{email}/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("email") String email, @PathVariable("id") long id) {
        this.service.deleteContact(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
