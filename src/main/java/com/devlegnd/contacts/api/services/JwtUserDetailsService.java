package com.devlegnd.contacts.api.services;

import com.devlegnd.contacts.api.domain.interfaces.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ILoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(!loginService.existsUserByEmail(s))
            throw new UsernameNotFoundException("User not found with username: " + s);

        final com.devlegnd.contacts.api.domain.entities.User user = loginService.getUser(s);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPwd(), new ArrayList<>());
    }
}
