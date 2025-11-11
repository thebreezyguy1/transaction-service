package com.afriland.transaction_simulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

// Minimal DTO for the RabbitMQ event payload
@Data
@AllArgsConstructor
public class TransactionEvent {
    private String transactionReference;
    private String accountId;
    private BigDecimal amount;
    private String currency;
    private String status;
}
