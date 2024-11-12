package com.example.roxiler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ProductTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    @Lob
    @Column(columnDefinition = "longblob")
    private String description;
    private String category;
    private String image;
    private boolean isSold;
    private String dateOfSale;
}
