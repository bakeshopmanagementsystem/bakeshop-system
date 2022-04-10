package com.timesbakeshop.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class LoginCredentials {

    @NonNull
    private String username;

    @NonNull
    private String password;

}
