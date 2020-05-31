package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.Prices;

public class PricesService {

    private static String URL_PATH = "/v1/prices";

    private static PricesService instance;

    private PricesService() {
    }

    public static PricesService getInstance() {
        if (instance == null) {
            instance = new PricesService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Prices add(Prices prices) {
        return null;
    }

    //@GetMapping("/{id}")
    public Prices show(Long id) {
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Prices update(Prices prices) {
        return null;
    }

    //@DeleteMapping("/{id}")
    public void delete(Long id) {
    }
}

