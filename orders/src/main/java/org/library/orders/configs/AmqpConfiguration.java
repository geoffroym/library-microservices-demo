package org.library.orders.configs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class AmqpConfiguration {
    @Bean
    public TopicExchange topicExchange(
            @Value("${amqp.exchange.name}") final String exchangeName
    ) {
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Queue orderQueue(
            @Value("${amqp.queue.name}") final String queueName
    ) {
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    @Bean
    public Binding orderBinding(
            final TopicExchange exchange,
            final Queue orderQueue
    ) {
        return BindingBuilder
                .bind(orderQueue)
                .to(exchange)
                .with("order.placed"); //"rounds.complete"
    }

    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();

        final MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.getObjectMapper().registerModule(
                new ParameterNamesModule(JsonCreator.Mode.PROPERTIES)
        );
        messageHandlerMethodFactory.setMessageConverter(messageConverter);

        return messageHandlerMethodFactory;
    }

    @Bean
    public RabbitListenerConfigurer rabbitListenerConfigurer(
            final MessageHandlerMethodFactory messageHandlerMethodFactory) {
        return (c) -> c.setMessageHandlerMethodFactory(messageHandlerMethodFactory);
    }

}
