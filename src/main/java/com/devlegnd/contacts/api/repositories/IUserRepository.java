package com.devlegnd.contacts.api.repositories;

import com.devlegnd.contacts.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
