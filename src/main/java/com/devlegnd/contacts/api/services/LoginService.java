package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.entities.Login;
import com.devlegnd.contacts.api.domain.interfaces.ILoginService;
import com.devlegnd.contacts.api.repositories.ILoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService
{

    @Autowired
    private ILoginRepository repository;

    @Override
    public Login getUser(String email) {
        return repository.findAll().get(0);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return repository.findAll().get(0) != null;
    }
}
