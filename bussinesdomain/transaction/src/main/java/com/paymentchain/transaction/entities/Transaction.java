package com.paymentchain.transaction.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author cristo
 */

@Data
@Entity
public class Transaction {

@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;
private String reference ,accountIban,description;
private Date date;
private double amount, fee;

@Enumerated(EnumType.ORDINAL)
private Status status;

@Enumerated(EnumType.ORDINAL)
private Channel channel;

}
