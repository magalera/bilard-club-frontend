package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.Table;

public class TableService {

    private static String URL_PATH = "/v1/table";

    private static TableService instance;

    private TableService() {
    }

    public static TableService getInstance() {
        if (instance == null) {
            instance = new TableService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Table add(Table table) {
        return null;
    }

    //@GetMapping("/{id}")
    public Table get(Long id) {
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Table update(Table table) {
        return null;
    }

    //@DeleteMapping("/{id}")
    public void delete(Long id) {

    }
}
