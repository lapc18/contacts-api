package com.devlegnd.contacts.api.controllers;

import com.devlegnd.contacts.api.domain.models.LoginViewModel;
import com.devlegnd.contacts.api.domain.models.UserViewModel;
import com.devlegnd.contacts.api.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @GetMapping(value = "/login")
    public ResponseEntity<UserViewModel> login(@RequestBody LoginViewModel model) {
        return null;
    }

    private void authenticate(String email, String pwd) throws Exception{

    }

}
