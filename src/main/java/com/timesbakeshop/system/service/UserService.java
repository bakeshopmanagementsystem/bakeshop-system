package com.timesbakeshop.system.service;

import com.timesbakeshop.system.model.User;

public interface UserService {

    Iterable<User> getUsers();

    User getUserById(Long userId);

    User saveUser(User payload);

}
