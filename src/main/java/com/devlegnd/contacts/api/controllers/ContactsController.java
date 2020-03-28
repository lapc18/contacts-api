package com.devlegnd.contacts.api.controllers;

import com.devlegnd.contacts.api.domain.entities.Contact;
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

    @PostMapping(value = "/")
    public ResponseEntity<?> addOrUpdateContact(@PathVariable("email") String email, @RequestBody Contact contact) {
        if(contact == null || !this.loginService.existsUserByEmail(email))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        final Contact result = this.service.addOrUpdateContact(email, contact);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") long id) {
        this.service.deleteContact(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
