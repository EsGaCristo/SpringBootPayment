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

@Id    
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

//Identificador unico de la transaccion del negocion
private String reference; 

// Numero de cuenta bancaria del cliente
private String accountIban;

//Monto de la transaccion, si el valor es negativo sera un debito
private double amount;

// Comision de la transaccion
private double fee;

// Descripcion de la transaccion
private String description;

//Pues la fecha
private Date date;

// Pendiente, liquidada,rechazada, cancelada
@Enumerated(EnumType.ORDINAL)
private Status status;

//Medio por el que se hizo (web,cajero,oficina)
@Enumerated(EnumType.ORDINAL)
private Channel channel;

}
