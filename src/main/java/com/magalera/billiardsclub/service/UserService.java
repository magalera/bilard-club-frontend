package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.User;

import java.util.Optional;

public class UserService {

    private static final String URL_PATH = "/v1/user";

    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public User register(User user) {
        return user;
    }

    //@PostMapping("/login")
    public Optional<User> login(String email, String password) {
/*        return Optional.of(User.builder()
                .id(1L)
                .email("asdf@asdf.pl")
                .type(UserType.BILLIARD_PLAYER)
                .firstName("first")
                .lastName("last")
                .build());*/
        return Optional.empty();
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public User update(User user) {
        return null;
    }
}
