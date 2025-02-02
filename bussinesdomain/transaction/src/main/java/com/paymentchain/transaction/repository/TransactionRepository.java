package com.paymentchain.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.paymentchain.transaction.entities.Transaction;

/**
 * @author Cristo
 */

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

    @Query("SELECT t FROM Transaction t WHERE t.accountIban = ?1")
    public List<Transaction> findByAccountIban(String accountIban);
}
