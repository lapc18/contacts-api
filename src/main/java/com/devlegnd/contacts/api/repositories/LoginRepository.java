package com.devlegnd.contacts.api.repositories;

import com.devlegnd.contacts.api.domain.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByEmail(String email);

}
