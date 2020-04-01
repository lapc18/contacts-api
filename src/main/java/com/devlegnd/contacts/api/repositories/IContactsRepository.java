package com.devlegnd.contacts.api.repositories;

import com.devlegnd.contacts.api.domain.entities.Contact;
import com.devlegnd.contacts.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContactsRepository extends JpaRepository<Contact, Long> {


    // @Query(value = "select new com.devlegnd.api.domain.entities.Contact(c.id, c.profile, c.first_name, c.last_name, c.nick_name, c.email, c.phone_number, c.address, c.website, c.relationship, c.notes) from contacts c left join c.user_id u where u.email = :email")
    List<Contact> findAllByEmail(@Param("email") String email);

    Contact findById(long id);

}
