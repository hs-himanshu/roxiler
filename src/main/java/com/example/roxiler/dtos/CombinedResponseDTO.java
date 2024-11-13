package com.example.roxiler.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CombinedResponseDTO {
    private StatisticsDTO statistics;
    private List<PriceRangeDTO> priceRanges;
    private List<CategoryDTO> categories;
}
