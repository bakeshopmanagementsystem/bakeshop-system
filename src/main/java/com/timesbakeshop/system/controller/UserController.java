package com.timesbakeshop.system.controller;

import com.timesbakeshop.system.model.User;
import com.timesbakeshop.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("list")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User saveUser(@RequestBody User payload) {
        return userService.saveUser(payload);
    }

}
