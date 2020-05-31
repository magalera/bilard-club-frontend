package com.magalera.billiardsclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Prices {
    private Long id;
    private Double tablePrice;
    private Double bilardSoccerPrice;
    private Double tournamentPrice;
}
