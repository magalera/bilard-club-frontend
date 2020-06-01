package com.magalera.billiardsclub.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private UserType type;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
