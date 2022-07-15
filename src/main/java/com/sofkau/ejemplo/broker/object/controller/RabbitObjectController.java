package com.sofkau.ejemplo.broker.object.controller;

import com.sofkau.ejemplo.broker.basico.dto.MensajeDTO;
import com.sofkau.ejemplo.broker.object.dto.UserDTO;
import com.sofkau.ejemplo.broker.object.publisher.RabbitObjectPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rabbit-object")
public class RabbitObjectController {
    private final RabbitObjectPublisher rabbitObjectPublisher;

    @PostMapping("/juan")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MensajeDTO enviarJuan(@RequestBody UserDTO userDTO) {
        this.rabbitObjectPublisher.sendMessageToJuan(userDTO);
        return new MensajeDTO("Enviando mensaje a juan...");
    }
}
