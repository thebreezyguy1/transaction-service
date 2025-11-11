package com.afriland.transaction_simulator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_ledger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, unique = true, nullable = false)
    private String transactionReference;

    @Column(length = 30, nullable = false)
    private String accountId;

    @Column(precision = 19, scale = 4, nullable = false)
    private BigDecimal amount;

    @Column(length = 3, nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TransactionStatus status;

    @Column(nullable = false)
    private Instant timestamp;

    public static TransactionEvent toEvent(Transaction transaction) {
        return new TransactionEvent(
                transaction.getTransactionReference(),
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getStatus().name()
        );
    }
}

