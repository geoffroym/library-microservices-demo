package config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class AmqpConfiguration {

    @Bean
    public TopicExchange topicExchange(
            @Value("${amqp.exchange.name}") String exchangeName
    ) {
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Queue queue(
            @Value("${amqp.queue.name}") String queueName
    ) {
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(topicExchange)
                .with("order.placed");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
