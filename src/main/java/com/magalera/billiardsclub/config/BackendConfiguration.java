package com.magalera.billiardsclub.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BackendConfiguration {

    @Value("${backend.api.endpoint}")
    private String backendApiEndpoint;

}
