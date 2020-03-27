package com.devlegnd.contacts.api.domain.interfaces;

import com.devlegnd.contacts.api.domain.entities.User;

public interface ILoginService {

    User getUser(String email);

    boolean existsUserByEmail(String email);

    boolean validate(String email, String pwd);

}
