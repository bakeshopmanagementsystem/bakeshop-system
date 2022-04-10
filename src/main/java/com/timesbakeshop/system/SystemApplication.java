package com.timesbakeshop.system;

import com.timesbakeshop.system.model.Permission;
import com.timesbakeshop.system.model.Role;
import com.timesbakeshop.system.model.User;
import com.timesbakeshop.system.repository.RoleRepository;
import com.timesbakeshop.system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
		return (args) -> {
//			Permission p1 = new Permission("VIEW_USERS", "Get list of users");
//			Role role = new Role();
//			role.setName("ROLE_ADMIN");
//			role.setPermissions(Arrays.asList(new Permission[] { p1 }));
//			roleRepository.save(role);

			// password123
//			User user = new User();
//			user.setUsername("admin");
//			user.setPassword("$2a$04$Pj/9LO8qBsyyl9BDfcOsGucdCIK8lZyW1coGuUMCLc6ANCNWzWYuu");
//			user.setRole(role);
//			userRepository.save(user);
		};
	}

}
