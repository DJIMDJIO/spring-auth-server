package com.example.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    UserDetailsService inMemoryUserDetailsManager() {
        var userBuilder = User.builder();
        return new InMemoryUserDetailsManager(
                userBuilder
                        .username("jlong")
                        .password("{bcrypt}$2a$10$oxGFAu6zsyfrlMm4I.lEW.g/4q8Kq5hMn7xtMHGGXOnezgBbn.5ua")
                        .roles("USER")
                        .build(),
                userBuilder
                        .username("rwinch")
                        .password("{bcrypt}$2a$10$oxGFAu6zsyfrlMm4I.lEW.g/4q8Kq5hMn7xtMHGGXOnezgBbn.5ua")
                        .roles("USER", "ADMIN")
                        .build()
        );
    }

}
