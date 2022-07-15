package com.sofkau.ejemplo.broker.object.consumer;

import com.sofkau.ejemplo.broker.object.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitObjectConsumer {
    @RabbitListener(queues = {"${colas-objetos.juan.name}"})
    public void recibirMensajeJuanObjeto(Message<String> message) {
        log.info("Mensaje que llego: {}", message.getPayload());
        UserDTO userDTO = UserDTO.of(message.getPayload());
        log.info("Objeto convertido: {}", userDTO);
    }
}
