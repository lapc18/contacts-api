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


    @Query(value = "select c.* from contacts c left join users u on u.id = c.user_id where u.email = :email", nativeQuery = true)
    List<Contact> findAllByEmail(@Param("email") String email);

    Contact findById(long id);

}
