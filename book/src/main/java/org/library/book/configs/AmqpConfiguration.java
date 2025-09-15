package org.library.book.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    public TopicExchange libraryExchange(@Value("${amqp.exchange.name}") String exchangeName) {
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Queue orderQueue(@Value("${amqp.queue.name}") String queueName) {
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    @Bean
    public Binding binding(TopicExchange exchange, Queue queue) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("order.placed");
    }

    // JSON converter for message payloads
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

