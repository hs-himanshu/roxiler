package com.example.roxiler.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDTO {
    private double totalSaleAmount;
    private int totalSoldItems;
    private int totalUnsoldItems;

}
