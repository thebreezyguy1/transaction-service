package com.afriland.transaction_simulator.service;

import com.afriland.transaction_simulator.config.RabbitMqConfig;
import com.afriland.transaction_simulator.model.Transaction;
import com.afriland.transaction_simulator.model.TransactionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionPublisher {
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void publishTransactionEvent(TransactionEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE_NAME,
                RabbitMqConfig.ROUTING_KEY,
                event
        );
    }
}
