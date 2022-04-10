package com.timesbakeshop.system.repository;

import com.timesbakeshop.system.dto.UserView;
import com.timesbakeshop.system.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<UserView> findByUsername(String username);

    Optional<UserView> findById(Long userId);

}
