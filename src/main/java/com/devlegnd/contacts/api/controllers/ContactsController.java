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
    public ResponseEntity<List<Contact>> fetchAll() {
        List<Contact> list = this.service.findAll();
        if(list != null)
            return ResponseEntity.ok(list);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{phoneNumber}")
    public ResponseEntity<Contact> getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {

        if(phoneNumber.isEmpty())
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        Contact contact = this.service.findByPhoneNumber(phoneNumber);
        if(contact != null)
            return ResponseEntity.ok(contact);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Contact>> getByName(@PathVariable("name") String name) {

        if(name.isEmpty())
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        List<Contact> list = this.service.findByName(name);
        if(list != null)
            return ResponseEntity.ok(list);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{lastName}")
    public ResponseEntity<List<Contact>> getByLastName(@PathVariable("lastName") String lastName) {

        if(lastName.isEmpty())
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        List<Contact> list = this.service.findByLastName(lastName);
        if(list != null)
            return ResponseEntity.ok(list);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @GetMapping(value = "/{email}")
    public ResponseEntity<Contact> getByEmail(@PathVariable("email") String email) {
        if(email.isEmpty())
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Contact contact = this.service.findByEmail(email);
        if(contact != null)
            return ResponseEntity.ok(contact);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{website}")
    public ResponseEntity<Contact> getByWebsite(@PathVariable("website") String website) {
        if(website.isEmpty())
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Contact contact = this.service.findByWebsite(website);
        if(contact != null)
            return ResponseEntity.ok(contact);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Contact> addOrUpdateContact(@RequestBody Contact contact) {
        if(contact != null){
            Contact result = this.service.addContact(contact);
            if (result != null)
                return ResponseEntity.ok(result);
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") long id) {
        boolean b = this.service.deleteContact(id);
        if(b)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
