package com.paymentchain.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author cristo
 */

@Data
@Entity
public class CustomerTransaction {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String reference;
    private double amount;
    private double fee;
    private String status;

}
