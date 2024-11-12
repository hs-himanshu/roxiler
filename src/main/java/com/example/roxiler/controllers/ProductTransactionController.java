package com.example.roxiler.controllers;

import com.example.roxiler.dtos.CategoryDTO;
import com.example.roxiler.dtos.PriceRangeDTO;
import com.example.roxiler.dtos.ProductTransactionDTO;
import com.example.roxiler.dtos.StatisticsDTO;
import com.example.roxiler.services.ProductTransactionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class ProductTransactionController {
    private final ProductTransactionService transactionService;

    public ProductTransactionController(ProductTransactionService transactionService) {
        this.transactionService = transactionService;
    }

//    @GetMapping
//    public List<ProductTransactionDTO> getTransactions(
//            @RequestParam int month,
//            @RequestParam(required = false) String search,
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        return transactionService.listTransactions(month, search, PageRequest.of(page - 1, size));
//    }

    @GetMapping("/statistics")
    public StatisticsDTO getStatistics(@RequestParam int month) {
        return transactionService.getStatistics(month);
    }

    @GetMapping("/bar-chart")
    public List<PriceRangeDTO> getPriceRangeData(@RequestParam int month) {
        return transactionService.getPriceRangeData(month);
    }

    @GetMapping("/pie-chart")
    public List<CategoryDTO> getCategoryData(@RequestParam int month) {
        return transactionService.getCategoryData(month);
    }
//
//    @GetMapping("/combined")
//    public CombinedResponseDTO getCombinedData(@RequestParam int month) {
//        return transactionService.getCombinedData(month);
//    }
}
