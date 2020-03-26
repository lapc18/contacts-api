package com.devlegnd.contacts.api.repositories;

import com.devlegnd.contacts.api.domain.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Long> {

    Login findByEmail(String email);

}
