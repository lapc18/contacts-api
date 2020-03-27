package com.devlegnd.contacts.api.domain.interfaces;

import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.models.UserViewModel;

public interface IUserService {

    UserViewModel getUserByEmail(String email) throws Exception;

    User save(User user);

}
