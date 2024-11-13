package com.example.roxiler.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PriceRangeDTO {
    private String range;
    private int itemCount;
}
