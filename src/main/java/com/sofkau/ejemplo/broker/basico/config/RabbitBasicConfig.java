package com.sofkau.ejemplo.broker.basico.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitBasicConfig {
    @Value("${colas-basicas.exchange}")
    private String exchange;

    @Value("${colas-basicas.juan.name}")
    private String juanQueue;
    @Value("${colas-basicas.juan.routing.key}")
    private String juanRoutingKey;


    @Bean
    public TopicExchange exchangeColasBasicas() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue queueJuan() {
        return new Queue(juanQueue);
    }

    @Bean
    public Binding bindingJuan() {
        return BindingBuilder
                .bind(queueJuan())
                .to(exchangeColasBasicas())
                .with(juanRoutingKey);
    }
}
