package com.example.roxiler.repositories;

import com.example.roxiler.models.ProductTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
    // Filter by month and search term in title or description
    @Query("SELECT pt FROM ProductTransaction pt WHERE MONTH(pt.dateOfSale) = :month AND " +
            "(pt.title LIKE %:search% OR pt.description LIKE %:search%)")
    Page<ProductTransaction> findByMonthAndSearch(int month, String search, Pageable pageable);

    // Filter by month only
    @Query("SELECT pt FROM ProductTransaction pt WHERE MONTH(pt.dateOfSale) = :month")
    Page<ProductTransaction> findByMonth(int month, Pageable pageable);

    @Query("SELECT t FROM ProductTransaction t WHERE FUNCTION('MONTH', t.dateOfSale) = :month")
    List<ProductTransaction> findByMonth(@Param("month") int month);

}
