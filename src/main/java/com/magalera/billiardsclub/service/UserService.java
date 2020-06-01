package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.config.BackendConfiguration;
import com.magalera.billiardsclub.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class UserService {

    private static final String URL_PATH = "/v1/user";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BackendConfiguration backendConfiguration;

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public User register(User user) {
        URI url = UriComponentsBuilder.fromHttpUrl(backendConfiguration.getBackendApiEndpoint() + URL_PATH)
                .build().encode().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<User> request = new HttpEntity<>(user, headers);

        return restTemplate.postForEntity(url, request, User.class).getBody();
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
