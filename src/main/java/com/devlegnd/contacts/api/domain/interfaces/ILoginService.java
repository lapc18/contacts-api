package com.devlegnd.contacts.api.domain.interfaces;

import com.devlegnd.contacts.api.domain.entities.Login;

public interface ILoginService {

    Login getUser(String email);

    boolean existsUserByEmail(String email);

}
