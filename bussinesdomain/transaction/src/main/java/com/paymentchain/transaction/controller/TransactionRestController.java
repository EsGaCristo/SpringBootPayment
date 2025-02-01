package com.paymentchain.transaction.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.paymentchain.transaction.entities.Status;
import com.paymentchain.transaction.entities.Transaction;
import com.paymentchain.transaction.repository.TransactionRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





/**
 * @author cristo
 */

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping()
    public List<Transaction> list() {
        return transactionRepository.findAll();
    }
    @GetMapping("/{id}")
    public Transaction get(@PathVariable ("id") Long id) {
        return transactionRepository.findById(id).get();
    }
    @GetMapping("/iban")
    public Transaction[] getByIban(@RequestParam ("iban") String iban) {
        transactionRepository.findByAccountIban(iban);
        return transactionRepository.findByAccountIban(iban);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable ("id") Long id, @RequestBody Transaction input) {
        Transaction find = transactionRepository.findById(id).orElseThrow(()-> new RuntimeException("Transaction not found"));
        BeanUtils.copyProperties(input, find,"id");
        Transaction save = transactionRepository.save(find);
        return ResponseEntity.ok(save);
    }
    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Transaction input) {
        transactionsValidated(input);
        Transaction save = transactionRepository.save(input);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Long id){
        transactionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private void  transactionsValidated(Transaction input){
        if(input.getFee()>0){
            input.setAmount(input.getAmount() - input.getFee());
        }
        if(input.getAmount()<0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El monto no puede ser negativo");
        }
        input.setStatus(Status.LIQUIDADA);
        if(input.getDate().compareTo(new Date()) == 1 ){
            input.setStatus(Status.PENDIENTE);
        }  
    }    
}
