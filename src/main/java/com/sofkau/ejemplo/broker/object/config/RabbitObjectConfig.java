package com.sofkau.ejemplo.broker.object.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitObjectConfig {
    @Value("${colas-objetos.exchange}")
    private String exchange;

    @Value("${colas-objetos.juan.name}")
    private String juanQueue;
    @Value("${colas-objetos.juan.routing.key}")
    private String juanRoutingKey;


    @Bean
    public TopicExchange exchangeColasObjetos() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue queueJuanObjeto() {
        return new Queue(juanQueue);
    }

    @Bean
    public Binding bindingJuanObjeto() {
        return BindingBuilder
                .bind(queueJuanObjeto())
                .to(exchangeColasObjetos())
                .with(juanRoutingKey);
    }
}
