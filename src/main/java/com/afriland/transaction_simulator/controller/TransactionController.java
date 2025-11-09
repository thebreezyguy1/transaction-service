package com.afriland.transaction_simulator.controller;

import com.afriland.transaction_simulator.model.Transaction;
import com.afriland.transaction_simulator.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/simulate")
    public Transaction simulateOnce() {
        return service.generateTransaction();
    }

    @GetMapping
    public List<Transaction> all() {
        return service.getAllTransactions();
    }
}
