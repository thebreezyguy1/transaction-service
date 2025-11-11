package com.afriland.transaction_simulator.service;

import com.afriland.transaction_simulator.model.Transaction;
import com.afriland.transaction_simulator.model.TransactionStatus;
import com.afriland.transaction_simulator.model.TransactionType;
import com.afriland.transaction_simulator.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class TransactionScheduler {

    private final TransactionRepository transactionRepository;
    private final TransactionPublisher transactionPublisher;
    private final AtomicLong counter = new AtomicLong();

    @Scheduled(fixedRate = 1000)
    @Transactional
    public void generateAndPublishTransactions() {
        int transactionsToGenerate = 170;
        for (int i = 0; i < transactionsToGenerate; i++) {
            Transaction transaction = new Transaction();
            transactionRepository.save(transaction);
            transactionPublisher.publishTransactionEvent(
                    Transaction.toEvent(transaction)
            );
            counter.incrementAndGet();
        }
        log.info("Total simulated transactions published: {}. Current rate: {}/s", counter.get(), transactionsToGenerate);
    }

    private Transaction createNewTransaction() {
        String accountId = "ACC-" + (counter.get() % 1000 + 1);
        String ref = UUID.randomUUID().toString().substring(0, 15);

        return new Transaction(
                null,
                ref,
                accountId,
                BigDecimal.valueOf(Math.random() * 5000),
                "USD",
                (Math.random() < 0.5 ? TransactionType.DEBIT : TransactionType.CREDIT),
                TransactionStatus.COMMITTED,
                Instant.now()
        );
    }
}
