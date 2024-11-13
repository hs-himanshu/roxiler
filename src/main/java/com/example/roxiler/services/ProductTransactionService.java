package com.example.roxiler.services;

import com.example.roxiler.dtos.CategoryDTO;
import com.example.roxiler.dtos.PriceRangeDTO;
import com.example.roxiler.dtos.StatisticsDTO;
import com.example.roxiler.models.ProductTransaction;
import com.example.roxiler.repositories.ProductTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTransactionService {
    private final ProductTransactionRepository repository;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
//    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

    public List<ProductTransaction> listTransactions(int month, String search, Pageable pageable) {
        Page<ProductTransaction> page;

        if (search != null && !search.isEmpty()) {
            page = repository.findByMonthAndSearch(month, search, pageable);
        } else {
            page = repository.findByMonth(month, pageable);
        }

        return page.getContent();
    }

    public boolean isTransactionInMonth(String dateString, int month) {
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date.getMonthValue() == month;
    }

    public StatisticsDTO getStatistics(int month) {
        List<ProductTransaction> transactions = repository.findAll();

        double totalSaleAmount = 0;
        int totalSoldItems = 0;
        int totalNotSoldItems = 0;

        for (ProductTransaction transaction : transactions) {
//            LocalDateTime saleDate = LocalDateTime.parse(transaction.getDateOfSale(), formatter);
            if (transaction.getDateOfSale().getMonthValue() == month) {
                if (transaction.isSold()) {
                    totalSaleAmount += transaction.getPrice();
                    totalSoldItems++;
                } else {
                    totalNotSoldItems++;
                }
            }
        }

        return new StatisticsDTO(totalSaleAmount, totalSoldItems, totalNotSoldItems);
    }

    public List<PriceRangeDTO> getPriceRangeData(int month) {
        List<ProductTransaction> transactions = repository.findAll();
        int[] priceRangeCounts = new int[10];

        for (ProductTransaction transaction : transactions) {
            if (transaction.getDateOfSale().getMonthValue() == month) {
                double price = transaction.getPrice();
                if (price <= 100) priceRangeCounts[0]++;
                else if (price <= 200) priceRangeCounts[1]++;
                else if (price <= 300) priceRangeCounts[2]++;
                else if (price <= 400) priceRangeCounts[3]++;
                else if (price <= 500) priceRangeCounts[4]++;
                else if (price <= 600) priceRangeCounts[5]++;
                else if (price <= 700) priceRangeCounts[6]++;
                else if (price <= 800) priceRangeCounts[7]++;
                else if (price <= 900) priceRangeCounts[8]++;
                else priceRangeCounts[9]++;
            }
        }

        List<PriceRangeDTO> priceRanges = new ArrayList<>();
        priceRanges.add(new PriceRangeDTO("0 - 100", priceRangeCounts[0]));
        priceRanges.add(new PriceRangeDTO("101 - 200", priceRangeCounts[1]));
        priceRanges.add(new PriceRangeDTO("201 - 300", priceRangeCounts[2]));
        priceRanges.add(new PriceRangeDTO("301 - 400", priceRangeCounts[3]));
        priceRanges.add(new PriceRangeDTO("401 - 500", priceRangeCounts[4]));
        priceRanges.add(new PriceRangeDTO("501 - 600", priceRangeCounts[5]));
        priceRanges.add(new PriceRangeDTO("601 - 700", priceRangeCounts[6]));
        priceRanges.add(new PriceRangeDTO("701 - 800", priceRangeCounts[7]));
        priceRanges.add(new PriceRangeDTO("801 - 900", priceRangeCounts[8]));
        priceRanges.add(new PriceRangeDTO("901 and above", priceRangeCounts[9]));

        return priceRanges;
    }

    public List<CategoryDTO> getCategoryData(int month) {
        // Implement unique categories with item counts
        return null;
    }
}
