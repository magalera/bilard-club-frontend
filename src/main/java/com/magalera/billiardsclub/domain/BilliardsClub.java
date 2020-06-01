package com.magalera.billiardsclub.domain;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BilliardsClub {
    private Long id;
    private String name;
    private List<Table> tables;
    private List<BilliardsSoccer> bilardSoccers;
    private Tournament tournament;
    private City city;
    private Prices prices;
}
