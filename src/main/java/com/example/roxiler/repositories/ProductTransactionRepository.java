package com.example.roxiler.repositories;

import com.example.roxiler.models.ProductTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
    // Fetch all transactions based on month and search criteria
//    List<ProductTransaction> findByDateOfSaleMonthAndTitleContainingOrDescriptionContainingOrPrice(
//            int month, String title, String description, double price);

}
