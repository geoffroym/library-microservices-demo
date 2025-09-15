package org.library.orders.eventdriven;

import lombok.extern.slf4j.Slf4j;
import org.library.orders.model.Orders;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventPublisher {

    private final AmqpTemplate amqpTemplate;
    private final String exchangeName;

    public OrderEventPublisher(
            AmqpTemplate amqpTemplate,
            @Value("${amqp.exchange.name}") String exchangeName) {
        this.amqpTemplate = amqpTemplate;
        this.exchangeName = exchangeName;
    }

    public void publishOrderPlacedEvent(Orders order) {
        String routingKey = "order.placed";
        //log.info("Publishing order event: {}", order);
        amqpTemplate.convertAndSend(exchangeName, routingKey, order);
    }
}
