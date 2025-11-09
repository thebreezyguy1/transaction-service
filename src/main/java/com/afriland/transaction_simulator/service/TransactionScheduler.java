package com.afriland.transaction_simulator.service;

import com.afriland.transaction_simulator.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TransactionScheduler {
    @Autowired
    private TransactionService service;

    @Scheduled(fixedRate = 5000) // every 5 seconds
    public void simulateTransactions() {
        Transaction transaction = service.generateTransaction();
        System.out.println("Simulated new transaction: " + transaction);
    }
}
