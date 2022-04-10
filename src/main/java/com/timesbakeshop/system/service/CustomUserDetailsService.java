package com.timesbakeshop.system.service;

import com.timesbakeshop.system.model.Permission;
import com.timesbakeshop.system.model.Role;
import com.timesbakeshop.system.model.User;
import com.timesbakeshop.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s could not be found.")));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), user.isEnabled(), user.isEnabled(), user.isEnabled(),
                getAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return getGrantedAuthorities(getPrivileges(role));
    }

    private List<String> getPrivileges(Role role) {
        return role.getPermissions().stream().map(Permission::getName).collect(Collectors.toList());
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissionNames) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissionNames) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        return authorities;
    }

}
