package com.magalera.billiardsclub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class BilliardsClub {
    private Long id;
    private String name;
    private List<Table> tables;
    private List<BilliardsSoccer> bilardSoccers;
    private Tournament tournament;
    private City city;
    private Prices prices;
}
