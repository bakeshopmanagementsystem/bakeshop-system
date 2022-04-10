package com.timesbakeshop.system.controller;

import com.timesbakeshop.system.dto.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private static AuthenticationManager authManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody @Validated LoginCredentials payload) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));
        User user = (User) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Logged in successfully.", HttpStatus.OK);
    }

}
