package com.example.roxiler.repositories;

import com.example.roxiler.models.ProductTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
    // Filter by month and search term in title or description
    @Query("SELECT pt FROM ProductTransaction pt WHERE MONTH(pt.dateOfSale) = :month AND " +
            "(pt.title LIKE %:search% OR pt.description LIKE %:search%)")
    Page<ProductTransaction> findByMonthAndSearch(int month, String search, Pageable pageable);

    // Filter by month only
    @Query("SELECT pt FROM ProductTransaction pt WHERE MONTH(pt.dateOfSale) = :month")
    Page<ProductTransaction> findByMonth(int month, Pageable pageable);
    // Fetch all transactions based on month and search criteria
//    List<ProductTransaction> findByDateOfSaleMonthAndTitleContainingOrDescriptionContainingOrPrice(
//            int month, String title, String description, double price);

}
