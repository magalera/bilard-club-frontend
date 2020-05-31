package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.BilliardsSoccer;

public class BilliardsSoccerService {

    private static String URL_PATH = "/v1/bilardSoccer";

    private static BilliardsSoccerService instance;

    private BilliardsSoccerService() {
    }

    public static BilliardsSoccerService getInstance() {
        if (instance == null) {
            instance = new BilliardsSoccerService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BilliardsSoccer add(BilliardsSoccer billiardsSoccer) {
        return null;
    }

    //@GetMapping("/{id}")
    public BilliardsSoccer get(Long id) {
        return null;

    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public BilliardsSoccer update(BilliardsSoccer billiardsSoccer) {
        return null;

    }

    //@DeleteMapping("/{id}")
    public void delete(Long id) {
    }
}
