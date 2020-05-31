package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.Tournament;

public class TournamentService {

    private static final String URL_PATH = "/v1/tournament";

    private static TournamentService instance;

    private TournamentService() {
    }

    public static TournamentService getInstance() {
        if (instance == null) {
            instance = new TournamentService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Tournament add(Tournament tournament) {
        return null;
    }

    //@GetMapping("/{id}")
    public Tournament get(Long id) {
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Tournament update(Tournament tournament) {
        return null;
    }

    //@DeleteMapping("/{id}")
    public void delete(Long id) {
    }
}
