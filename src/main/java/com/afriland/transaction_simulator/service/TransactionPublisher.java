package com.afriland.transaction_simulator.service;

import com.afriland.transaction_simulator.model.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionPublisher {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void publishTransaction(Transaction transaction) {
        rabbitTemplate.convertAndSend("transactionQueue", transaction);
        System.out.println("Published transaction: " + transaction);
    }
}
