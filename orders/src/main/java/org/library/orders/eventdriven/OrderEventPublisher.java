package org.library.orders.eventdriven;

import org.library.orders.model.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//trouble with lombok, had to fix log using LoggerFactory - must look into it
@Service
public class OrderEventPublisher {
    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);

    private final AmqpTemplate amqpTemplate;
    private final String exchangeName;

    public OrderEventPublisher(
            final AmqpTemplate amqpTemplate,
            @Value("${amqp.exchange.name}") final String exchangeName
    ) {
        this.amqpTemplate = amqpTemplate;
        this.exchangeName = exchangeName;
    }

    public void publishOrderPlacedEvent(Orders orders) {
        String routingKey = "order.placed";
        log.info("Publishing order event: {}", orders);
        amqpTemplate.convertAndSend(exchangeName, routingKey, orders);
    }
}