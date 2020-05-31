package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.City;

public class CityService {

    private static final String URL_PATH = "/v1/city";

    private static CityService instance;

    private CityService() {
    }

    public static CityService getInstance() {
        if (instance == null) {
            instance = new CityService();
        }
        return instance;
    }

    //@GetMapping("/{id}")
    public City get(Long id) {
        return null;
    }
}
