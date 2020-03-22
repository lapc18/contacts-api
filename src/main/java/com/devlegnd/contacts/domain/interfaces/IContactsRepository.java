package com.devlegnd.contacts.domain.interfaces;

import com.devlegnd.contacts.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContactsRepository extends JpaRepository<Contact, Long> {

    Contact findByPhoneNumber(String phoneNumber);
    List<Contact> findAllByName(String name);
    List<Contact> findAllByLastName(String lastName);
    Contact findByEmail(String email);
    Contact findByWebsite(String website);

}
