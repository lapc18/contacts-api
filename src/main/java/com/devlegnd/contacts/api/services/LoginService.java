package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.interfaces.ILoginService;
import com.devlegnd.contacts.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService
{

    @Autowired
    private IUserRepository repository;

    @Override
    public User getUser(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return this.getUser(email) != null;
    }

    @Override
    public boolean validate(String email, String pwd) {
        final User user = this.repository.findByEmail(email);
        return user.getPwd().contentEquals(pwd);
    }
}
