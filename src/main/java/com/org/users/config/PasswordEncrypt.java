package com.org.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncrypt {

    @Bean
    public BCryptPasswordEncoder encryptPassword(){
        return new BCryptPasswordEncoder();
    }
}
