package com.example.roxiler.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JsonProperty("dateOfSale")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") // Matches the format in the JSON
    private LocalDateTime dateOfSale;
}
