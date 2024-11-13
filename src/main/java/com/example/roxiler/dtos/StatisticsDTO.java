package com.example.roxiler.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatisticsDTO {
    private double totalSaleAmount;
    private int totalSoldItems;
    private int totalUnsoldItems;

}
