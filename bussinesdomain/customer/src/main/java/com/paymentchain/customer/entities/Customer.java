/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.customer.entities;


import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
/**
 *
 * @author cristo
 */
@Entity
@Data

public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)  
   private long id;
   private String code; 
   private String name;
   

   private String iban;
   private String surname;
   private String addres;
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade =  CascadeType.ALL, orphanRemoval = true)
   private List<CustomerProduct> products;

   @Transient
   private List<?> transactions;

}
