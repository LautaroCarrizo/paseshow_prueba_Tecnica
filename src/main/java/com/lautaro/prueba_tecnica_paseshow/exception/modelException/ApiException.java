package com.lautaro.prueba_tecnica_paseshow.exception.modelException;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ApiException {

    private int status;
    private String mensaje;
    private LocalDateTime timestamp;

    public ApiException(int status, String mensaje) {
        this.status = status;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

}
