package com.magalera.billiardsclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class User {
    private Long id;
    private UserType type;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
