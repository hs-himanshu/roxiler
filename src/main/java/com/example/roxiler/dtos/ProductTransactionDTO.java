package com.example.roxiler.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductTransactionDTO {
    private String title;
    private String description;
    private double price;
    private LocalDate dateOfSale;
    private String category;
    private boolean isSold;
}
