package com.devlegnd.contacts.api.controllers;

import com.devlegnd.contacts.api.configuration.JwtUtil;
import com.devlegnd.contacts.api.domain.entities.User;
import com.devlegnd.contacts.api.domain.models.LoginViewModel;
import com.devlegnd.contacts.api.domain.models.RegisterUserViewModel;
import com.devlegnd.contacts.api.domain.models.UserViewModel;
import com.devlegnd.contacts.api.services.JwtUserDetailsService;
import com.devlegnd.contacts.api.services.LoginService;
import com.devlegnd.contacts.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/login")
    public ResponseEntity<UserViewModel> login(@RequestBody LoginViewModel model) throws Exception{
        authenticate(model.getEmail(), model.getPwd());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(model.getEmail());
        final String tkn = jwtUtil.generateToken(userDetails);
        final UserViewModel userViewModel = userService.getUserByEmail(model.getEmail());
        userViewModel.setTkn(tkn);
        return ResponseEntity.ok(userViewModel);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserViewModel model) throws Exception{
        if(this.loginService.existsUserByEmail(model.getEmail()))
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

        final User user = new User(model.getName(), model.getLastName(),  model.getProfile(), model.getEmail(), model.getPwd());
        this.userService.save(user);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(model.getEmail());
        final String tkn = jwtUtil.generateToken(userDetails);
        final UserViewModel userViewModel = userService.getUserByEmail(model.getEmail());
        userViewModel.setTkn(tkn);
        return ResponseEntity.ok(userViewModel);
    }


    private void authenticate(String email, String pwd) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, pwd));
        } catch (DisabledException e) {
            throw new Exception("User disabled...", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials provided...", e);
        }
    }

}
