package com.lautaro.prueba_tecnica_paseshow.exception.exceptions;

public class DuplicatedDniException extends RuntimeException {
    public DuplicatedDniException(String mensaje) {
        super(mensaje);
    }
}
