package com.paymentchain.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentchain.transaction.entities.Transaction;

/**
 * @author Cristo
 */

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
