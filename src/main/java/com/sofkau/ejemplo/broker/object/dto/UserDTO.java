package com.sofkau.ejemplo.broker.object.dto;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String ciudad;

    public String serializar() {
        return new Gson().toJson(this);
    }

    private UserDTO deserializar(String userJson) {
        return new Gson().fromJson(userJson, UserDTO.class);
    }

    public static UserDTO of(String userJson) {
        return new UserDTO().deserializar(userJson);
    }
}
