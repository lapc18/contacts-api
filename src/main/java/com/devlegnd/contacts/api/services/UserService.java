package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.interfaces.IUserService;
import com.devlegnd.contacts.api.domain.models.UserViewModel;
import com.devlegnd.contacts.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserViewModel getUserByEmail(String email) throws Exception {

        final User user = repository.findByEmail(email);

        if (user == null)
            throw new Exception("No user found...");

        return new UserViewModel(user.getName(), user.getLastName(), user.getEmail(), user.getProfile(), "");
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }
}
