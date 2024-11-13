package com.example.roxiler.services;

import com.example.roxiler.dtos.CategoryDTO;
import com.example.roxiler.dtos.PriceRangeDTO;
import com.example.roxiler.dtos.StatisticsDTO;
import com.example.roxiler.models.ProductTransaction;
import com.example.roxiler.repositories.ProductTransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductTransactionService {
    private final ProductTransactionRepository repository;

    public ProductTransactionService(ProductTransactionRepository repository) {
        this.repository = repository;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

//    public List<ProductTransaction> listTransactions(int month, String search, Pageable pageable) {
//        Page<ProductTransaction> page;
//
//        if (search != null && !search.isEmpty()) {
//            page = repository.findByMonthAndSearch(month, search, pageable);
//        } else {
//            page = repository.findByMonth(month, pageable);
//        }
//
//        return page.getContent();
//    }
//
//    public boolean isTransactionInMonth(String dateString, int month) {
//        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
//        return date.getMonthValue() == month;
//    }
    public List<ProductTransaction> listTransactions(int month, String search, Pageable pageable) {
        Page<ProductTransaction> page;

        if (search != null && !search.isEmpty()) {
            page = repository.findByMonthAndSearch(month, search, pageable);
        } else {
            page = repository.findByMonth(month, pageable);
        }

        return page.getContent();
    }
    public StatisticsDTO getStatistics(int month) {
        // Calculate total sale amount, sold items, and unsold items
        return null;
    }

    public List<PriceRangeDTO> getPriceRangeData(int month) {
        // Implement bar chart logic for price ranges
        return null;
    }

    public List<CategoryDTO> getCategoryData(int month) {
        // Implement unique categories with item counts
        return null;
    }
}
