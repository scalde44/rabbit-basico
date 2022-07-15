package com.sofkau.ejemplo.broker.basico.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitBasicPublisher {
    @Value("${colas-basicas.exchange}")
    private String exchange;
    @Value("${colas-basicas.juan.routing.key}")
    private String juanRoutingKey;
    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToJuan(String message) {
        log.info("Mensaje para enviar: {}", message);
        this.rabbitTemplate.convertAndSend(exchange, juanRoutingKey, message);
    }
}
