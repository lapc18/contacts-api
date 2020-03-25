package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.entities.Login;
import com.devlegnd.contacts.api.domain.interfaces.ILoginService;
import com.devlegnd.contacts.api.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private LoginRepository repository;

    @Override
    public Login getUser(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return repository.findByEmail(email) != null;
    }
}
