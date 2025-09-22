package org.library.orders.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmqpConfiguration {
    @Bean
    public TopicExchange topicExchange(@Value("${amqp.exchange.name}") String exchangeName) {
        return ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
    }

    @Bean
    public Queue orderQueue(@Value("${amqp.queue.name}") String queueName) {
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(exchange)
                .with("order.placed");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jackson2JsonMessageConverter);
        return template;
    }
}
