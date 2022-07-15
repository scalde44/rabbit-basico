package com.sofkau.ejemplo.broker.basico.controller;

import com.sofkau.ejemplo.broker.basico.dto.MensajeDTO;
import com.sofkau.ejemplo.broker.basico.publisher.RabbitBasicPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rabbit")
public class RabbitBasicController {
    private final RabbitBasicPublisher rabbitBasicPublisher;

    @PostMapping("/juan")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MensajeDTO enviarJuan(@RequestBody MensajeDTO mensajeDTO) {
        this.rabbitBasicPublisher.sendMessageToJuan(mensajeDTO.getMensaje());
        return new MensajeDTO("Enviando mensaje a juan...");
    }
}
