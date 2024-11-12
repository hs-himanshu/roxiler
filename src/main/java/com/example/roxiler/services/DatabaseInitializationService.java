package com.example.roxiler.services;

import com.example.roxiler.models.ProductTransaction;
import com.example.roxiler.repositories.ProductTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class DatabaseInitializationService {
    private final ProductTransactionRepository productTransactionRepository;
    public DatabaseInitializationService(ProductTransactionRepository productTransactionRepository) {
        this.productTransactionRepository = productTransactionRepository;
    }
    public void initializeDatabase() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://s3.amazonaws.com/roxiler.com/product_transaction.json";
        ProductTransaction[] productTransactions = restTemplate.getForObject(url, ProductTransaction[].class);
        System.out.println("Before Saving");
        if(productTransactions != null){
            productTransactionRepository.saveAll(Arrays.asList(productTransactions));
            System.out.println("After Saving");
        }
    }
}
