package com.magalera.billiardsclub.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Prices {
    private Long id;
    private Double tablePrice;
    private Double bilardSoccerPrice;
    private Double tournamentPrice;
}
