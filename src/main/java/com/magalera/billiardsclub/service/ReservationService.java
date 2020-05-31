package com.magalera.billiardsclub.service;

import com.magalera.billiardsclub.domain.Reservation;

public class ReservationService {

    private static String URL_PATH = "/v1/reservation";

    private static ReservationService instance;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    //@PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Reservation create(Reservation reservationDto){
        return null;
    }

    //@GetMapping("/{id}")
    public Reservation show(Long id){
        return null;
    }

    //@PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Reservation update(Reservation reservationDto){
        return null;
    }

    //@DeleteMapping("/{id}")
    public void cancel(Long id){
    }
}
