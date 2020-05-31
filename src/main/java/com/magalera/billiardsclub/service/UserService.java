package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.User;

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
    public User registration(User user) {
        return null;
    }

    //@PostMapping("/login")
    public User logIn(User user) {
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public User update(User user) {
        return null;
    }
}
