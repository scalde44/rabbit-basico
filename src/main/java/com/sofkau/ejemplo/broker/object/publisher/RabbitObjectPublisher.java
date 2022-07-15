package com.sofkau.ejemplo.broker.object.publisher;

import com.sofkau.ejemplo.broker.object.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitObjectPublisher {
    @Value("${colas-objetos.exchange}")
    private String exchange;
    @Value("${colas-objetos.juan.routing.key}")
    private String juanRoutingKey;
    private final RabbitTemplate rabbitTemplate;

    public void sendMessageToJuan(UserDTO userDTO) {
        log.info("Mensaje para enviar objetos: {}", userDTO);
        this.rabbitTemplate.convertAndSend(exchange, juanRoutingKey, userDTO.serializar());
    }
}
