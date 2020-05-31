package com.magalera.billiardsclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@Getter
public class Reservation {
    private Long id;
    private ReservationType type;
    private Timestamp startDate;
    private Timestamp endDate;
    private User user;
}
