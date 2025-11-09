package com.afriland.transaction_simulator.service;

import com.afriland.transaction_simulator.model.Transaction;
import com.afriland.transaction_simulator.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionPublisher publisher;

    private Random random = new Random();

    public Transaction generateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setFromAccount("ACC-" + (1000 + random.nextInt(9000)));
        transaction.setToAccount("ACC-" + (1000 + random.nextInt(9000)));
        transaction.setAmount(Math.round((10 + random.nextDouble() * 1000) * 100.0) / 100.0);
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);
        publisher.publishTransaction(transaction);
        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
