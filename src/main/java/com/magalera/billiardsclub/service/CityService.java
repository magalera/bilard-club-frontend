package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.City;

import java.util.Arrays;
import java.util.List;

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

    //@GetMapping()
    public List<City> getAll() {
        return Arrays.asList(new City(1L, "Kielce"), new City(2L, "Warszawa"));
    }

    //@GetMapping("/{id}")
    public City get(Long id) {
        return null;
    }
}
