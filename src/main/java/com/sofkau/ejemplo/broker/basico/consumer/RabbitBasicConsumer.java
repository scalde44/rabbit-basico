package com.sofkau.ejemplo.broker.basico.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitBasicConsumer {
    @RabbitListener(queues = {"${colas-basicas.juan.name}"})
    public void consumirMensajeColaJuan(Message<String> mensajeCola) {
        log.info("El mensaje de la cola juan llego: {}", mensajeCola.getPayload());
    }
}
