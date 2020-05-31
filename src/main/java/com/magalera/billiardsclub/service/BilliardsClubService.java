package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.BilliardsClub;

public class BilliardsClubService {

    private static String URL_PATH = "/v1/bilardClub";

    private static BilliardsClubService instance;

    private BilliardsClubService() {
    }

    public static BilliardsClubService getInstance() {
        if (instance == null) {
            instance = new BilliardsClubService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BilliardsClub add(BilliardsClub billiardsClub) {
        return null;
    }

    //@GetMapping("/{id}")
    public BilliardsClub get(Long id) {
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public BilliardsClub update(BilliardsClub billiardsClub) {
        return null;
    }

    //@DeleteMapping("/{id}")
    public void delete(Long id) {
    }
}
